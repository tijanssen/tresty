/*-
 * #%L
 * tresty-collections
 * %%
 * Copyright (C) 2025 Timo Janssen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
package io.github.tresty.collections.collection;

import io.github.tresty.collections.iterator.MutableSequencedIterator;
import io.github.tresty.common.Guard;
import java.util.Optional;

public final class LinkedList<E> implements MutableSequencedCollection<E> {

    final LinkedListNode<E> root;
    int size;

    public LinkedList() {
        root = new LinkedListNode<>(null);
        root.next = root;
        root.previous = root;
    }

    public LinkedList(final Collection<? extends E> c) {
        this();
        Guard.againstNull(c);
        for (final var element : c) {
            final var last = root.previous;
            final var node = new LinkedListNode<>(element);
            last.next = node;
            node.previous = last;
            node.next = root;
            root.previous = node;
        }
        size = c.size();
    }

    @SafeVarargs
    public LinkedList(final E... elements) {
        this();
        Guard.againstNull(elements);
        Guard.againstContainsNull(elements);
        for (final var e : elements) {
            final var node = new LinkedListNode<>(e);
            final var last = root.previous;
            last.next = node;
            node.previous = last;
            node.next = root;
            root.previous = node;
        }
        size = elements.length;
    }

    public LinkedList(final java.util.Collection<? extends E> c) {
        this();
        Guard.againstNull(c);
        Guard.againstContainsNull(c);
        for (final var element : c) {
            final var last = root.previous;
            final var node = new LinkedListNode<>(element);
            last.next = node;
            node.previous = last;
            node.next = root;
            root.previous = node;
        }
        size = c.size();
    }

    @Override
    public void add(final Collection<? extends E> c) {
        Guard.againstNull(c);
        for (final var e : c) {
            final var node = new LinkedListNode<>(e);
            final var previous = root.previous;
            previous.next = node;
            node.previous = previous;
            node.next = root;
            root.previous = node;
            size++;
        }
    }

    @Override
    public void add(final java.util.Collection<? extends E> c) {
        Guard.againstNull(c);
        Guard.againstContainsNull(c);
        for (final var e : c) {
            final var node = new LinkedListNode<>(e);
            final var previous = root.previous;
            previous.next = node;
            node.previous = previous;
            node.next = root;
            root.previous = node;
            size++;
        }
    }

    @Override
    public void addFirst(final E e) {
        Guard.againstNull(e);
        final var node = new LinkedListNode<>(e);
        final var next = root.next;
        root.next = node;
        node.previous = root;
        node.next = next;
        next.previous = node;
        size++;
    }

    @Override
    public void addLast(final E e) {
        Guard.againstNull(e);
        final var node = new LinkedListNode<>(e);
        final var previous = root.previous;
        previous.next = node;
        node.previous = previous;
        node.next = root;
        root.previous = node;
        size++;
    }

    @Override
    public MutableSequencedIterator<E> descendingIterator() {
        return new LinkedListIterator<E>(this, true);
    }

    @Override
    public Optional<E> getFirst() {
        return Optional.ofNullable(root.next.value);
    }

    @Override
    public Optional<E> getLast() {
        return Optional.ofNullable(root.previous.value);
    }

    @Override
    public MutableSequencedIterator<E> iterator() {
        return new LinkedListIterator<E>(this, false);
    }

    @Override
    public void removeFirst() {
        Guard.againstZero(size);
        if (size == 0) {
            return;
        }
        final var first = root.next;
        final var newFirst = root.next.next;
        newFirst.previous = root;
        root.next = newFirst;
        first.next = null;
        first.previous = null;
        first.value = null;
        size--;
    }

    @Override
    public void removeLast() {
        Guard.againstZero(size);
        if (size == 0) {
            return;
        }
        final var last = root.previous;
        final var newLast = root.previous.previous;
        newLast.next = root;
        root.previous = newLast;
        last.next = null;
        last.previous = null;
        last.value = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }
}
