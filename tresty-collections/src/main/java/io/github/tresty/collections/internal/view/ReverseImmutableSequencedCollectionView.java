package io.github.tresty.collections.internal.view;

import io.github.tresty.collections.collection.ImmutableSequencedCollection;
import io.github.tresty.collections.internal.iterator.ReverseSequencedIterator;
import io.github.tresty.collections.iterator.SequencedIterator;

/**
 * The Class ReverseImmutableSequencedCollectionView.
 *
 * @param <E> the element type
 */
public final class ReverseImmutableSequencedCollectionView<E> implements ImmutableSequencedCollection<E> {

    /**
     * Of.
     *
     * @param <E>        the element type
     * @param collection the collection
     * @return the immutable sequenced collection
     */
    public static <E> ImmutableSequencedCollection<E> of(final ImmutableSequencedCollection<E> collection) {
        if (collection instanceof ReverseImmutableSequencedCollectionView<E> c) {
            return c.collection;
        } else {
            return new ReverseImmutableSequencedCollectionView<>(collection);
        }
    }

    private final ImmutableSequencedCollection<E> collection;

    /**
     * Instantiates a new reverse immutable sequenced collection view.
     *
     * @param collection the collection
     */
    public ReverseImmutableSequencedCollectionView(final ImmutableSequencedCollection<E> collection) {
        this.collection = collection;
    }

    /**
     * Gets the first.
     *
     * @return the first
     */
    @Override
    public E getFirst() {
        return collection.getLast();
    }

    /**
     * Gets the last.
     *
     * @return the last
     */
    @Override
    public E getLast() {
        return collection.getFirst();
    }

    /**
     * Iterator.
     *
     * @return the sequenced iterator
     */
    @Override
    public SequencedIterator<E> iterator() {
        return new ReverseSequencedIterator<>(collection.iterator());
    }

    /**
     * Size.
     *
     * @return the int
     */
    @Override
    public int size() {
        return collection.size();
    }
}
