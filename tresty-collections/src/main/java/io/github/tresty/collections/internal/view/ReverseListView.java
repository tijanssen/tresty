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

import io.github.tresty.collections.internal.iterator.ReverseListIterator;
import io.github.tresty.collections.iterator.ListIterator;
import io.github.tresty.collections.list.List;

/**
 * The Class ReverseListView.
 *
 * @param <E> the element type
 */
public final class ReverseListView<E> implements List<E> {

    /**
     * Of.
     *
     * @param <E>  the element type
     * @param list the list
     * @return the list
     */
    public static <E> List<E> of(final List<E> list) {
        if (list instanceof ReverseListView<E> l) {
            return l.list;
        } else {
            return new ReverseListView<>(list);
        }
    }

    private final List<E> list;

    /**
     * Instantiates a new reverse list view.
     *
     * @param list the list
     */
    public ReverseListView(final List<E> list) {
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
     * @return the list iterator
     */
    @Override
    public ListIterator<E> iterator() {
        return new ReverseListIterator<>(list.iterator());
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
}
