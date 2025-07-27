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

import io.github.tresty.collections.collection.SequencedCollection;
import io.github.tresty.collections.internal.iterator.ReverseSequencedIterator;
import io.github.tresty.collections.iterator.SequencedIterator;
import java.util.Optional;

/**
 * The Class ReverseSequencedCollectionView.
 *
 * @param <E> the element type
 */
public final class ReverseSequencedCollectionView<E> implements SequencedCollection<E> {

    private final SequencedCollection<E> sequencedCollection;

    /**
     * Instantiates a new reverse sequenced collection view.
     *
     * @param collection the collection
     */
    public ReverseSequencedCollectionView(final SequencedCollection<E> sequencedCollection) {
        this.sequencedCollection = sequencedCollection;
    }

    /**
     * Of.
     *
     * @param <E> the element type
     * @param collection the collection
     * @return the sequenced collection
     */
    public static <E> SequencedCollection<E> of(final SequencedCollection<E> collection) {
        if (collection instanceof ReverseSequencedCollectionView<E> c) {
            return c.sequencedCollection;
        } else {
            return new ReverseSequencedCollectionView<>(collection);
        }
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    @Override
    public Optional<E> getFirst() {
        return sequencedCollection.getLast();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    @Override
    public Optional<E> getLast() {
        return sequencedCollection.getFirst();
    }

    /**
     * Iterator.
     *
     * @return the sequenced iterator
     */
    @Override
    public SequencedIterator<E> iterator() {
        return new ReverseSequencedIterator<>(sequencedCollection.iterator());
    }

    /**
     * Size.
     *
     * @return the int
     */
    @Override
    public int size() {
        return sequencedCollection.size();
    }
}
