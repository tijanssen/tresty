package io.github.tresty.collections.iterable;

import io.github.tresty.collections.iterator.SequencedIterator;

/**
 * The Interface SequencedIterable.
 *
 * @param <E> the element type
 */
public interface SequencedIterable<E> extends Iterable<E> {

    /**
     * Iterator.
     *
     * @return the sequenced iterator
     */
    @Override
    SequencedIterator<E> iterator();
}
