/*-
 * #%L
 * tresty-collections
 * %%
 * Copyright (C) 2025 Timo Janssen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
package io.github.tresty.collections.collection;

import io.github.tresty.collections.iterable.SequencedIterable;
import java.util.Optional;

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
    Optional<E> getFirst();

    /**
     * Gets the last.
     *
     * @return the last
     */
    Optional<E> getLast();

    /**
     * Reversed.
     *
     * @return the sequenced collection
     */
    default SequencedCollection<E> reversed() {
        return ReverseSequencedCollectionView.of(this);
    }
}
