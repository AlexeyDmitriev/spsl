package collections.array;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class ObjectArray<T> extends Array<T> {
    private final T[] array;

    public ObjectArray(T[] array) {
        this.array = array;
    }

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public T set(int index, T element) {
        T res = array[index];
        array[index] = element;
        return res;
    }
}
