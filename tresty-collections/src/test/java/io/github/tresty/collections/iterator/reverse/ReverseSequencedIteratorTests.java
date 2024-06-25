package io.github.tresty.collections.iterator.reverse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mock.Strictness;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.tresty.collections.internal.iterator.ReverseSequencedIterator;
import io.github.tresty.collections.iterator.SequencedIterator;

@ExtendWith(MockitoExtension.class)
class ReverseSequencedIteratorTests {

    @Test
    void hasNext_CallsHasPreviousOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) SequencedIterator<String> iterator) {
        Mockito.when(iterator.hasPrevious()).thenReturn(true);
        final var reverseIterator = new ReverseSequencedIterator<>(iterator);

        reverseIterator.hasNext();

        Mockito.verify(iterator, Mockito.timeout(1)).hasPrevious();
    }

    @Test
    void hasPrevious_CallsHasNextOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) SequencedIterator<String> iterator) {
        Mockito.when(iterator.hasNext()).thenReturn(true);
        final var reverseIterator = new ReverseSequencedIterator<>(iterator);

        reverseIterator.hasPrevious();

        Mockito.verify(iterator, Mockito.timeout(1)).hasNext();
    }

    @Test
    void remove_ThrowsUnsupportedOperationException(
            final @Mock(strictness = Strictness.STRICT_STUBS) SequencedIterator<String> iterator) {
        final var reverseIterator = new ReverseSequencedIterator<>(iterator);

        Assertions.assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(reverseIterator::remove);
    }

    @Test
    void next_CallsPreviousOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) SequencedIterator<String> iterator) {
        Mockito.when(iterator.previous()).thenReturn("");
        final var reverseIterator = new ReverseSequencedIterator<>(iterator);

        reverseIterator.next();

        Mockito.verify(iterator, Mockito.times(1)).previous();
    }

    @Test
    void previous_CallsNextOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) SequencedIterator<String> iterator) {
        Mockito.when(iterator.next()).thenReturn("");
        final var reverseIterator = new ReverseSequencedIterator<>(iterator);

        reverseIterator.previous();

        Mockito.verify(iterator, Mockito.times(1)).next();
    }
}
