package io.github.tresty.collections.iterable;

import io.github.tresty.collections.iterator.MutableSequencedIterator;

/**
 * The Interface MutableSequencedIterable.
 *
 * @param <E> the element type
 */
public interface MutableSequencedIterable<E> extends SequencedIterable<E> {

    /**
     * Iterator.
     *
     * @return the mutable sequenced iterator
     */
    @Override
    MutableSequencedIterator<E> iterator();
}
