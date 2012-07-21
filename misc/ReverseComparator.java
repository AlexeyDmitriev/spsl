package misc;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class ReverseComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T t, T t1) {
        return t1.compareTo(t);
    }
}
