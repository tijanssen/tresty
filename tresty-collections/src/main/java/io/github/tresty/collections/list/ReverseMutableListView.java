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
package io.github.tresty.collections.list;

import io.github.tresty.collections.collection.Collection;
import io.github.tresty.collections.iterator.MutableListIterator;
import java.util.Optional;

final class ReverseMutableListView<E> implements MutableList<E> {

    private final MutableList<E> list;

    /**
     * Instantiates a new reverse mutable list view.
     *
     * @param list the list
     */
    ReverseMutableListView(final MutableList<E> list) {
        this.list = list;
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
            return l.list;
        } else {
            return new ReverseMutableListView<>(list);
        }
    }

    @Override
    public void add(final Collection<? extends E> c) {
        list.add(c);
    }

    @Override
    public void add(final E e) {
        // TODO Auto-generated method stub
        MutableList.super.add(e);
    }

    @Override
    public void add(final java.util.Collection<? extends E> c) {
    }

    @Override
    public void addFirst(final E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addLast(final E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public MutableListIterator<E> descendingIterator() {
        return null;
    }

    @Override
    public E get(final int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<E> getFirst() {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<E> getLast() {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void insert(final int index, final E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public MutableListIterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MutableListIterator<E> iterator(final int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remove(final int index) {
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

    @Override
    public void set(final int index, final E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}
