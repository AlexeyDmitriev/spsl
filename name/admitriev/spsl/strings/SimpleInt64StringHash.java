package name.admitriev.spsl.strings;

public class SimpleInt64StringHash extends AbstractStringHash {
    private long[] hash;
    private static long[] powers;
    public static long multiplier = 97;

    public SimpleInt64StringHash(CharSequence string) {
        int length = string.length();
        ensureLength(length);
        hash = new long[length + 1];
        hash[0] = 0;
        for (int i = 0; i < length; ++i) {
            hash[i + 1] = hash[i] * multiplier + string.charAt(i);
        }
    }

    private static void ensureLength(int length) {
        if(powers != null && length + 1 <= powers.length)
            return;
        powers = new long[length + 1];
        powers[0] = 1;

        for (int i = 1; i <= length; ++i) {
            powers[i] = powers[i - 1] * multiplier;
        }
    }

    @Override
    public long hash(int from, int to) {
        return hash[to] - hash[from] * powers[to - from];
    }

    @Override
    public int length() {
        return hash.length - 1;
    }
}
