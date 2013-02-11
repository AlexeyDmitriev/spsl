package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class Reader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public Reader(BufferedReader reader) {
        this.reader = reader;
    }

    public Reader(InputStream stream) {
        this(new BufferedReader(new InputStreamReader(stream)));
    }

    public String nextString() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public double nextDouble() {
        return Double.parseDouble(nextString());
    }

    public long nextLong() {
        return Long.parseLong(nextString());
    }

    public String next() {
        return nextString();
    }

    public String nextLine() {
        tokenizer = null;
        return readLine();
    }

    public int[] nextIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = nextInt();
        }
        return array;
    }

    public void nextIntArrays(int[]... arrays) {
        for (int i = 1; i < arrays.length; ++i) {
            if (arrays[i].length != arrays[0].length) {
                throw new InputMismatchException("Lengths are different");
            }
        }
        for (int i = 0; i < arrays[0].length; ++i) {
            for (int[] array : arrays) {
                array[i] = nextInt();
            }
        }
    }

    public void nextLongArrays(long[]... arrays) {
        for (int i = 1; i < arrays.length; ++i) {
            if (arrays[i].length != arrays[0].length) {
                throw new InputMismatchException("Lengths are different");
            }
        }
        for (int i = 0; i < arrays[0].length; ++i) {
            for (long[] array : arrays) {
                array[i] = nextLong();
            }
        }
    }

    public long[] nextLongArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; ++i) {
            array[i] = nextLong();
        }
        return array;
    }

    public String[] nextStringArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; ++i) {
            array[i] = nextString();
        }
        return array;
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
