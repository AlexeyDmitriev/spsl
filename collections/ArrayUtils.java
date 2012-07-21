package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class ArrayUtils {
    static public void sort(int[] array) {
        Collections.sort(new Array.IntArray(array));
    }

    static public void sort(double[] array) {
        Collections.sort(new Array.DoubleArray(array));
    }

    static public void sort(long[] array) {
        Collections.sort(new Array.LongArray(array));
    }

    static public void sort(char[] array) {
        Collections.sort(new Array.CharArray(array));
    }

    static public <T extends Comparable<? super T>> void sort(T[] array) {
        Arrays.sort(array);
    }

    static public void sort(int[] array, Comparator<Integer> comparator) {
        Collections.sort(new Array.IntArray(array), comparator);
    }

    static public void sort(double[] array, Comparator<Double> comparator) {
        Collections.sort(new Array.DoubleArray(array), comparator);
    }

    static public void sort(long[] array, Comparator<Long> comparator) {
        Collections.sort(new Array.LongArray(array), comparator);
    }

    static public void sort(char[] array, Comparator<Character> comparator) {
        Collections.sort(new Array.CharArray(array), comparator);
    }

    static public <T> void sort(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }
}
