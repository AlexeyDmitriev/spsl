package name.admitriev.spsl.collections;

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
        if (res != 0) {
            return res;
        }
        return ((Comparable<S>) second).compareTo(other.second);
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair pair = (Pair) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) {
            return false;
        }
        if (second != null ? !second.equals(pair.second) : pair.second != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
