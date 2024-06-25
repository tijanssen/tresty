package io.github.tresty.collections.collection;

import io.github.tresty.collections.internal.view.ReverseSequencedCollectionView;
import io.github.tresty.collections.iterable.SequencedIterable;

/// The Interface SequencedCollection.
///
/// @param <E> the element type
/**
 * The Interface SequencedCollection.
 *
 * @param <E> the element type
 */
///
public interface SequencedCollection<E> extends Collection<E>, SequencedIterable<E> {

    /**
     * Gets the first.
     *
     * @return the first
     */
    E getFirst();

    /**
     * Gets the last.
     *
     * @return the last
     */
    E getLast();

    /**
     * Reversed.
     *
     * @return the sequenced collection
     */
    default SequencedCollection<E> reversed() {
        return ReverseSequencedCollectionView.of(this);
    }
}
