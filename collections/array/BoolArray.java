package collections.array;

import collections.Array;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class BoolArray extends Array<Boolean> {
    private final boolean[] array;

    public BoolArray(boolean... array) {
        this.array = array;
    }

    @Override
    public Boolean get(int i) {
        return array[i];
    }

    @Override
    public Boolean set(int index, Boolean element) {
        Boolean res = array[index];
        array[index] = element;
        return res;
    }

    @Override
    public int size() {
        return array.length;
    }
}
