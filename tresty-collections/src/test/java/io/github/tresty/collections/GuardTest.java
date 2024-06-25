package io.github.tresty.collections;

import java.lang.reflect.Modifier;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import io.github.tresty.collections.list.MutableArrayList;
import io.github.tresty.common.GuardViolationException;

class GuardTest {

    @Nested
    class AgainstEmpty {

        @Nested
        class WithCollection {

            @Test
            void collectionIsEmpty_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstEmpty(new MutableArrayList<Integer>()));
            }

            @Test
            void collectionIsNotEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstEmpty(new MutableArrayList<String>("test")));
            }
        }

        @Nested
        class WithCollectionAndString {

            @Test
            void collectionIsEmpty_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstEmpty(new MutableArrayList<Integer>(), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @Test
            void collectionIsNotEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstEmpty(new MutableArrayList<String>("test"), FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstNonEmpty {

        @Nested
        class WithCollection {

            @Test
            void collectionIsNonEmpty_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonEmpty(new MutableArrayList<String>("test")));
            }

            @Test
            void collectionIsEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstNonEmpty(new MutableArrayList<String>()));
            }
        }

        @Nested
        class WithCollectionAndString {

            @Test
            void collectionIsNonEmpty_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonEmpty(new MutableArrayList<String>("test"), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @Test
            void collectionIsEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstNonEmpty(new MutableArrayList<String>(), FAILURE_MESSAGE));
            }
        }
    }

    private static final String FAILURE_MESSAGE = "Guard failed.";

    @Test
    void IsUtilityClass() {
        for (final var method : Guard.class.getDeclaredMethods()) {
            final var modifiers = method.getModifiers();
            Assertions.assertThat(Modifier.isStatic(modifiers)).isTrue();
        }
        final var constructors = Guard.class.getDeclaredConstructors();
        Assertions.assertThat(constructors).hasSize(1);
        final var constructor = constructors[0];
        final var modifiers = constructor.getModifiers();
        Assertions.assertThat(Modifier.isPrivate(modifiers)).isTrue();
        constructor.setAccessible(true);
        Assertions.assertThatNoException().isThrownBy(constructor::newInstance);
    }
}
