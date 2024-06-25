package io.github.tresty.collections.iterator;

import java.util.Iterator;

/**
 * The Interface SequencedIterator.
 *
 * @param <E> the element type
 */
public interface SequencedIterator<E> extends Iterator<E> {

    /// Checks for previous.
    ///
    /// @return true, if successful
    /**
     * Checks for previous.
     *
     * @return true, if successful
     */
    ///
    boolean hasPrevious();

    /**
     * Previous.
     *
     * @return the e
     */
    E previous();
}
