package io.github.tresty.collections.iterator.reverse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mock.Strictness;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.tresty.collections.internal.iterator.ReverseListIterator;
import io.github.tresty.collections.iterator.ListIterator;

@ExtendWith(MockitoExtension.class)
class ReverseListIteratorTests {

    @Test
    void nextIndex_CallsPreviousIndexOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iterator) {
        final var reverseIterator = new ReverseListIterator<>(iterator);

        reverseIterator.nextIndex();

        Mockito.verify(iterator, Mockito.times(1)).previousIndex();
    }

    @Test
    void previousIndex_CallsNextIndexOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) ListIterator<String> iterator) {
        final var reverseIterator = new ReverseListIterator<>(iterator);

        reverseIterator.previousIndex();

        Mockito.verify(iterator, Mockito.times(1)).nextIndex();
    }
}
