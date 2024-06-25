package io.github.tresty.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import org.jspecify.annotations.Nullable;

/**
 * The Class Guard.
 */
public final class Guard {

    public static <T> void againstContainsNull(final Collection<? extends T> c) {
        for (final var element : c) {
            if (element == null) {
                throw new GuardViolationException();
            }
        }
    }

    public static <T> void againstContainsNull(final Collection<? extends T> c, final String message) {
        for (final var element : c) {
            if (element == null) {
                throw new GuardViolationException(message);
            }
        }
    }

    public static <T> void againstContainsNull(final T[] array) {
        for (var i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new GuardViolationException();
            }
        }
    }

    public static <T> void againstContainsNull(final T[] array, final String message) {
        for (var i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new GuardViolationException(message);
            }
        }
    }

    public static <T> void againstEmpty(final Collection<? extends T> c) {
        if (c.isEmpty()) {
            throw new GuardViolationException();
        }
    }

    public static <T> void againstEmpty(final Collection<? extends T> c, final String message) {
        if (c.isEmpty()) {
            throw new GuardViolationException(message);
        }
    }

    public static <T> void againstEmpty(final T[] array) {
        if (array.length == 0) {
            throw new GuardViolationException();
        }
    }

    public static <T> void againstEmpty(final T[] array, final String message) {
        if (array.length == 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against false.
     *
     * @param expression the expression
     */
    public static void againstFalse(final boolean expression) {
        if (!expression) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against false.
     *
     * @param expression the expression
     * @param message    the message
     */
    public static void againstFalse(final boolean expression, final String message) {
        if (!expression) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final BigDecimal value, final String message) {
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) > 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final BigInteger value, final String message) {
        if (value.compareTo(BigInteger.ZERO) > 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final byte value) {
        if (value > 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final byte value, final String message) {
        if (value > 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final double value) {
        if (value > 0.0d) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final double value, final String message) {
        if (value > 0.0d) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final float value) {
        if (value > 0.0f) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final float value, final String message) {
        if (value > 0.0f) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final int value) {
        if (value > 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final int value, final String message) {
        if (value > 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final long value) {
        if (value > 0L) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final long value, final String message) {
        if (value > 0L) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value the value
     */
    public static void againstGreaterThanZero(final short value) {
        if (value > 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against greater than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstGreaterThanZero(final short value, final String message) {
        if (value > 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against invalid index.
     *
     * @param index  the index
     * @param length the length
     */
    public static void againstInvalidIndex(final int index, final int length) {
        if (index < 0 || index >= length) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against invalid index.
     *
     * @param index   the index
     * @param length  the length
     * @param message the message
     */
    public static void againstInvalidIndex(final int index, final int length, final String message) {
        if (index < 0 || index >= length) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against invalid index.
     *
     * @param index  the index
     * @param length the length
     */
    public static void againstInvalidIndex(final long index, final long length) {
        if (index < 0L || index >= length) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against invalid index.
     *
     * @param index   the index
     * @param length  the length
     * @param message the message
     */
    public static void againstInvalidIndex(final long index, final long length, final String message) {
        if (index < 0L || index >= length) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final BigDecimal value, final String message) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final BigInteger value, final String message) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final byte value) {
        if (value < 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final byte value, final String message) {
        if (value < 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final double value) {
        if (value < 0.0d) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final double value, final String message) {
        if (value < 0.0d) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final float value) {
        if (value < 0.0f) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final float value, final String message) {
        if (value < 0.0f) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final int value) {
        if (value < 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final int value, final String message) {
        if (value < 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final long value) {
        if (value < 0L) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final long value, final String message) {
        if (value < 0L) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against less than zero.
     *
     * @param value the value
     */
    public static void againstLessThanZero(final short value) {
        if (value < 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against less than zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstLessThanZero(final short value, final String message) {
        if (value < 0) {
            throw new GuardViolationException(message);
        }
    }

    public static <T> void againstNonEmpty(final Collection<? extends T> c) {
        if (!c.isEmpty()) {
            throw new GuardViolationException();
        }
    }

    public static <T> void againstNonEmpty(final Collection<? extends T> c, final String message) {
        if (!c.isEmpty()) {
            throw new GuardViolationException(message);
        }
    }

    public static <T> void againstNonEmpty(final T[] array) {
        if (array.length != 0) {
            throw new GuardViolationException();
        }
    }

    public static <T> void againstNonEmpty(final T[] array, final String message) {
        if (array.length != 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non null.
     *
     * @param <T>   the generic type
     * @param value the value
     */
    public static <T> void againstNonNull(final @Nullable T value) {
        if (value != null) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non null.
     *
     * @param <T>     the generic type
     * @param value   the value
     * @param message the message
     */
    public static <T> void againstNonNull(final @Nullable T value, final String message) {
        if (value != null) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final BigDecimal value) {
        if (!value.equals(BigDecimal.ZERO)) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final BigDecimal value, final String message) {
        if (!value.equals(BigDecimal.ZERO)) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final BigInteger value) {
        if (!value.equals(BigInteger.ZERO)) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final BigInteger value, final String message) {
        if (!value.equals(BigInteger.ZERO)) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final byte value) {
        if (value != 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final byte value, final String message) {
        if (value != 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final double value) {
        if (value != 0.0d) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public

    static void againstNonZero(final double value, final String message) {
        if (value != 0.0d) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final float value) {
        if (value != 0.0f) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final float value, final String message) {
        if (value != 0.0f) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final int value) {
        if (value != 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final int value, final String message) {
        if (value != 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final long value) {
        if (value != 0L) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final long value, final String message) {
        if (value != 0L) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non zero.
     *
     * @param value the value
     */
    public static void againstNonZero(final short value) {
        if (value != 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstNonZero(final short value, final String message) {
        if (value != 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against null.
     *
     * @param <T>   the generic type
     * @param value the value
     */
    public static <T> void againstNull(final @Nullable T value) {
        if (value == null) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against null.
     *
     * @param <T>     the generic type
     * @param value   the value
     * @param message the message
     */
    public static <T> void againstNull(final @Nullable T value, final String message) {
        if (value == null) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against true.
     *
     * @param expression the expression
     */
    public static void againstTrue(final boolean expression) {
        if (expression) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against true.
     *
     * @param expression the expression
     * @param message    the message
     */
    public static void againstTrue(final boolean expression, final String message) {
        if (expression) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final BigDecimal value) {
        if (value.equals(BigDecimal.ZERO)) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final BigDecimal value, final String message) {
        if (value.equals(BigDecimal.ZERO)) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final BigInteger value) {
        if (value.equals(BigInteger.ZERO)) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final BigInteger value, final String message) {
        if (value.equals(BigInteger.ZERO)) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final byte value) {
        if (value == 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final byte value, final String message) {
        if (value == 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final double value) {
        if (value == 0.0d) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final double value, final String message) {
        if (value == 0.0d) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final float value) {
        if (value == 0.0f) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final float value, final String message) {
        if (value == 0.0f) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final int value) {
        if (value == 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final int value, final String message) {
        if (value == 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final long value) {
        if (value == 0L) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final long value, final String message) {
        if (value == 0L) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero.
     *
     * @param value the value
     */
    public static void againstZero(final short value) {
        if (value == 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZero(final short value, final String message) {
        if (value == 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) >= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final BigDecimal value, final String message) {
        if (value.compareTo(BigDecimal.ZERO) >= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) >= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final BigInteger value, final String message) {
        if (value.compareTo(BigInteger.ZERO) >= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final byte value) {
        if (value >= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final byte value, final String message) {
        if (value >= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final double value) {
        if (value >= 0.0d) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final double value, final String message) {
        if (value >= 0.0d) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final float value) {
        if (value >= 0.0f) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final float value, final String message) {
        if (value >= 0.0f) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final int value) {
        if (value >= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final int value, final String message) {
        if (value >= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final long value) {
        if (value >= 0L) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final long value, final String message) {
        if (value >= 0L) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value the value
     */
    public static void againstZeroOrGreater(final short value) {
        if (value >= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or greater.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrGreater(final short value, final String message) {
        if (value >= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final BigDecimal value, final String message) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final BigInteger value, final String message) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final byte value) {
        if (value <= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final byte value, final String message) {
        if (value <= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final double value) {
        if (value <= 0.0d) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final double value, final String message) {
        if (value <= 0.0d) {

            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final float value) {
        if (value <= 0.0f) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final float value, final String message) {
        if (value <= 0.0f) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final int value) {
        if (value <= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final int value, final String message) {
        if (value <= 0) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final long value) {
        if (value <= 0L) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final long value, final String message) {
        if (value <= 0L) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against zero or less.
     *
     * @param value the value
     */
    public static void againstZeroOrLess(final short value) {
        if (value <= 0) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against zero or less.
     *
     * @param value   the value
     * @param message the message
     */
    public static void againstZeroOrLess(final short value, final String message) {
        if (value <= 0) {
            throw new GuardViolationException(message);
        }
    }

    private Guard() {
    }
}
