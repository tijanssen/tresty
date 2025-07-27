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

import io.github.tresty.collections.iterator.MutableListIterator;
import io.github.tresty.common.Guard;
import java.util.Collection;
import java.util.Optional;

public final class MutableArrayList<E> implements MutableList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;

    private E[] elementData;

    private int size;

    public MutableArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SafeVarargs
    @SuppressWarnings("checkstyle:AvoidInlineConditionals")
    public MutableArrayList(final E... args) {
        this(args.length < DEFAULT_INITIAL_CAPACITY ? DEFAULT_INITIAL_CAPACITY : args.length);
        Guard.againstContainsNull(args);
        System.arraycopy(args, 0, elementData, 0, args.length);
        size = args.length;
    }

    @SuppressWarnings("unchecked")
    public MutableArrayList(final int initialCapacity) {
        if (initialCapacity < DEFAULT_INITIAL_CAPACITY) {
            elementData = (E[]) new Object[initialCapacity];
        } else {
            elementData = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }
    }

    @Override
    public void add(final Collection<? extends E> c) {
    }

    @Override
    public void add(final E e) {
    }

    @Override
    public void add(final io.github.tresty.collections.collection.Collection<? extends E> c) {
    }

    @Override
    public void addFirst(final Collection<? extends E> c) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addFirst(final E e) {
    }

    @Override
    public void addFirst(final io.github.tresty.collections.collection.Collection<? extends E> c) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addLast(final E e) {
    }

    @Override
    public E get(final int index) {
        return null;
    }

    @Override
    public Optional<E> getFirst() {
        return null;
    }

    @Override
    public Optional<E> getLast() {
        return null;
    }

    @Override
    public MutableListIterator<E> iterator() {
        return null;
    }

    @Override
    public void removeFirst() {
    }

    @Override
    public void removeLast() {
    }

    @Override
    public int size() {
        return size;
    }
}
