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
import java.util.NoSuchElementException;
import org.jspecify.annotations.Nullable;

final class LinkedListIterator<E> implements MutableSequencedIterator<E> {

    private final LinkedList<E> linkedList;
    @Nullable
    private LinkedListNode<E> lastRet;
    private LinkedListNode<E> nextNode;
    private LinkedListNode<E> previousNode;

    LinkedListIterator(final LinkedList<E> linkedList, final boolean descending) {
        this.linkedList = linkedList;
        if (descending) {
            nextNode = linkedList.root;
            previousNode = linkedList.root.previous;
        } else {
            nextNode = linkedList.root.next;
            previousNode = linkedList.root;
        }
    }

    /**
     * Adds the after.
     *
     * @param e the e
     */
    @Override
    public void addAfter(final E e) {
        if (lastRet == null) {
            throw new IllegalStateException();
        }
        final var node = new LinkedListNode<>(e);
        nextNode.previous = node;
        previousNode.next = node;
        lastRet = null;
        previousNode = node;
        linkedList.size++;
    }

    /**
     * Adds the before.
     *
     * @param e the e
     */
    @Override
    public void addBefore(final E e) {
        if (lastRet == null) {
            throw new IllegalStateException();
        }
        final var node = new LinkedListNode<>(e);
        final var p = previousNode;
        p.next = node;
        node.previous = p;
        lastRet.previous = node;
        node.next = lastRet;
        lastRet = null;
        linkedList.size++;
    }

    /**
     * Checks for next.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasNext() {
        return nextNode != linkedList.root;
    }

    /**
     * Checks for previous.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasPrevious() {
        return previousNode != linkedList.root;
    }

    /**
     * Next.
     *
     * @return the e
     */
    @Override
    public E next() {
        if (nextNode == linkedList.root) {
            throw new NoSuchElementException();
        }
        lastRet = nextNode;
        nextNode = nextNode.next;
        previousNode = previousNode.next;
        return lastRet.value;
    }

    /**
     * Previous.
     *
     * @return the e
     */
    @Override
    public E previous() {
        if (previousNode == linkedList.root) {
            throw new NoSuchElementException();
        }
        lastRet = previousNode;
        nextNode = nextNode.previous;
        previousNode = previousNode.previous;
        return lastRet.value;
    }

    /**
     * Removes the.
     */
    @Override
    public void remove() {
        if (lastRet == null) {
            throw new IllegalStateException();
        }
        if (lastRet == previousNode) {
            previousNode = previousNode.previous;
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        } else {
            nextNode = nextNode.next;
            nextNode.previous = previousNode;
            previousNode.next = nextNode;
        }
        lastRet.next = null;
        lastRet.previous = null;
        lastRet.value = null;
        lastRet = null;
        linkedList.size--;
    }

    /**
     * Sets the.
     *
     * @param e the e
     */
    @Override
    public void set(final E e) {
        if (lastRet == null) {
            throw new IllegalStateException();
        }
        lastRet.value = e;
    }
}
