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

import io.github.tresty.collections.iterator.ListIterator;
import io.github.tresty.common.Guard;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

sealed class ArrayListIterator<E> implements ListIterator<E> permits MutableArrayListIterator {

    int lastRet;
    int nextIndex;
    int previousIndex;
    private final AbstractArrayList<E> list;

    ArrayListIterator(final AbstractArrayList<E> list, final int index) {
        Guard.againstNull(list);
        Guard.againstInvalidIndex(index, list.size);
        this.list = list;
        lastRet = -1;
        nextIndex = index;
        previousIndex = -1;
    }

    @Override
    public void forEachRemaining(final Consumer<? super E> action) {
        Guard.againstNull(action);
        if (nextIndex >= list.size) {
            return;
        }
        for (var i = nextIndex; i < list.size; i++) {
            @SuppressWarnings("unchecked")
            final var value = (E) list.elementData[i];
            action.accept(value);
        }
        lastRet = list.size - 1;
        nextIndex = list.size;
        previousIndex = lastRet;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < list.size;
    }

    @Override
    public boolean hasPrevious() {
        return previousIndex >= 0;
    }

    @Override
    public E next() {
        if (nextIndex >= list.size) {
            throw new NoSuchElementException();
        }
        @SuppressWarnings("unchecked")
        final var value = (E) list.elementData[nextIndex];
        lastRet = nextIndex;
        nextIndex++;
        previousIndex++;
        return value;
    }

    @Override
    public int nextIndex() {
        return nextIndex;
    }

    @Override
    public E previous() {
        if (previousIndex < 0) {
            throw new NoSuchElementException();
        }
        @SuppressWarnings("unchecked")
        final var value = (E) list.elementData[previousIndex];
        lastRet = previousIndex;
        nextIndex--;
        previousIndex--;
        return value;
    }

    @Override
    public int previousIndex() {
        return previousIndex;
    }
}
