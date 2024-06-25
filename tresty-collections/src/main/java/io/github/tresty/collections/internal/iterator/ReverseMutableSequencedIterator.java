package io.github.tresty.collections.internal.iterator;

import io.github.tresty.collections.iterator.MutableSequencedIterator;

/**
 * The Class ReverseMutableSequencedIterator.
 *
 * @param <E> the element type
 */
public sealed class ReverseMutableSequencedIterator<E> extends ReverseSequencedIterator<E>
        implements MutableSequencedIterator<E> permits ReverseMutableListIterator {

    private MutableSequencedIterator<E> mutableSequencedIterator;

    /**
     * Instantiates a new reverse mutable sequenced iterator.
     *
     * @param iterator the iterator
     */
    public ReverseMutableSequencedIterator(final MutableSequencedIterator<E> iterator) {
        super(iterator);
        mutableSequencedIterator = iterator;
    }

    /**
     * Adds the after.
     *
     * @param e the e
     */
    @Override
    public void addAfter(E e) {
        mutableSequencedIterator.addBefore(e);
    }

    /**
     * Adds the before.
     *
     * @param e the e
     */
    @Override
    public void addBefore(E e) {
        mutableSequencedIterator.addAfter(e);
    }

    /**
     * Sets the.
     *
     * @param e the e
     */
    @Override
    public void set(E e) {
        mutableSequencedIterator.set(e);
    }
}
