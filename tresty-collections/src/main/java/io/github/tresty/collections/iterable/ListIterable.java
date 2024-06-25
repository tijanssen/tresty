package io.github.tresty.collections.iterable;

import io.github.tresty.collections.iterator.ListIterator;

/**
 * The Interface ListIterable.
 *
 * @param <E> the element type
 */
public interface ListIterable<E> extends SequencedIterable<E> {

    /**
     * Iterator.
     *
     * @return the list iterator
     */
    @Override
    ListIterator<E> iterator();
}
