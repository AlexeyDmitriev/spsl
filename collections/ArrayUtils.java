package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class ArrayUtils {
    public static void sort(int[] array) {
        Collections.sort(new Array.IntArray(array));
    }

    public static void sort(double[] array) {
        Collections.sort(new Array.DoubleArray(array));
    }

    public static void sort(long[] array) {
        Collections.sort(new Array.LongArray(array));
    }

    public static void sort(char[] array) {
        Collections.sort(new Array.CharArray(array));
    }

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        Arrays.sort(array);
    }

    public static void sort(int[] array, Comparator<Integer> comparator) {
        Collections.sort(new Array.IntArray(array), comparator);
    }

    public static void sort(double[] array, Comparator<Double> comparator) {
        Collections.sort(new Array.DoubleArray(array), comparator);
    }

    public static void sort(long[] array, Comparator<Long> comparator) {
        Collections.sort(new Array.LongArray(array), comparator);
    }

    public static void sort(char[] array, Comparator<Character> comparator) {
        Collections.sort(new Array.CharArray(array), comparator);
    }

    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }
}
