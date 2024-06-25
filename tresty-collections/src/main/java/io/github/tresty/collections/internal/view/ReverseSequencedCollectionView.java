package io.github.tresty.collections.internal.view;

import io.github.tresty.collections.collection.SequencedCollection;
import io.github.tresty.collections.internal.iterator.ReverseSequencedIterator;
import io.github.tresty.collections.iterator.SequencedIterator;

/**
 * The Class ReverseSequencedCollectionView.
 *
 * @param <E> the element type
 */
public final class ReverseSequencedCollectionView<E> implements SequencedCollection<E> {

    /**
     * Of.
     *
     * @param <E>        the element type
     * @param collection the collection
     * @return the sequenced collection
     */
    public static <E> SequencedCollection<E> of(final SequencedCollection<E> collection) {
        if (collection instanceof ReverseSequencedCollectionView<E> c) {
            return c.collection;
        } else {
            return new ReverseSequencedCollectionView<>(collection);
        }
    }

    private final SequencedCollection<E> collection;

    /**
     * Instantiates a new reverse sequenced collection view.
     *
     * @param collection the collection
     */
    public ReverseSequencedCollectionView(final SequencedCollection<E> collection) {
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
