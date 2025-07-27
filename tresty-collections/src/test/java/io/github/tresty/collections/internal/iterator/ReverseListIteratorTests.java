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
package io.github.tresty.collections.internal.iterator;

import io.github.tresty.collections.iterator.ListIterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mock.Strictness;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings({ "checkstyle:MagicNumber", "MethodName" })
class ReverseListIteratorTests {

    private static final String TEST_ENTRY = "test";

    @Nested
    class NextIndex {

        @Test
        void nextIndex_CallsPreviousIndexOnceOnOriginalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            reverseIterator.nextIndex();

            // Verify
            Mockito.verify(iteratorMock, Mockito.times(1)).previousIndex();
        }

        @Test
        void OriginalIteratorPreviousIndexReturnsIntegerMaxValue_ReturnsIntegerMaxValue(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.previousIndex()).thenReturn(Integer.MAX_VALUE);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.nextIndex();

            // Assert
            Assertions.assertThat(actualValue).isEqualByComparingTo(Integer.MAX_VALUE);
        }
    }

    @Nested
    class PreviousIndex {

        @Test
        void previousIndex_CallsNextIndexOnceOnOriginalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            reverseIterator.previousIndex();

            // Verify
            Mockito.verify(iteratorMock, Mockito.times(1)).nextIndex();
        }

        @Test
        void OriginalIteratorPreviousIndexReturnsIntegerMaxValue_ReturnsIntegerMaxValue(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.nextIndex()).thenReturn(Integer.MAX_VALUE);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.previousIndex();

            // Assert
            Assertions.assertThat(actualValue).isEqualTo(Integer.MAX_VALUE);
        }
    }

    @Nested
    class HasNext {

        @Test
        void CallsHasPreviousOnceOnOriginalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            reverseIterator.hasNext();

            // Verify
            Mockito.verify(iteratorMock, Mockito.times(1)).hasPrevious();
        }

        @Test
        void OriginalIteratorHasNextReturnsFalse_ReturnsFalse(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.hasPrevious()).thenReturn(false);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.hasNext();

            // Assert
            Assertions.assertThat(actualValue).isFalse();
        }

        @Test
        void OriginalIteratorHasNextReturnsTrue_ReturnsTrue(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.hasPrevious()).thenReturn(true);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.hasNext();

            // Assert
            Assertions.assertThat(actualValue).isTrue();
        }
    }

    @Nested
    class HasPrevious {

        @Test
        void CallsHasNextOnceOnOriginalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            reverseIterator.hasPrevious();

            // Verify
            Mockito.verify(iteratorMock, Mockito.times(1)).hasNext();
        }

        @Test
        void OriginalIteratorHasNextReturnsFalse_ReturnsFalse(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.hasNext()).thenReturn(false);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.hasPrevious();

            // Assert
            Assertions.assertThat(actualValue).isFalse();
        }

        @Test
        void OriginalIteratorHasPreviousReturnsTrue_ReturnsTrue(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.hasNext()).thenReturn(true);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.hasPrevious();

            // Assert
            Assertions.assertThat(actualValue).isTrue();
        }
    }

    @Nested
    class Next {

        @Test
        void CallsPreviousOnceOnOriginalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            reverseIterator.next();

            // Verify
            Mockito.verify(iteratorMock, Mockito.times(1)).previous();
        }

        @Test
        void OriginalIteratorPreviousReturnsTestEntry_ReturnsTestEntry(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.previous()).thenReturn(TEST_ENTRY);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.next();

            // Assert
            Assertions.assertThat(actualValue).isEqualTo(TEST_ENTRY);
        }
    }

    @Nested
    class Previous {

        @Test
        void CallsNextOnceOnOriginalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            reverseIterator.previous();

            // Verify
            Mockito.verify(iteratorMock, Mockito.times(1)).next();
        }

        @Test
        void OriginalIteratorNextReturnsTestEntry_ReturnsTestEntry(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iteratorMock) {
            // Arrange
            Mockito.when(iteratorMock.next()).thenReturn(TEST_ENTRY);
            final var reverseIterator = new ReverseListIterator<>(iteratorMock);

            // Act
            final var actualValue = reverseIterator.previous();

            // Assert
            Assertions.assertThat(actualValue).isEqualTo(TEST_ENTRY);
        }
    }
}
