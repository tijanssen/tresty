package io.github.tresty.common;

import java.io.Serial;

/**
 * The Class GuardViolationException.
 */
public final class GuardViolationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2584799091035425719L;

    /**
     * Instantiates a new guard violation exception.
     */
    public GuardViolationException() {
    }

    /**
     * Instantiates a new guard violation exception.
     *
     * @param message the message
     */
    public GuardViolationException(final String message) {
        super(message);
    }
}
