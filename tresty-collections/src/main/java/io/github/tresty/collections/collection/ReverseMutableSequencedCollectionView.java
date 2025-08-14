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

final class ReverseMutableSequencedCollectionView<E> implements MutableSequencedCollection<E> {

    private MutableSequencedCollection<E> collection;

    /**
     * Instantiates a new reverse mutable sequenced collection view.
     *
     * @param collection the collection
     */
    ReverseMutableSequencedCollectionView(final MutableSequencedCollection<E> collection) {
        this.collection = collection;
    }

    /**
     * Of.
     *
     * @param <E> the element type
     * @param collection the collection
     * @return the mutable sequenced collection
     */
    public static <E> MutableSequencedCollection<E> of(final MutableSequencedCollection<E> collection) {
        Guard.againstNull(collection);
        if (collection instanceof ReverseMutableSequencedCollectionView<E> c) {
            return c.collection;
        } else {
            return new ReverseMutableSequencedCollectionView<>(collection);
        }
    }

    @Override
    public void add(final Collection<? extends E> c) {
        collection.add(c);
    }

    @Override
    public void add(final E e) {
        collection.add(e);
    }

    @Override
    public void add(final java.util.Collection<? extends E> c) {
        collection.add(c);
    }

    @Override
    public void addFirst(final E e) {
        collection.addLast(e);
    }

    @Override
    public void addLast(final E e) {
        collection.addFirst(e);
    }

    @Override
    public MutableSequencedIterator<E> descendingIterator() {
        return null;
    }

    @Override
    public Optional<E> getFirst() {
        return collection.getLast();
    }

    @Override
    public Optional<E> getLast() {
        return collection.getFirst();
    }

    @Override
    public MutableSequencedIterator<E> iterator() {
        return null;
    }

    @Override
    public void removeFirst() {
        collection.removeLast();
    }

    @Override
    public void removeLast() {
        collection.removeFirst();
    }

    @Override
    public int size() {
        return collection.size();
    }
}
