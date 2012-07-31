package collections.array;

import collections.Array;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class DoubleArray extends Array<Double> {
    private final double[] array;

    public DoubleArray(double... array) {
        this.array = array;
    }

    @Override
    public Double get(int i) {
        return array[i];
    }

    @Override
    public Double set(int index, Double element) {
        Double res = array[index];
        array[index] = element;
        return res;
    }

    @Override
    public int size() {
        return array.length;
    }
}