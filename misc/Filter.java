package misc;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public interface Filter<T> {
    public boolean accept(T value);
}
