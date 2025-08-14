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

import io.github.tresty.common.Guard;
import java.lang.reflect.Array;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * The Interface Collection.
 *
 * @param <E> the element type
 */
public interface Collection<E> extends Iterable<E> {

    /**
     * Contains.
     *
     * @param e the e
     * @return true, if successful
     */
    default boolean contains(final E e) {
        return contains(x -> x.equals(e));
    }

    /**
     * Contains.
     *
     * @param predicate the predicate
     * @return true, if successful
     */
    default boolean contains(final Predicate<? super E> predicate) {
        Guard.againstNull(predicate);
        for (final var e : this) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Contains all.
     *
     * @param c the c
     * @return true, if successful
     */
    default boolean containsAll(final Collection<? extends E> c) {
        return containsAll(c, Object::equals);
    }

    /**
     * Contains all.
     *
     * @param c the c
     * @param predicate the predicate
     * @return true, if successful
     */
    default boolean containsAll(final Collection<? extends E> c, final BiPredicate<? super E, ? super E> predicate) {
        for (final var item : c) {
            var found = false;
            for (final var element : this) {
                if (predicate.test(element, item)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /**
     * Contains all.
     *
     * @param c the c
     * @return true, if successful
     */
    default boolean containsAll(final java.util.Collection<? extends E> c) {
        return containsAll(c, Object::equals);
    }

    /**
     * Contains all.
     *
     * @param c the c
     * @param predicate the predicate
     * @return true, if successful
     */
    default boolean containsAll(final java.util.Collection<? extends E> c,
        final BiPredicate<? super E, ? super E> predicate) {
        for (final var item : c) {
            var found = false;
            for (final var element : this) {
                if (predicate.test(element, item)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /**
     * Contains any.
     *
     * @param c the c
     * @return true, if successful
     */
    default boolean containsAny(final Collection<? extends E> c) {
        return containsAny(c, Object::equals);
    }

    /**
     * Contains any.
     *
     * @param c the c
     * @param predicate the predicate
     * @return true, if successful
     */
    default boolean containsAny(final Collection<? extends E> c, final BiPredicate<? super E, ? super E> predicate) {
        for (final var item : this) {
            for (final var element : c) {
                if (predicate.test(item, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Contains any.
     *
     * @param c the c
     * @return true, if successful
     */
    default boolean containsAny(final java.util.Collection<? extends E> c) {
        return containsAny(c, Object::equals);
    }

    /**
     * Contains any.
     *
     * @param c the c
     * @param predicate the predicate
     * @return true, if successful
     */
    default boolean containsAny(final java.util.Collection<? extends E> c,
        final BiPredicate<? super E, ? super E> predicate) {
        for (final var item : this) {
            for (final var element : c) {
                if (predicate.test(item, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Size.
     *
     * @return the int
     */
    int size();

    /**
     * To array.
     *
     * @return the e[]
     */
    default Object[] toArray() {
        final var array = new Object[size()];
        var index = 0;
        for (final var e : this) {
            array[index] = e;
            index++;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    default E[] toArray(final E[] a) {
        var array = a;
        if (a.length < size()) {
            array = (E[]) Array.newInstance(a.getClass(), size());
        }
        var index = 0;
        for (final var e : this) {
            array[index] = e;
            index++;
        }
        return array;
    }
}
