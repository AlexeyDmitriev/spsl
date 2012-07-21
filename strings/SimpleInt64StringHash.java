package strings;

import numbers.IntegerUtils;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class SimpleInt64StringHash extends AbstractStringHash {
    private long[] hash;
    private static long[] powers;
    private static long[] reversePowers;
    public static long multiplier = 97;
    public static long reverse;

    static {
        reverse = IntegerUtils.power(multiplier, reverse);
    }


    public SimpleInt64StringHash(CharSequence string) {
        int length = string.length();
        ensureLength(length);
        hash = new long[length + 1];
        hash[0] = 0;
        for (int i = 0; i < length; ++i) {
            hash[i + 1] = hash[i] + string.charAt(i) * multiplier;
        }
    }

    private static void ensureLength(int length) {
        int oldLen = powers.length;
        powers = new long[length];
        reversePowers = new long[length];
        powers[0] = 1;
        reversePowers[0] = 1;

        for (int i = 1; i < length; ++i) {
            powers[i] = powers[i - 1] * multiplier;
            reversePowers[i] = reversePowers[i - 1] * multiplier;
        }
    }

    @Override
    public long hash(int from, int to) {
        return (hash[to + 1] - hash[from]) * reversePowers[from];
    }

    @Override
    public int length() {
        return hash.length - 1;
    }
}
