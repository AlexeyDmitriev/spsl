package collections;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class DSU {
    private int[] dsu;
    private int[] size;

    public DSU(int n) {
        dsu = new int[n];
        for (int i = 0; i < n; ++i) {
            dsu[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
    }

    public int get(int a) {
        if (dsu[a] == a) {
            return a;
        }
        return dsu[a] = get(dsu[a]);
    }

    public void union(int a, int b) {
        a = get(a);
        b = get(b);
        if (a == b) {
            return;
        }
        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        dsu[b] = a;
        size[a] += size[b];
    }

}
