package io.github.tresty.collections.internal;

import java.lang.reflect.Modifier;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilityTests {

    @Test
    void newLength_OldCapacityIsMaxArraySizeAndMinGrowthAndPrefGrothAreGreaterThanOldCapacity_ThrowsRuntimeException() {
        Assertions.assertThatRuntimeException()
                .isThrownBy(() -> Utility.newLength(Utility.MAX_ARRAY_SIZE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void isUtilityClass() {
        for (final var method : Utility.class.getDeclaredMethods()) {
            final var modifiers = method.getModifiers();
            Assertions.assertThat(Modifier.isStatic(modifiers)).isTrue();
        }
        final var constructors = Utility.class.getDeclaredConstructors();
        Assertions.assertThat(constructors).hasSize(1);
        final var constructor = constructors[0];
        final var modifiers = constructor.getModifiers();
        Assertions.assertThat(Modifier.isPrivate(modifiers)).isTrue();
        constructor.setAccessible(true);
        Assertions.assertThatNoException().isThrownBy(constructor::newInstance);
    }
}
