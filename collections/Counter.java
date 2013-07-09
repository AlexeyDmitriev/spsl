package collections;

import java.util.HashMap;

public class Counter<T> extends HashMap<T, Long> {
    public void add(T key) {
        add(key, 1);
    }

    public void add(T key, long value) {
        put(key, get(key) + value);
    }

    public Long get(Object key) {
        return containsKey(key) ? super.get(key) : 0;
    }

}
