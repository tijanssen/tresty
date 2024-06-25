package io.github.tresty.collections.iterator.reverse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mock.Strictness;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.tresty.collections.internal.iterator.ReverseMutableSequencedIterator;
import io.github.tresty.collections.iterator.MutableSequencedIterator;

@ExtendWith(MockitoExtension.class)
class ReverseMutableSequencedIteratorTests {

    @Test
    void addAfter_CallsAddBeforeOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) MutableSequencedIterator<String> iterator) {
        final var reverseIterator = new ReverseMutableSequencedIterator<>(iterator);

        reverseIterator.addAfter("test");

        Mockito.verify(iterator, Mockito.times(1)).addBefore("test");
    }

    @Test
    void addBefore_CallsAddAfterOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) MutableSequencedIterator<String> iterator) {
        final var reverseIterator = new ReverseMutableSequencedIterator<>(iterator);

        reverseIterator.addBefore("test");

        Mockito.verify(iterator, Mockito.times(1)).addAfter("test");
    }

    @Test
    void set_CallsSetOnInternalIterator(
            final @Mock(strictness = Strictness.STRICT_STUBS) MutableSequencedIterator<String> iterator) {
        final var reverseIterator = new ReverseMutableSequencedIterator<>(iterator);

        reverseIterator.set("test");

        Mockito.verify(iterator, Mockito.times(1)).set("test");
    }
}
