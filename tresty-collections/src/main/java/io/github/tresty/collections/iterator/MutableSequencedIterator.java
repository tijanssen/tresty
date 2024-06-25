package io.github.tresty.collections.iterator;

/**
 * The Interface MutableSequencedIterator.
 *
 * @param <E> the element type
 */
public interface MutableSequencedIterator<E> extends SequencedIterator<E> {

    /**
     * Adds the after.
     *
     * @param e the e
     */
    void addAfter(E e);

    /**
     * Adds the before.
     *
     * @param e the e
     */
    void addBefore(E e);

    /**
     * Sets the.
     *
     * @param e the e
     */
    void set(E e);
}
