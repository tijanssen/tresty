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

import io.github.tresty.collections.collection.Collection;
import io.github.tresty.collections.collection.MutableSequencedCollection;
import io.github.tresty.collections.internal.iterator.ReverseMutableSequencedIterator;
import io.github.tresty.collections.iterator.MutableSequencedIterator;
import io.github.tresty.common.Guard;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * The Class ReverseMutableSequencedCollectionView.
 *
 * @param <E> the element type
 */
public final class ReverseMutableSequencedCollectionView<E> implements MutableSequencedCollection<E> {

    private MutableSequencedCollection<E> mutableSequencedCollection;

    /**
     * Instantiates a new reverse mutable sequenced collection view.
     *
     * @param collection the collection
     */
    public ReverseMutableSequencedCollectionView(final MutableSequencedCollection<E> mutableSequencedCollection) {
        this.mutableSequencedCollection = mutableSequencedCollection;
    }

    /**
     * Of.
     *
     * @param <E> the element type
     * @param collection the collection
     * @return the mutable sequenced collection
     */
    public static <E> MutableSequencedCollection<E> of(final MutableSequencedCollection<E> collection) {
        if (collection instanceof ReverseMutableSequencedCollectionView<E> c) {
            return c.mutableSequencedCollection;
        } else {
            return new ReverseMutableSequencedCollectionView<>(collection);
        }
    }

    @Override
    public void add(final Collection<? extends E> c) {
    }

    /**
     * Adds the.
     *
     * @param e the e
     */
    public void add(final E e) {
        Guard.againstNull(e);
        mutableSequencedCollection.add(e);
    }

    @Override
    public void add(final java.util.Collection<? extends E> c) {
    }

    @Override
    public void addFirst(final Collection<? extends E> c) {
        // TODO Auto-generated method stub

    }

    /**
     * Adds the first.
     *
     * @param e the e
     */
    public void addFirst(final E e) {
        Guard.againstNull(e);
        mutableSequencedCollection.addLast(e);
    }

    @Override
    public void addFirst(final java.util.Collection<? extends E> c) {
        // TODO Auto-generated method stub

    }

    /**
     * Adds the last.
     *
     * @param e the e
     */
    public void addLast(final E e) {
        mutableSequencedCollection.addFirst(e);
        Guard.againstNull(e);
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    @Override
    public Optional<E> getFirst() {
        return mutableSequencedCollection.getLast();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    @Override
    public Optional<E> getLast() {
        return mutableSequencedCollection.getFirst();
    }

    /**
     * Iterator.
     *
     * @return the mutable sequenced iterator
     */
    @Override
    public MutableSequencedIterator<E> iterator() {
        return new ReverseMutableSequencedIterator<>(mutableSequencedCollection.iterator());
    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeIf(final Predicate<? super Object> predicate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeLast() {
        // TODO Auto-generated method stub

    }

    /**
     * Size.
     *
     * @return the int
     */
    @Override
    public int size() {
        return mutableSequencedCollection.size();
    }
}
