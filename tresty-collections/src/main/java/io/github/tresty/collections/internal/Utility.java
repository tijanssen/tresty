/*-
 * #%L
 * tresty-collections
 * %%
 * Copyright (C) 2025 Timo Janssen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
package io.github.tresty.collections.internal;

/**
 * The Class Utility.
 */
public final class Utility {

    @SuppressWarnings("checkstyle:MagicNumber")
    static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Utility() {
    }

    /**
     * New length.
     *
     * @param oldLength the old length
     * @param minGrowth the min growth
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
