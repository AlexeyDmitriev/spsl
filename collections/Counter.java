package collections;

import java.util.TreeMap;

public class Counter<T> extends TreeMap<T, Integer> {
    public void add(T key) {
        add(key, 1);
    }

    public void add(T key, int value) {
        put(key, get(key) + value);
    }

    public Integer get(Object key) {
        return containsKey(key) ? super.get(key) : 0;
    }

}
