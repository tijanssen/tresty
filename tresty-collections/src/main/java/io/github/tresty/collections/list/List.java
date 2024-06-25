package io.github.tresty.collections.list;

import io.github.tresty.collections.collection.SequencedCollection;
import io.github.tresty.collections.internal.view.ReverseListView;
import io.github.tresty.collections.iterable.ListIterable;

/**
 * The Interface List.
 *
 * @param <E> the element type
 */
public interface List<E> extends SequencedCollection<E>, ListIterable<E> {

    /**
     * Gets the.
     *
     * @param index the index
     * @return the e
     */
    E get(int index);

    /**
     * Reversed.
     *
     * @return the list
     */
    @Override
    default List<E> reversed() {
        return ReverseListView.of(this);
    }
}
