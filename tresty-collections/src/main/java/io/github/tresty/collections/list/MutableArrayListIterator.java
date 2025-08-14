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

final class MutableArrayListIterator<E> extends ArrayListIterator<E> implements MutableListIterator<E> {

    private final MutableArrayList<E> mutableList;

    MutableArrayListIterator(final MutableArrayList<E> mutableList, final int index) {
        super(mutableList, index);
        this.mutableList = mutableList;
    }

    @Override
    public void addAfter(final E e) {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        mutableList.insert(lastRet + 1, e);
        lastRet = -1;
        nextIndex++;
        previousIndex++;
    }

    @Override
    public void addBefore(final E e) {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        mutableList.insert(lastRet, e);
        lastRet = -1;
        nextIndex++;
        previousIndex++;
    }

    @Override
    public void remove() {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        mutableList.remove(lastRet);
        lastRet = -1;
        nextIndex--;
        previousIndex--;
    }

    @Override
    public void set(final E e) {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        mutableList.set(lastRet, e);
    }
}
