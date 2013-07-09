package name.admitriev.spsl.hacks;

import name.admitriev.spsl.collections.ArrayUtils;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class JavaHashSet {
    private int invertHash(int h) {
        h ^= (h >>> 4) ^ (h >>> 7) ^ (h >>> 8) ^ (h >>> 14) ^ (h >>> 15)
                ^ (h >>> 18) ^ (h >>> 19) ^ (h >>> 20) ^ (h >>> 21)
                ^ (h >>> 23) ^ (h >>> 26) ^ (h >>> 28);
        return h;
    }

    private int bitReverse(int h) {
        int res = 0;
        for (int i = 0; i < 31; i++)
            if ((h & (1 << i)) != 0)
                res |= (1 << (30 - i));
        return res;
    }

    public int[] generateArray(int size, int max) {
        int[] s = new int[size];
        for (int i = 0, val = 0; i < size; i++) {
            s[i] = Integer.MAX_VALUE;
            while (s[i] > max)
                s[i] = invertHash(bitReverse(val++));
        }

        ArrayUtils.sort(s);
        return s;
    }
}
