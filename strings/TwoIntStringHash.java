package strings;

import numbers.IntegerUtils;

import java.util.Random;

public class TwoIntStringHash extends AbstractStringHash {
    private long[][] hash;
    private static long multiplier = 97;
    private static int[] mods;

    private static long[][] powers = new long[2][];

    private static int genPrime(Random random) {
        return (int) IntegerUtils.getNextPrime(random.nextInt((int) 1e9) + (int) (1e9));
    }

    static {
        Random random = new Random();
        mods = new int[]{genPrime(random), genPrime(random)};
    }

    public TwoIntStringHash(CharSequence string) {
        int length = string.length();
        ensureLength(length);
        hash = new long[2][length + 1];
        for (int i = 0; i < 2; ++i) {
            hash[i][0] = 0;
            for (int j = 0; j < length; ++j) {
                hash[i][j + 1] = (hash[i][j] * multiplier + string.charAt(j)) % mods[i];
            }
        }
    }

    private void ensureLength(int length) {
        if(powers[0] != null && length + 1 <= powers[0].length)
            return;
		powers = new long[2][length + 1];
        for (int i = 0; i < 2; ++i) {
            powers[i][0] = 1;
            for (int j = 1; j <= length; ++j) {
                powers[i][j] = (powers[i][j - 1] * multiplier) % mods[i];
            }
        }
    }

    @Override
    public long hash(int from, int to) {
        return oneHash(from, to, 0) * (1L << 32) + oneHash(from, to, 1);
    }

    private long oneHash(int from, int to, int i) {
        return (hash[i][to] - hash[i][from] * powers[i][to - from] % mods[i] + mods[i]) % mods[i];
    }

    @Override
    public int length() {
        return hash[0].length - 1;
    }
}
