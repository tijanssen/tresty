package io.github.tresty.collections.internal.iterator;

import io.github.tresty.collections.iterator.ListIterator;

/**
 * The Class ReverseListIterator.
 *
 * @param <E> the element type
 */
public final class ReverseListIterator<E> extends ReverseSequencedIterator<E> implements ListIterator<E> {

    private final ListIterator<E> listIterator;

    /**
     * Instantiates a new reverse list iterator.
     *
     * @param iterator the iterator
     */
    public ReverseListIterator(final ListIterator<E> iterator) {
        super(iterator);
        listIterator = iterator;
    }

    /**
     * Next index.
     *
     * @return the int
     */
    @Override
    public int nextIndex() {
        return listIterator.previousIndex();
    }

    /**
     * Previous index.
     *
     * @return the int
     */
    @Override
    public int previousIndex() {
        return listIterator.nextIndex();
    }
}
