package io.github.tresty.collections.iterable;

import io.github.tresty.collections.iterator.MutableListIterator;

/**
 * The Interface MutableListIterable.
 *
 * @param <E> the element type
 */
public interface MutableListIterable<E> extends ListIterable<E> {

    /**
     * Iterator.
     *
     * @return the mutable list iterator
     */
    @Override
    MutableListIterator<E> iterator();
}
