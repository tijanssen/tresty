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
package io.github.tresty.collections.internal.iterator;

import io.github.tresty.collections.iterator.ListIterator;

/**
 * The Class ReverseListIterator.
 *
 * @param <E> the element type
 */
public final class ReverseListIterator<E> implements ListIterator<E> {

    private final ListIterator<E> iterator;

    /**
     * Instantiates a new reverse list iterator.
     *
     * @param iterator the iterator
     */
    public ReverseListIterator(final ListIterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasPrevious();
    }

    @Override
    public boolean hasPrevious() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        return iterator.previous();
    }

    /**
     * Next index.
     *
     * @return the int
     */
    @Override
    public int nextIndex() {
        return iterator.previousIndex();
    }

    @Override
    public E previous() {
        return iterator.next();
    }

    /**
     * Previous index.
     *
     * @return the int
     */
    @Override
    public int previousIndex() {
        return iterator.nextIndex();
    }
}
