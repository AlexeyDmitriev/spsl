package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class Reader {
    BufferedReader br;
    StringTokenizer tokenizer;

    public Reader(BufferedReader br) {
        this.br = br;
    }

    public String nextString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(br.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextString());
    }
}
