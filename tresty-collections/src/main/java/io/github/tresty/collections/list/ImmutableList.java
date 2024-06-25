package io.github.tresty.collections.list;

import io.github.tresty.collections.collection.ImmutableSequencedCollection;
import io.github.tresty.collections.internal.view.ReverseImmutableListView;

/**
 * The Interface ImmutableList.
 *
 * @param <E> the element type
 */
public interface ImmutableList<E> extends ImmutableSequencedCollection<E>, List<E> {

    /**
     * Reversed.
     *
     * @return the immutable list
     */
    @Override
    default ImmutableList<E> reversed() {
        return ReverseImmutableListView.of(this);
    }
}
