package io.github.tresty.collections.internal.view;

import io.github.tresty.collections.internal.iterator.ReverseListIterator;
import io.github.tresty.collections.iterator.ListIterator;
import io.github.tresty.collections.list.ImmutableList;

/**
 * The Class ReverseImmutableListView.
 *
 * @param <E> the element type
 */
public final class ReverseImmutableListView<E> implements ImmutableList<E> {

    /**
     * Of.
     *
     * @param <E>  the element type
     * @param list the list
     * @return the immutable list
     */
    public static <E> ImmutableList<E> of(final ImmutableList<E> list) {
        if (list instanceof ReverseImmutableListView<E> l) {
            return l.list;
        } else {
            return new ReverseImmutableListView<>(list);
        }
    }

    /** The list. */
    private final ImmutableList<E> list;

    /**
     * Instantiates a new reverse immutable list view.
     *
     * @param list the list
     */
    public ReverseImmutableListView(final ImmutableList<E> list) {
        this.list = list;
    }

    /**
     * Gets the.
     *
     * @param index the index
     * @return the e
     */
    @Override
    public E get(final int index) {
        int reverseIndex = list.size() - index - 1;
        return list.get(reverseIndex);
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    @Override
    public E getFirst() {
        return list.getLast();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    @Override
    public E getLast() {
        return list.getFirst();
    }

    /**
     * Iterator.
     *
     * @return the list iterator
     */
    @Override
    public ListIterator<E> iterator() {
        return new ReverseListIterator<>(list.iterator());
    }

    /**
     * Size.
     *
     * @return the int
     */
    @Override
    public int size() {
        return list.size();
    }
}
