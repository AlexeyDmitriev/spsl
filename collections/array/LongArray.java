package collections.array;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class LongArray extends Array<Long> {
    private final long[] array;

    public LongArray(long... array) {
        this.array = array;
    }

    @Override
    public Long get(int i) {
        return array[i];
    }

    @Override
    public Long set(int index, Long element) {
        Long res = array[index];
        array[index] = element;
        return res;
    }

    @Override
    public int size() {
        return array.length;
    }
}