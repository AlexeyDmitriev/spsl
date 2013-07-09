package name.admitriev.spsl.collections.array;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class IntArray extends Array<Integer> {
    private final int[] array;

    public IntArray(int... array) {
        this.array = array;
    }

    @Override
    public Integer get(int i) {
        return array[i];
    }

    @Override
    public Integer set(int index, Integer element) {
        Integer res = array[index];
        array[index] = element;
        return res;
    }

    @Override
    public int size() {
        return array.length;
    }
}