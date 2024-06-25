package io.github.tresty.collections.internal.iterator;

import io.github.tresty.collections.iterator.MutableListIterator;

/**
 * The Class ReverseMutableListIterator.
 *
 * @param <E> the element type
 */
public final class ReverseMutableListIterator<E> extends ReverseMutableSequencedIterator<E>
        implements MutableListIterator<E> {

    private final MutableListIterator<E> mutableListIterator;

    /**
     * Instantiates a new reverse mutable list iterator.
     *
     * @param iterator the iterator
     */
    public ReverseMutableListIterator(final MutableListIterator<E> iterator) {
        super(iterator);
        mutableListIterator = iterator;
    }

    /**
     * Next index.
     *
     * @return the int
     */
    @Override
    public int nextIndex() {
        return mutableListIterator.previousIndex();
    }

    /**
     * Previous index.
     *
     * @return the int
     */
    @Override
    public int previousIndex() {
        return mutableListIterator.previousIndex();
    }
}
