package io.github.tresty.collections;

import io.github.tresty.collections.collection.Collection;
import io.github.tresty.common.GuardViolationException;

/**
 * The Class Guard.
 */
public final class Guard {

    /**
     * Against contains null.
     *
     * @param <T> the generic type
     * @param c   the c
     */
    public static <T> void againstContainsNull(final Collection<? extends T> c) {
        for (final var element : c) {
            if (element == null) {
                throw new GuardViolationException();
            }
        }
    }

    /**
     * Against contains null.
     *
     * @param <T>     the generic type
     * @param c       the c
     * @param message the message
     */
    public static <T> void againstContainsNull(final Collection<? extends T> c, final String message) {
        for (final var element : c) {
            if (element == null) {
                throw new GuardViolationException(message);
            }
        }
    }

    /**
     * Against empty.
     *
     * @param <T> the generic type
     * @param c   the c
     */
    public static <T> void againstEmpty(final Collection<? extends T> c) {
        if (c.isEmpty()) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against empty.
     *
     * @param <T>     the generic type
     * @param c       the c
     * @param message the message
     */
    public static <T> void againstEmpty(final Collection<? extends T> c, final String message) {
        if (c.isEmpty()) {
            throw new GuardViolationException(message);
        }
    }

    /**
     * Against non empty.
     *
     * @param <T> the generic type
     * @param c   the c
     */
    public static <T> void againstNonEmpty(final Collection<? extends T> c) {
        if (!c.isEmpty()) {
            throw new GuardViolationException();
        }
    }

    /**
     * Against non empty.
     *
     * @param <T>     the generic type
     * @param c       the c
     * @param message the message
     */
    public static <T> void againstNonEmpty(final Collection<? extends T> c, final String message) {
        if (!c.isEmpty()) {
            throw new GuardViolationException(message);
        }
    }

    private Guard() {
    }
}
