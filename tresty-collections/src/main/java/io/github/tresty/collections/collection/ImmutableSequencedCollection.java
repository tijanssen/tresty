package io.github.tresty.collections.collection;

import io.github.tresty.collections.internal.view.ReverseImmutableSequencedCollectionView;

/**
 * The Interface ImmutableSequencedCollection.
 *
 * @param <E> the element type
 */
public interface ImmutableSequencedCollection<E> extends ImmutableCollection<E>, SequencedCollection<E> {

    /**
     * Reversed.
     *
     * @return the immutable sequenced collection
     */
    @Override
    default ImmutableSequencedCollection<E> reversed() {
        return ReverseImmutableSequencedCollectionView.of(this);
    }
}
