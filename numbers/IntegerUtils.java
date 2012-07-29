package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class IntegerUtils {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

    public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return a / gcd * b;
    }

    public static long power(long base, long power, long mod) {
        if (power == 0)
            return 1 % mod;
        if (power % 2 == 0)
            return power(base * base % mod, power >> 1, mod);
        return base * power(base, power - 1, mod) % mod;
    }

    public static long power(long base, long power) {
        if (power == 0)
            return 1;
        if (power % 2 == 0)
            return power(base * base, power >> 1);
        return base * power(base, power - 1);
    }

    public static long modInverse(long number, long mod) {
        return power(number, mod - 2, 2);
    }

    public static boolean isPrime(long number) {
        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean[] getPrimesMap(int to) {
        boolean[] result = new boolean[to + 1];
        Arrays.fill(result, true);
        result[0] = result[1] = false;
        for (int i = 2; i <= to; ++i)
            if (result[i])
                if (i * 1L * i <= to)
                    for (int j = i * i; j <= to; j += i)
                        result[j] = false;
        return result;
    }

    public static List<Integer> getPrimes(int to) {
        List<Integer> result = new ArrayList<Integer>();
        boolean[] map = getPrimesMap(to);
        for (int i = 2; i <= to; ++i) {
            if (map[i])
                result.add(i);
        }
        return result;
    }

    public static long getNextPrime(long n) {
        while (true) {
            ++n;
            if (isPrime(n))
                return n;
        }
    }
}
