package io.github.tresty.collections.collection;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import io.github.tresty.common.Guard;

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
     * @param c         the c
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
            if (!found)
                return false;
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
     * @param c         the c
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
     * @param c         the c
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
     * @param c         the c
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
    default E[] toArray() {
        @SuppressWarnings("unchecked")
        final var array = (E[]) new Object[size()];
        var index = 0;
        for (final var e : this) {
            array[index] = e;
            index++;
        }
        return array;
    }
}
