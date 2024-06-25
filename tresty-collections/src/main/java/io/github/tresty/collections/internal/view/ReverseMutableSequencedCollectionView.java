package io.github.tresty.collections.internal.view;

import java.util.function.Predicate;

import io.github.tresty.collections.collection.Collection;
import io.github.tresty.collections.collection.MutableSequencedCollection;
import io.github.tresty.collections.internal.iterator.ReverseMutableSequencedIterator;
import io.github.tresty.collections.iterator.MutableSequencedIterator;
import io.github.tresty.common.Guard;

/**
 * The Class ReverseMutableSequencedCollectionView.
 *
 * @param <E> the element type
 */
public final class ReverseMutableSequencedCollectionView<E> implements MutableSequencedCollection<E> {

    /**
     * Of.
     *
     * @param <E>        the element type
     * @param collection the collection
     * @return the mutable sequenced collection
     */
    public static <E> MutableSequencedCollection<E> of(final MutableSequencedCollection<E> collection) {
        if (collection instanceof ReverseMutableSequencedCollectionView<E> c) {
            return c.collection;
        } else {
            return new ReverseMutableSequencedCollectionView<>(collection);
        }
    }

    private MutableSequencedCollection<E> collection;

    /**
     * Instantiates a new reverse mutable sequenced collection view.
     *
     * @param collection the collection
     */
    public ReverseMutableSequencedCollectionView(final MutableSequencedCollection<E> collection) {
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
     * @return the mutable sequenced iterator
     */
    @Override
    public MutableSequencedIterator<E> iterator() {
        return new ReverseMutableSequencedIterator<>(collection.iterator());
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

    /**
     * Adds the.
     *
     * @param e the e
     */
    public void add(final E e) {
        Guard.againstNull(e);
        collection.add(e);
    }

    /**
     * Adds the first.
     *
     * @param e the e
     */
    public void addFirst(final E e) {
        Guard.againstNull(e);
        collection.addLast(e);
    }

    /**
     * Adds the last.
     *
     * @param e the e
     */
    public void addLast(final E e) {
        collection.addFirst(e);
        Guard.againstNull(e);
    }

    @Override
    public void add(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(java.util.Collection<? extends E> c) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeIf(Predicate<? super Object> predicate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeLast() {
        // TODO Auto-generated method stub
        
    }
}
