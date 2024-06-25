package io.github.tresty.collections.collection;

import io.github.tresty.collections.internal.view.ReverseMutableSequencedCollectionView;
import io.github.tresty.collections.iterable.MutableSequencedIterable;

/**
 * The Interface MutableSequencedCollection.
 *
 * @param <E> the element type
 */
public interface MutableSequencedCollection<E>
        extends MutableCollection<E>, SequencedCollection<E>, MutableSequencedIterable<E> {

    /**
     * Reversed.
     *
     * @return the mutable sequenced collection
     */
    @Override
    default MutableSequencedCollection<E> reversed() {
        return ReverseMutableSequencedCollectionView.of(this);
    }

    /**
     * Adds the first.
     *
     * @param e the e
     */
    void addFirst(E e);

    /**
     * Adds the last.
     *
     * @param e the e
     */
    void addLast(E e);

    void removeFirst();

    void removeLast();
}
