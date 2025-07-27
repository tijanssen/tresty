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
import org.jspecify.annotations.Nullable;

public final class LinkedList<E> implements MutableSequencedCollection<E> {

    private final Node<E> root;
    private int size;

    public LinkedList() {
        root = new Node<>(null);
        root.next = root;
        root.previous = root;
    }

    public LinkedList(final Collection<? extends E> c) {
        this();
        Guard.againstNull(c);
        for (final var element : c) {
            final var last = root.previous;
            final var newNode = new Node<>(element);
            last.next = newNode;
            newNode.previous = last;
            newNode.next = root;
            root.previous = newNode;
        }
        size = c.size();
    }

    @Override
    public void addFirst(final Collection<? extends E> c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFirst(final E e) {
    }

    @Override
    public void addFirst(final java.util.Collection<? extends E> c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addLast(final E e) {
    }

    @Override
    public Optional<E> getFirst() {
        return Optional.of(root.next.value);
    }

    @Override
    public Optional<E> getLast() {
        return Optional.of(root.previous.value);
    }

    @Override
    public MutableSequencedIterator<E> iterator() {
        return null;
    }

    @Override
    public void removeFirst() {
        Guard.againstZero(size);
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

    @SuppressWarnings("checkstyle:VisibilityModifier")
    private static final class Node<E> {

        public Node<E> next;
        public Node<E> previous;
        public E value;

        Node(final @Nullable E value) {
            this.value = value;
        }
    }
}
