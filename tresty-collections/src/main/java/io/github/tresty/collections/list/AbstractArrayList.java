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
import io.github.tresty.collections.iterator.ListIterator;
import io.github.tresty.common.Guard;
import java.util.Arrays;
import java.util.Optional;

public abstract sealed class AbstractArrayList<E> implements List<E> permits ImmutableArrayList, MutableArrayList {

    private static final int DEFAULT_INITIAL_CAPACITY = 20;

    Object[] elementData;
    int size;

    protected AbstractArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    protected AbstractArrayList(final Collection<? extends E> c) {
        Guard.againstNull(c);
        elementData = new Object[c.size()];
        for (final var e : c) {
            elementData[size] = e;
            size++;
        }
    }

    @SafeVarargs
    protected AbstractArrayList(final E... args) {
        Guard.againstNull(args);
        Guard.againstContainsNull(args);
        elementData = Arrays.copyOf(args, args.length, args.getClass());
        size = args.length;
    }

    protected AbstractArrayList(final int initialCapacity) {
        Guard.againstLessThanZero(initialCapacity);
        elementData = new Object[initialCapacity];
    }

    protected AbstractArrayList(final java.util.Collection<? extends E> c) {
        Guard.againstNull(c);
        Guard.againstContainsNull(c);
        elementData = new Object[c.size()];
        for (final var e : c) {
            elementData[size] = e;
            size++;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(final int index) {
        return (E) elementData[index];
    }

    @Override
    public Optional<E> getFirst() {
        if (size == 0) {
            return Optional.empty();
        } else {
            @SuppressWarnings("unchecked")
            final var value = (E) elementData[0];
            return Optional.of(value);
        }
    }

    @Override
    public Optional<E> getLast() {
        if (size == 0) {
            return Optional.empty();
        } else {
            @SuppressWarnings("unchecked")
            final var value = (E) elementData[size - 1];
            return Optional.of(value);
        }
    }

    @Override
    public ListIterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
