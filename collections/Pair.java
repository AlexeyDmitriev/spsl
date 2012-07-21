package collections;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class Pair<F, S> implements Comparable<Pair<F, S>> {

    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public int compareTo(Pair<F, S> other) {
        int res = ((Comparable<F>) first).compareTo(other.first);
        if (res != 0)
            return res;
        return ((Comparable<S>) second).compareTo(other.second);
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }
}
