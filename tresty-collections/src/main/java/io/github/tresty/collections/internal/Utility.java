package io.github.tresty.collections.internal;

/**
 * The Class Utility.
 */
public class Utility {

    private Utility() {
    }

    static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * New length.
     *
     * @param oldLength  the old length
     * @param minGrowth  the min growth
     * @param prefGrowth the pref growth
     * @return the int
     */
    public static int newLength(final int oldLength, final int minGrowth, final int prefGrowth) {
        final var prefLength = oldLength + Math.max(minGrowth, prefGrowth);
        if (prefLength > 0 && prefLength <= MAX_ARRAY_SIZE) {
            return prefLength;
        } else {
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(final int oldLength, final int minGrowth) {
        final var minLength = oldLength + minGrowth;
        if (minLength < 0) {
            throw new RuntimeException();
        } else {
            return minLength;
        }
    }
}
