package collections.array;

import collections.Array;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class CharArray extends Array<Character> {
    private final char[] array;

    public CharArray(char... array) {
        this.array = array;
    }

    @Override
    public Character get(int i) {
        return array[i];
    }

    @Override
    public Character set(int index, Character element) {
        Character res = array[index];
        array[index] = element;
        return res;
    }

    @Override
    public int size() {
        return array.length;
    }
}