package io.github.tresty.collections.internal.iterator;

import io.github.tresty.collections.iterator.SequencedIterator;

/**
 * The Class ReverseSequencedIterator.
 *
 * @param <E> the element type
 */
public sealed class ReverseSequencedIterator<E> implements SequencedIterator<E>
        permits ReverseMutableSequencedIterator, ReverseListIterator {

    private SequencedIterator<E> sequencedIterator;

    /**
     * Instantiates a new reverse sequenced iterator.
     *
     * @param iterator the iterator
     */
    public ReverseSequencedIterator(final SequencedIterator<E> iterator) {
        this.sequencedIterator = iterator;
    }

    /**
     * Checks for next.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasNext() {
        return sequencedIterator.hasPrevious();
    }

    /**
     * Checks for previous.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasPrevious() {
        return sequencedIterator.hasNext();
    }

    /**
     * Next.
     *
     * @return the e
     */
    @Override
    public E next() {
        return sequencedIterator.previous();
    }

    /**
     * Previous.
     *
     * @return the e
     */
    @Override
    public E previous() {
        return sequencedIterator.next();
    }
}
