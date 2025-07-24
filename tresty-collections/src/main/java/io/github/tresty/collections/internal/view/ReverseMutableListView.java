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
package io.github.tresty.collections.internal.view;

import java.util.function.Predicate;

import io.github.tresty.collections.collection.Collection;
import io.github.tresty.collections.internal.iterator.ReverseMutableListIterator;
import io.github.tresty.collections.iterator.MutableListIterator;
import io.github.tresty.collections.list.MutableList;
import io.github.tresty.common.Guard;

/**
 * The Class ReverseMutableListView.
 *
 * @param <E> the element type
 */
public final class ReverseMutableListView<E> implements MutableList<E> {

    /**
     * Of.
     *
     * @param <E>  the element type
     * @param list the list
     * @return the mutable list
     */
    public static <E> MutableList<E> of(final MutableList<E> list) {
        if (list instanceof ReverseMutableListView<E> l) {
            return l.list;
        } else {
            return new ReverseMutableListView<>(list);
        }
    }

    private final MutableList<E> list;

    /**
     * Instantiates a new reverse mutable list view.
     *
     * @param list the list
     */
    public ReverseMutableListView(final MutableList<E> list) {
        this.list = list;
    }

    /**
     * Gets the.
     *
     * @param index the index
     * @return the e
     */
    @Override
    public E get(final int index) {
        int reverseIndex = list.size() - index - 1;
        return list.get(reverseIndex);
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    @Override
    public E getFirst() {
        return list.getLast();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    @Override
    public E getLast() {
        return list.getFirst();
    }

    /**
     * Iterator.
     *
     * @return the mutable list iterator
     */
    @Override
    public MutableListIterator<E> iterator() {
        return new ReverseMutableListIterator<>(list.iterator());
    }

    /**
     * Size.
     *
     * @return the int
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Adds the.
     *
     * @param e the e
     */
    public void add(final E e) {
        Guard.againstNull(e);
        list.add(e);
    }

    /**
     * Adds the first.
     *
     * @param e the e
     */
    public void addFirst(final E e) {
        Guard.againstNull(e);
        list.addLast(e);
    }

    /**
     * Adds the last.
     *
     * @param e the e
     */
    public void addLast(final E e) {
        Guard.againstNull(e);
        list.addFirst(e);
    }

    @Override
    public void add(Collection<? extends E> c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(java.util.Collection<? extends E> c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeIf(Predicate<? super Object> predicate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeLast() {
        // TODO Auto-generated method stub

    }
}
