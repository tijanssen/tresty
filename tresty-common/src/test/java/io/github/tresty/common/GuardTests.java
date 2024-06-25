package io.github.tresty.common;

import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class GuardTests {

    @Nested
    class AgainstContainsNull {

        @Nested
        class WithCollection {

            @Test
            void collectionContainsNoNull_NoExceptionIsThrown() {
                final var list = new ArrayList<String>();
                list.add("test");
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstContainsNull(list));
            }

            @Test
            void collectionContainsNull_ThrowsGuardViolationException() {
                final var list = new ArrayList<String>();
                list.add(null);
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstContainsNull(list));
            }
        }

        @Nested
        class WithCollectionAndString {

            @Test
            void collectionContainsNoNull_NoExceptionIsThrown() {
                final var list = new ArrayList<String>();
                list.add("test");
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstContainsNull(list, FAILURE_MESSAGE));
            }

            @Test
            void collectionContainsNull_ThrowsGuardViolationExceptionWithExpectedMessages() {
                final var list = new ArrayList<String>();
                list.add(null);
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstContainsNull(list, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithGenericArray {

            @Test
            void arrayContainsNoNull_NoExceptionIsThrown() {
                final Integer[] array = { 1 };
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstContainsNull(array));
            }

            @Test
            void arrayContainsNull_ThrowsGuardViolationException() {
                final Integer[] array = { null };
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstContainsNull(array));
            }
        }

        @Nested
        class WithGenericArrayAndString {

            @Test
            void arrayContainsNoNull_NoExceptionIsThrown() {
                final Integer[] array = { 1 };
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstContainsNull(array, FAILURE_MESSAGE));
            }

            @Test
            void arrayContainsNull_ThrowsGuardViolationExceptionWithExpectedMessage() {
                final Integer[] array = { null };
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstContainsNull(array, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }
    }

    @Nested
    class AgainstEmpty {

        @Nested
        class WithCollection {

            @Test
            void collectionIsEmpty_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstEmpty(new ArrayList<String>()));
            }

            @Test
            void collectionIsNotEmpty_NoExceptionIsThrown() {
                final var list = new ArrayList<String>();
                list.add("test");
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstEmpty(list));
            }
        }

        @Nested
        class WithCollectionAndString {

            @Test
            void collectionIsEmpty_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstEmpty(new ArrayList<String>(), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @Test
            void collectionIsNotEmpty_NoExceptionIsThrown() {
                final var list = new ArrayList<String>();
                list.add("test");
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstEmpty(list, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithGenericArray {

            @Test
            void arrayIsEmpty_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstEmpty(new String[0]));
            }

            @Test
            void arrayIsNotEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstEmpty(new String[1]));
            }
        }

        @Nested
        class WithGenericArrayAndStringMessage {

            @Test
            void arrayIsEmpty_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstEmpty(new String[0], FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @Test
            void arrayIsNotEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstEmpty(new String[1], FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstFalse {

        @Nested
        class WithBooleanExpression {

            @Test
            void expressionIsFalse_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstFalse(false));
            }

            @Test
            void expressionIsTrue_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstFalse(true));
            }
        }

        @Nested
        class WithBooleanExpressionAndStringMessage {

            @Test
            void epressionIsFalse_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstFalse(false, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Test
        void expressionIsTrue_NoExceptionIsThrown() {
            Assertions.assertThatNoException().isThrownBy(() -> Guard.againstFalse(true, FAILURE_MESSAGE));
        }
    }

    @Nested
    class AgainstGreaterThenZero {

        @Nested
        class WithBigDecimalValue {

            @ParameterizedTest
            @ValueSource(strings = { "0.2", "0.4", "0.6" })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigDecimal(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "-0.2", "-0.4" })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigDecimal(value)));
            }
        }

        @Nested
        class WithBigDecimalValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "0.2", "0.4", "0.6" })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigDecimal(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "-0.2", "-0.4" })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigDecimal(value), FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithBigInteger {

            @ParameterizedTest
            @ValueSource(strings = { "1", "2", "3" })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigInteger(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "-1", "-2" })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigInteger(value)));
            }
        }

        @Nested
        class WithBigIntegerValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "1", "2", "3" })
            void valueIsGreaterThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigInteger(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "-1", "-2" })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(new BigInteger(value), FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithByteValue {

            @ParameterizedTest
            @ValueSource(bytes = { 1, 2, 3 })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, -1, -2 })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }
        }

        @Nested
        class WithByteValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(bytes = { 1, 2, 3 })
            void valueIsGreaterThanZero_THrowsGuardViolationExceptionWithExpectedMessage(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, -1, -2 })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithDoubleValue {

            @ParameterizedTest
            @ValueSource(doubles = { 0.1d, 0.01d, 0.001d })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, -0.1d, -0.01d })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }
        }

        @Nested
        class WithDoubleValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(doubles = { 0.1d, 0.01d, 0.001d })
            void valueIsGreaterThanZero_ThrowsGuradViolationExceptionWithExpectedMessage(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, -0.1d, -0.01d })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithFloatValue {

            @ParameterizedTest
            @ValueSource(floats = { 0.1f, 0.01f, 0.01f })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, -0.1f, -0.01f })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }
        }

        @Nested
        class WithFloatValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(floats = { 0.1f, 0.01f, 0.001f })
            void valueIsGreaterThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, -0.1f, -0.01f })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithIntValue {

            @ParameterizedTest
            @ValueSource(ints = { 1, 2, 3 })
            void valueIsGreaterThanZero_ThrowsGuradViolationException(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, -1, -2 })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }
        }

        @Nested
        class WithIntValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { 1, 2, 3 })
            void valueIsGreaterThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, -1, -2 })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithLongValue {

            @ParameterizedTest
            @ValueSource(longs = { 1L, 2L, 3L })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, -1L, -2L })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }
        }

        @Nested
        class WithLongValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { 1L, 2L, 3L })
            void valueIsGreaterThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, -1L, -2L })
            void valueIsNotGraterThanZero_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithShortValue {

            @ParameterizedTest
            @ValueSource(shorts = { 1, 2, 3 })
            void valueIsGreaterThanZero_ThrowsGuardViolationException(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, -1, -2 })
            void valueIsNotGraterThanZero_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstGreaterThanZero(value));
            }
        }

        @Nested
        class WithShortValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(shorts = { 1, 2, 3 })
            void valueIsGreaterThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, -1, -2 })
            void valueIsNotGreaterThanZero_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstGreaterThanZero(value, FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstInvalidIndex {

        @Nested
        class WithIntIndexAndIntLength {

            @ParameterizedTest
            @ValueSource(ints = { -1, 4 })
            void indexIsInvalid_ThrowsGuardViolationException(final int index) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstInvalidIndex(index, 4));
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, 1, 2, 3 })
            void indexIsValid_NoExceptionIsThrown(final int index) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstInvalidIndex(index, 4));
            }
        }

        @Nested
        class WithIntIndexAndIntLengthAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { -1, 4 })
            void indexIsInvalid_ThrowsGuardViolationExceptionWithExpectedMessage(final int index) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstInvalidIndex(index, 4, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, 1, 2, 3 })
            void indexIsValid_NoExceptionIsThrown(final int index) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstInvalidIndex(index, 4, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithLongIndexAndLongLength {

            @ParameterizedTest
            @ValueSource(longs = { -1L, 4L })
            void indexIsInvalid_ThrowsGuardViolationException(final long index) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstInvalidIndex(index, 4));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, 1L, 2L, 3L })
            void indexIsValid_NoExceptionIsThrown(final long index) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstInvalidIndex(index, 4));
            }
        }

        @Nested
        class WithLongIndexAndLongLengthAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { -1L, 4L })
            void indexIsInvalid_ThrowsGuardViolationExceptionWithExpectedMessage(final long index) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstInvalidIndex(index, 4, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, 1L, 2L, 3L })
            void indexIsValid_NoExceptionIsThrown(final long index) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstInvalidIndex(index, 4, FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstLessThanZero {

        @Nested
        class WithBigDecimalValue {

            @ParameterizedTest
            @ValueSource(strings = { "-0.2", "-0.4", "-0.6" })
            void valueIsLessThanZero_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(new BigDecimal(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "0.2", "0.4" })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(new BigDecimal(value)));
            }
        }

        @Nested
        class WithBigDecimalValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-0.2", "-0.4", "-0.6" })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedmessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(new BigDecimal(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "0.2", "0.4" })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstLessThanZero(new BigDecimal(value), FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithBigIntegerValue {

            @ParameterizedTest
            @ValueSource(strings = { "-1", "-2", "-3" })
            void valueIsLessThanZero_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(new BigInteger(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "1", "2" })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(new BigInteger(value)));
            }
        }

        @Nested
        class WithBigIntegerValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-1", "-2", "-3" })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(new BigInteger(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "1", "2" })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstLessThanZero(new BigInteger(value), FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithByteValue {

            @ParameterizedTest
            @ValueSource(bytes = { -1, -2, -3 })
            void valueIsLessThanZero_ThrowsGuardViolationException(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, 1, 2 })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value));
            }
        }

        @Nested
        class WithByteValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(bytes = { -1, -2, -3 })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, 1, 2 })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithDoubleValue {

            @ParameterizedTest
            @ValueSource(doubles = { -01d, -0.01d, -0.001d })
            void valueIsLessThanZero_THrowsGuardViolationException(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, 0.1d, 0.01d })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value));
            }
        }

        @Nested
        class WithDoubleValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(doubles = { -0.1d, -0.01d, -0.001d })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, 0.1d, 0.01d })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithFloatValue {

            @ParameterizedTest
            @ValueSource(floats = { -01f, -0.01f, -0.001f })
            void valueIsLessThanZero_ThrowsGuardViolationException(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, 0.1f, 0.01f })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value));
            }
        }

        @Nested
        class WithFloatValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(floats = { -0.1f, -0.01f, -0.001f })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, 0.1f, 0.01f })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithIntValue {

            @ParameterizedTest
            @ValueSource(ints = { -1, -2, -3 })
            void valueIsLessThanZero_ThrowsGuardViolationException(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, 1, 2 })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value));
            }
        }

        @Nested
        class WithIntValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { -1, -2, -3 })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, 1, 2 })
            void valueIsNotLessThanzero_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithLongValue {

            @ParameterizedTest
            @ValueSource(longs = { -1L, -2L, -3L })
            void valueIsLessThanZero_ThrowsGuardViolationException(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, 1L, 2L })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value));
            }
        }

        @Nested
        class WithLongValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { -1L, -2L, -3L })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, 1L, 2L })
            void valueIsNotLessThanZero_NoEceptionisThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithShortValue {

            @ParameterizedTest
            @ValueSource(shorts = { -1, -2, -3 })
            void valueIsLessThanZero_THrowsGuardViolationException(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value));
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, 1, 2 })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value));
            }
        }

        @Nested
        class WithShortValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(shorts = { -1, -2, -3 })
            void valueIsLessThanZero_ThrowsGuardViolationExceptionWithExpectedMessage(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, 1, 2 })
            void valueIsNotLessThanZero_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstLessThanZero(value, FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstNonEmpty {

        @Nested
        class WithCollection {

            @Test
            void collectionIsEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonEmpty(new ArrayList<String>()));
            }

            @Test
            void collectionIsNotEmpty_ThrowsGuardViolationException() {
                final var list = new ArrayList<String>();
                list.add("test");
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonEmpty(list));
            }
        }

        @Nested
        class WithCollectionAndString {

            @Test
            void collectionIsNotEmpty_THrowsGuardViolationExceptionWithExpectedMessage() {
                final var list = new ArrayList<String>();
                list.add("test");
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonEmpty(list, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithGenericArray {

            @Test
            void arrayisEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonEmpty(new String[0]));
            }

            @Test
            void arrayIsNonEmpty_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonEmpty(new String[1]));
            }
        }

        @Nested
        class WithGenericArrayAndString {

            @Test
            void arrayisEmpty_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstNonEmpty(new String[0], FAILURE_MESSAGE));
            }

            @Test
            void arrayIsNonEmpty_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonEmpty(new String[1], FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }
    }

    @Nested
    class AgainstNonNull {

        @Nested
        class WithGenericValue {

            @ParameterizedTest
            @EmptySource
            void valueIsNonNull_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonNull(value));
            }

            @ParameterizedTest
            @NullSource
            void valueIsNull_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonNull(value));
            }
        }

        @Nested
        class WithGenericValueAndStringMessage {

            @ParameterizedTest
            @EmptySource
            void valueIsNonNull_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonNull(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @NullSource
            void valueIsNull_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonNull(value, FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstNonZero {

        @Nested
        class WithBigDecimal {

            @ParameterizedTest
            @ValueSource(strings = { "-0.4", "-0.2", "0.2", "0.4" })
            void valueIsNonZero_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(new BigDecimal(value)));
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(BigDecimal.ZERO));
            }
        }

        @Nested
        class WithBigDecimalValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-0.4", "-0.2", "0.2", "0.4" })
            void valueIsNonZero_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(new BigDecimal(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstNonZero(BigDecimal.ZERO, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithBigInteger {

            @ParameterizedTest
            @ValueSource(strings = { "-2", "-1", "1", "2" })
            void valueIsNonZero_THrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(new BigInteger(value)));
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(BigInteger.ZERO));
            }
        }

        @Nested
        class WithBigIntegerValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-2", "-1", "1", "2" })
            void valueIsNonZero_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(new BigInteger(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstNonZero(BigInteger.ZERO, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithByteValue {

            @ParameterizedTest
            @ValueSource(bytes = { -2, -1, 1, 2 })
            void valueIsNonZero_THrowsGuardViolationException(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value));
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero((byte) 0));
            }
        }

        @Nested
        class WithByteValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(bytes = { -2, -1, 1, 2 })
            void valueIsNonZero_ThrowsGuardViolationExceptionWithExpectedMessage(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionisThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero((byte) 0, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithDoubleValue {

            @ParameterizedTest
            @ValueSource(doubles = { -0.01, -0.1, 0.1, 0.01 })
            void valueIsNonZero_ThrowsGuardViolationException(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value));
            }

            @Test
            void vlaueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0.0d));
            }
        }

        @Nested
        class WithDoubleValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(doubles = { -0.01, -0.1, 0.1, 0.01 })
            void valueIsNonZero_THrowsGuardViolationExceptionWithExpectedMessage(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0.0d, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithFloatValue {

            @ParameterizedTest
            @ValueSource(floats = { -0.01f, -0.1f, 0.1f, 0.01f })
            void valueIsNonZero_ThrowsGuardViolationException(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value));
            }

            @Test
            void valueIsZero_NoExceptionIsThrowsn() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0.0f));
            }
        }

        @Nested
        class WithFloatValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(floats = { -0.01f, -0.1f, 0.1f, 0.01f })
            void valueIsNonZero_ThrowsGuardViolationExceptionWithExpectedmessage(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0.0f, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithIntValue {

            @ParameterizedTest
            @ValueSource(ints = { -2, -1, 1, 2 })
            void valueIsNonZero_THrowsGuardViolationException(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value));
            }

            @Test
            void valueIsZero_NoExceptionisThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0));
            }
        }

        @Nested
        class WithIntValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { -2, -1, 1, 2 })
            void valueIsNonZero_ThrowsGuardViolationExceptionWithExpectedMessage(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithLongValue {

            @ParameterizedTest
            @ValueSource(longs = { -2L, -1L, 1L, 2L })
            void valueIsNonZero_ThrowsGuardViolationException(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value));
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0L));
            }
        }

        @Nested
        class WithLongValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { -2L, -1L, 1L, 2L })
            void valueIsNonZero_ThrowsGuradViolationExceptionWithExpectedMessage(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero(0L, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithShortValue {

            @ParameterizedTest
            @ValueSource(shorts = { -2, -1, 1, 2 })
            void valueIsNonZero_ThrowsGuardViolationException(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value));
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero((short) 0));
            }
        }

        @Nested
        class WithShortValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(shorts = { -2, -1, 1, 2 })
            void valueIsNonZero_ThrowsGuardViolationExceptionWithExpectedMessage(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNonZero(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void valueIsZero_NoExceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNonZero((short) 0, FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstNull {

        @Nested
        class WithGenericValue {

            @ParameterizedTest
            @EmptySource
            void valueIsNotNull_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNull(value));
            }

            @ParameterizedTest
            @NullSource
            void valueIsNull_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNull(value));
            }
        }

        @Nested
        class WithGenericValueAndStringMessage {

            @ParameterizedTest
            @EmptySource
            void valueIsNotNull_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstNull(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @NullSource
            void valueIsNull_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstNull(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }
    }

    @Nested
    class AgainstTrue {

        @Nested
        class WithBooleanExpression {

            @Test
            void epressionIsFalse_NoEceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstTrue(false));
            }

            @Test
            void epressionIsTrue_ThrowsGuardViolationEception() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstTrue(true));
            }
        }

        @Nested
        class WithBooleanExpressionAndStringMessage {

            @Test
            void epressionIsTrue_ThrowsGuardViolationEceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstTrue(true, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @Test
            void expressionIsFalse_NoEceptionIsThrown() {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstTrue(false, FAILURE_MESSAGE));
            }
        }
    }

    @Nested
    class AgainstZero {

        @Nested
        class WithBigDecimalValue {

            @ParameterizedTest
            @ValueSource(strings = { "-0.4", "-0.2", "0.2", "0.4" })
            void valueIsNonZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(new BigDecimal(value)));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(BigDecimal.ZERO));
            }
        }

        @Nested
        class WithBigDecimalValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-0.4", "-0.2", "0.2", "0.4" })
            void valueIsNonZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstZero(new BigDecimal(value), FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(BigDecimal.ZERO, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithBigIntegerValue {

            @ParameterizedTest
            @ValueSource(strings = { "-2", "-1", "1", "2" })
            void valueIsNonZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(new BigInteger(value)));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(BigInteger.ZERO));
            }
        }

        @Nested
        class WithBigIntegerValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-2", "-1", "1", "2" })
            void valueIsNonZero_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstZero(new BigInteger(value), FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(BigInteger.ZERO, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithByteValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(bytes = { -2, -1, 1, 2 })
            void valueIsNotZero_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value, FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero((byte) 0, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithByteValueValue {

            @ParameterizedTest
            @ValueSource(bytes = { -2, -1, 1, 2 })
            void valueIsNotZero_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero((byte) 0));
            }
        }

        @Nested
        class WithDoubleValue {

            @ParameterizedTest
            @ValueSource(doubles = { -0.01d, -0.1d, 0.1d, 0.01d })
            void valueIsNonZero_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0.0d));
            }
        }

        @Nested
        class WithDoubleValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(doubles = { -0.01d, -0.1d, 0.1d, 0.01d })
            void valueIsNonZero_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value, FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0.d, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithFloatValue {

            @ParameterizedTest
            @ValueSource(floats = { -0.01f, -0.1f, 0.1f, 0.01f })
            void valueIsNonZero_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0.0f));
            }
        }

        @Nested
        class WithFloatValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(floats = { -0.01f, -0.1f, 0.1f, 0.01f })
            void valueIsNonZero_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value, FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0.0f, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithIntValue {

            @ParameterizedTest
            @ValueSource(ints = { -2, -1, 1, 2 })
            void valueIsNotZero_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0));
            }
        }

        @Nested
        class WithIntValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { -2, -1, 1, 2 })
            void valueIsNotZero_ThrowsGuardViolationExceptionWithExpectedMessage(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value, FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithLongValue {

            @ParameterizedTest
            @ValueSource(longs = { -2L, -1L, 1L, 2L })
            void valueIsNotZero_ThrowsGuardViolationExceptionWithExpectedMessage(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0L));
            }
        }

        @Nested
        class WithLongValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { -2L, -1L, 1L, 2L })
            void valueIsNotZero_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value, FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMesage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero(0L, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithShortValue {

            @ParameterizedTest
            @ValueSource(shorts = { -2, -1, 1, 2 })
            void valueIsNotZero_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationException() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero((short) 0));
            }
        }

        @Nested
        class WithShortValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(shorts = { -2, -1, 1, 2 })
            void valueIsNotZero_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZero(value, FAILURE_MESSAGE));
            }

            @Test
            void valueIsZero_ThrowsGuardViolationExceptionWithExpectedMessage() {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZero((short) 0, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }
    }

    @Nested
    class AgainstZeroOrGreater {

        @Nested
        class WithBigDecimalValue {

            @ParameterizedTest
            @ValueSource(strings = { "-0.2", "-0.4", "-0.6" })
            void valueIsNotZeroOrGreater_NoExceptionisThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(new BigDecimal(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "0.2", "0.4" })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(new BigDecimal(value)));
            }
        }

        @Nested
        class WithBigDecimalValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-0.2", "-0.4", "-0.6" })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstZeroOrGreater(new BigDecimal(value), FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "0.2", "0.4" })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(new BigDecimal(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithBigIntegerValue {

            @ParameterizedTest
            @ValueSource(strings = { "-1", "-2", "-3" })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(new BigInteger(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "1", "2" })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(new BigInteger(value)));
            }
        }

        @Nested
        class WithBigIntegerValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "-1", "-2", "-3" })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstZeroOrGreater(new BigInteger(value), FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "1", "2" })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(new BigInteger(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithByteValue {

            @ParameterizedTest
            @ValueSource(bytes = { -1, -2, -3 })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, 1, 2 })
            void valueIsZeroOrGreater_THrowsGGuardViolationException(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }
        }

        @Nested
        class WithByteValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(bytes = { -1, -2, -3 })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, 1, 2 })
            void valueIsZeroOrGreater_THrowsGGuardViolationExceptionWithExpectedMessage(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithDoubleValue {

            @ParameterizedTest
            @ValueSource(doubles = { -0.1d, -0.01d, -0.001d })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, 0.1d, 0.01d })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }
        }

        @Nested
        class WithDoubleValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(doubles = { -01d, -0.01d, -0.001d })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, 0.1d, 0.01d })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedMessage(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithFloatValue {

            @ParameterizedTest
            @ValueSource(floats = { -0.1f, -0.01f, -0.001f })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, 0.1f, 0.01f })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }
        }

        @Nested
        class WithFloatValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(floats = { -0.1f, -0.01f, -0.001f })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, 0.1f, 0.01f })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedMessage(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithIntValue {

            @ParameterizedTest
            @ValueSource(ints = { -1, -2, -3 })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, 1, 2, })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }
        }

        @Nested
        class WithIntValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { -1, -2, -3 })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, 1, 2 })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedmessage(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithLongValue {

            @ParameterizedTest
            @ValueSource(longs = { -1L, -2L, -3L })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, 1L, 2L })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }
        }

        @Nested
        class WithLongValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { -1L, -2L, -3L })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, 1L, 2L })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedMessage(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithShortValue {

            @ParameterizedTest
            @ValueSource(shorts = { -1, -2, -3 })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, 1, 2 })
            void valueIsZeroOrGreater_ThrowsGuardViolationException(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value));
            }
        }

        @Nested
        class WithShortValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(shorts = { -1, -2, -3 })
            void valueIsNotZeroOrGreater_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, 1, 2 })
            void valueIsZeroOrGreater_ThrowsGuardViolationExceptionWithExpectedMessage(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrGreater(value, FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }
    }

    @Nested
    class AgainstZeroOrLess {

        @Nested
        class WithBigDecimalValue {

            @ParameterizedTest
            @ValueSource(strings = { "0.2", "0.4", "0.6" })
            void valueIsZeroOrLess_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(new BigDecimal(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "-0.2", "-0.4" })
            void valueIsZeroOrLess_THrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(new BigDecimal(value)));
            }
        }

        @Nested
        class WithBigDecimalValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "0.2", "0.4", "0.6" })
            void valueIsZeroOrLess_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstZeroOrLess(new BigDecimal(value), FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0.0", "-0.2", "-0.4" })
            void valueIsZeroOrLess_THrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(new BigDecimal(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithBigIntegerValue {

            @ParameterizedTest
            @ValueSource(strings = { "1", "2", "3" })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(new BigInteger(value)));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "-1", "-2" })
            void valueIsZeroOrLess_ThrowsGuardViolationException(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(new BigInteger(value)));
            }
        }

        @Nested
        class WithBigIntegerValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(strings = { "1", "2", "3" })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final String value) {
                Assertions.assertThatNoException()
                        .isThrownBy(() -> Guard.againstZeroOrLess(new BigInteger(value), FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(strings = { "0", "-1", "-2" })
            void valueIsZeroOrLess_ThrowsGuardViolationExceptionWithExpectedMessage(final String value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(new BigInteger(value), FAILURE_MESSAGE))
                        .withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithByteValue {

            @ParameterizedTest
            @ValueSource(bytes = { 1, 2, 3 })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value));
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, -1, -2 })
            void valueIsZeroOrLess_ThrowsGuardViolationException(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value));
            }
        }

        @Nested
        class WithByteValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(bytes = { 1, 2, 3 })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final byte value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(bytes = { 0, -1, -2 })
            void valueIsZeroOrLess_ThrowsGuardViolationExceptionWithExpectedMessage(final byte value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithDoubleValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(doubles = { 0.1d, 0.01d, 0.001d })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, -0.1d, -0.01d })
            void valueIsZeroOrLess_ThrowsGuardViolationExceptionWithExpectedMessage(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithDoubleVValue {

            @ParameterizedTest
            @ValueSource(doubles = { 0.1d, 0.01d, 0.001d })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final double value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value));
            }

            @ParameterizedTest
            @ValueSource(doubles = { 0.0d, -0.1d, -0.01d })
            void valueIsZeroOrLess_ThrowsGuardViolationException(final double value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value));
            }
        }

        @Nested
        class WithFloatValue {

            @ParameterizedTest
            @ValueSource(floats = { 0.1f, 0.01f, 0.001f })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value));
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, -0.1f, -0.01f })
            void valueIsZeroOrLess_ThrowsGuardViolationException(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value));
            }
        }

        @Nested
        class WithFloatValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(floats = { 0.1f, 0.01f, 0.001f })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final float value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(floats = { 0.0f, -0.1f, -0.01f })
            void valueIsZeroOrLess_ThrowsGuardViolationExcpetionWithExpectedMessage(final float value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithIntValue {

            @ParameterizedTest
            @ValueSource(ints = { 1, 2, 3 })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value));
            }

            @ParameterizedTest
            @ValueSource(ints = { 0, -1, -2 })
            void valueIsZeroOrLess_ThrowsGuardViolationException(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value));
            }
        }

        @Nested
        class WithIntValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(ints = { 0, -1, -2 })
            void value_IsZeroOrLess_ThrowsGuradViolationExceptionWithExpectedMessage(final int value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }

            @ParameterizedTest
            @ValueSource(ints = { 1, 2, 3 })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final int value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
            }
        }

        @Nested
        class WithLongValue {

            @ParameterizedTest
            @ValueSource(longs = { 1L, 2L, 3L })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, -1L, -2L })
            void valueIsZeroOrLess_ThrowsGuardViolationException(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value));
            }
        }

        @Nested
        class WithLongValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(longs = { 1L, 2L, 3L })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final long value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(longs = { 0L, -1L, -2L })
            void valueIsZeroOrLess_ThrowsGuardViolationExceptionWithExpectedMessage(final long value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE)).withMessage(FAILURE_MESSAGE);
            }
        }

        @Nested
        class WithShortValue {

            @ParameterizedTest
            @ValueSource(shorts = { 1, 2, 3 })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value));
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, -1, -2 })
            void valueIsZeroOrLess_THrowsGuardViolationException(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value));
            }
        }

        @Nested
        class WithShortValueAndStringMessage {

            @ParameterizedTest
            @ValueSource(shorts = { 1, 2, 3 })
            void valueIsNotZeroOrLess_NoExceptionIsThrown(final short value) {
                Assertions.assertThatNoException().isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
            }

            @ParameterizedTest
            @ValueSource(shorts = { 0, -1, -2 })
            void valueIsZeroOrLess_ThrowsGuardViolationExceptionWithExpectedMessage(final short value) {
                Assertions.assertThatExceptionOfType(GuardViolationException.class)
                        .isThrownBy(() -> Guard.againstZeroOrLess(value, FAILURE_MESSAGE));
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
        Assertions.assertThatNoException().isThrownBy(() -> constructor.newInstance());
    }
}
