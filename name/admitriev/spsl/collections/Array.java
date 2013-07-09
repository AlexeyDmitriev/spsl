package name.admitriev.spsl.collections;

import java.util.AbstractList;
import java.util.RandomAccess;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public abstract class Array<T> extends AbstractList<T> implements RandomAccess {
    public static class IntArray extends Array<Integer> {
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

    public static class DoubleArray extends Array<Double> {
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

    public static class LongArray extends Array<Long> {
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

    public static class CharArray extends Array<Character> {
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

    public static class BoolArray extends Array<Boolean> {
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

    public static class ObjectArray<T> extends Array<T> {
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
}


