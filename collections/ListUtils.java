package collections;

import misc.Filter;
import misc.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class ListUtils {
    public static <E> void unique(List<E> list) {
        int lastPasted = 0;
        for (int i = 1; i < list.size(); ++i) {
            if (!list.get(i).equals(list.get(lastPasted))) {
                list.set(++lastPasted, list.get(i));
            }
        }
        int size = lastPasted + 1;
        while (list.size() > size)
            list.remove(list.size() - 1);
    }

    public static <E> List<E> filter(Iterable<E> list, Filter<E> filter) {
        List<E> result = new ArrayList<E>();
        for (E entry : list) {
            if (filter.accept(entry))
                result.add(entry);
        }
        return result;
    }

    public static <V, A> List<V> apply(Iterable<A> list, Function<A, V> function) {
        List<V> result = new ArrayList<V>();
        for (A entry : list)
            result.add(function.apply(entry));

        return result;
    }
}
