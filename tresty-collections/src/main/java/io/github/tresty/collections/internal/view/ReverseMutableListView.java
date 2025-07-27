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
import io.github.tresty.collections.internal.iterator.ReverseMutableListIterator;
import io.github.tresty.collections.iterator.MutableListIterator;
import io.github.tresty.collections.list.MutableList;
import io.github.tresty.common.Guard;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * The Class ReverseMutableListView.
 *
 * @param <E> the element type
 */
public final class ReverseMutableListView<E> implements MutableList<E> {

    private final MutableList<E> mutableList;

    /**
     * Instantiates a new reverse mutable list view.
     *
     * @param list the list
     */
    public ReverseMutableListView(final MutableList<E> mutableList) {
        this.mutableList = mutableList;
    }

    /**
     * Of.
     *
     * @param <E> the element type
     * @param list the list
     * @return the mutable list
     */
    public static <E> MutableList<E> of(final MutableList<E> list) {
        if (list instanceof ReverseMutableListView<E> l) {
            return l.mutableList;
        } else {
            return new ReverseMutableListView<>(list);
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
        mutableList.add(e);
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
        mutableList.addLast(e);
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
        Guard.againstNull(e);
        mutableList.addFirst(e);
    }

    /**
     * Gets the.
     *
     * @param index the index
     * @return the e
     */
    @Override
    public E get(final int index) {
        final var reverseIndex = mutableList.size() - index - 1;
        return mutableList.get(reverseIndex);
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    @Override
    public Optional<E> getFirst() {
        return mutableList.getLast();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    @Override
    public Optional<E> getLast() {
        return mutableList.getFirst();
    }

    /**
     * Iterator.
     *
     * @return the mutable list iterator
     */
    @Override
    public MutableListIterator<E> iterator() {
        return new ReverseMutableListIterator<>(mutableList.iterator());
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
        return mutableList.size();
    }
}
