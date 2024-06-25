package io.github.tresty.collections.collection;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import io.github.tresty.common.Guard;

/**
 * The Interface MutableCollection.
 *
 * @param <E> the element type
 */
public interface MutableCollection<E> extends Collection<E> {

    /**
     * Adds the.
     *
     * @param e the e
     */
    void add(E e);

    void add(Collection<? extends E> c);

    void add(java.util.Collection<? extends E> c);

    default void remove(final E e) {
        removeIf(x -> x.equals(e));
    }

    default void removeIf(Predicate<? super Object> predicate) {
        Guard.againstNull(predicate);
        final var iter = iterator();
        while (iter.hasNext()) {
            final var element = iter.next();
            if (predicate.test(element)) {
                iter.remove();
            }
        }
    }

    default void removeAllIf(Collection<? extends E> c, BiPredicate<? super Object, ? super Object> predicate) {
        Guard.againstNull(c);
        Guard.againstNull(predicate);
        for (final var e : c) {
            removeIf(x -> predicate.test(x, e));
        }
    }

    default void removeAllIf(java.util.Collection<? extends E> c, BiPredicate<? super Object, ? super Object> predicate) {
        Guard.againstNull(c);
        Guard.againstNull(predicate);
        for (final var e : c) {
            removeIf(x -> predicate.test(x, e));
        }
    }

    default void removeAll(Collection<? extends E> c) {
        removeAllIf(c, (x, y) -> x.equals(y));
    }

    default void removeAll(java.util.Collection<? extends E> c) {
        removeAllIf(c, (x, y) -> x.equals(y));
    }
}
