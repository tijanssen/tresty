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

import io.github.tresty.collections.iterator.SequencedIterator;

/**
 * The Class ReverseSequencedIterator.
 *
 * @param <E> the element type
 */
public sealed class ReverseSequencedIterator<E> implements SequencedIterator<E>
        permits ReverseMutableSequencedIterator, ReverseListIterator {

    private SequencedIterator<E> sequencedIterator;

    /**
     * Instantiates a new reverse sequenced iterator.
     *
     * @param iterator the iterator
     */
    public ReverseSequencedIterator(final SequencedIterator<E> iterator) {
        this.sequencedIterator = iterator;
    }

    /**
     * Checks for next.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasNext() {
        return sequencedIterator.hasPrevious();
    }

    /**
     * Checks for previous.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasPrevious() {
        return sequencedIterator.hasNext();
    }

    /**
     * Next.
     *
     * @return the e
     */
    @Override
    public E next() {
        return sequencedIterator.previous();
    }

    /**
     * Previous.
     *
     * @return the e
     */
    @Override
    public E previous() {
        return sequencedIterator.next();
    }
}
