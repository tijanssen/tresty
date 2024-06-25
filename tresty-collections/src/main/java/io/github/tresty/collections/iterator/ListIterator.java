package io.github.tresty.collections.iterator;

/**
 * The Interface ListIterator.
 *
 * @param <E> the element type
 */
public interface ListIterator<E> extends SequencedIterator<E> {

    /**
     * Next index.
     *
     * @return the int
     */
    int nextIndex();

    /**
     * Previous index.
     *
     * @return the int
     */
    int previousIndex();
}
