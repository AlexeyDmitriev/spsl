package strings;

import numbers.IntegerUtils;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class TwoIntStringHash extends AbstractStringHash {
    private long[][] hash;
    private static long multiplier = 97;
    private static int[] mods;
    private static long[] reverseMultiplier = new long[2];

    private static long[][] powers = new long[2][];
    private static long[][] reversePowers = new long[2][];

    static {
        mods = new int[]{(int) 1e9 + 7, (int) 1e9 + 9};
        for (int i = 0; i < 2; ++i) {
            reverseMultiplier[i] = IntegerUtils.modInverse(multiplier, mods[i]);
        }
    }

    TwoIntStringHash(CharSequence string) {
        int length = string.length();
        ensureLength(length);
        hash = new long[2][length + 1];
        for (int i = 0; i < 2; ++i) {
            hash[i][0] = 0;
            for (int j = 0; j < length; ++j) {
                hash[i][j + 1] = (hash[i][j] + string.charAt(j) * multiplier) % mods[i];
            }
        }
    }

    private void ensureLength(int length) {
        for (int i = 0; i < 2; ++i) {
            powers[i][0] = 1;
            reversePowers[i][0] = 1;
            for (int j = 1; j < length; ++j) {
                powers[i][j] = (powers[i][j - 1] * multiplier) % mods[i];
                reversePowers[i][j] = (reversePowers[i][j - 1] * reverseMultiplier[i]) % mods[i];
            }
        }
    }

    @Override
    public long hash(int from, int to) {
        return oneHash(from, to, 0) << 32 + oneHash(from, to, 1);
    }

    private long oneHash(int from, int to, int i) {
        return (hash[i][to + 1] - hash[i][from] + mods[i]) * reversePowers[i][from];
    }

    @Override
    public int length() {
        return hash[0].length;
    }
}
