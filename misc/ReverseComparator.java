package misc;

import java.util.Comparator;

public class ReverseComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T t, T t1) {
        return t1.compareTo(t);
    }
}
