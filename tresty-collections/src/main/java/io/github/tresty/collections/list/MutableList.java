package io.github.tresty.collections.list;

import io.github.tresty.collections.collection.MutableSequencedCollection;
import io.github.tresty.collections.internal.view.ReverseMutableListView;
import io.github.tresty.collections.iterable.MutableListIterable;

/**
 * The Interface MutableList.
 *
 * @param <E> the element type
 */
public interface MutableList<E> extends MutableSequencedCollection<E>, List<E>, MutableListIterable<E> {

    /**
     * Reversed.
     *
     * @return the mutable list
     */
    @Override
    default MutableList<E> reversed() {
        return ReverseMutableListView.of(this);
    }
}
