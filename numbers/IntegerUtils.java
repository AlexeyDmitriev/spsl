package numbers;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class IntegerUtils {
    static public long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

    static public long power(long exponent, long power, long mod) {
        if (power == 0)
            return 1 % mod;
        if (power % 2 == 0)
            return power(exponent * exponent % mod, power >> 1, mod);
        return exponent * power(exponent, power - 1, mod) % mod;
    }

    static public long power(long exponent, long power) {
        if (power == 0)
            return 1;
        if (power % 2 == 0)
            return power(exponent * exponent, power >> 1);
        return exponent * power(exponent, power - 1);
    }

    static public long modInverse(long number, long mod) {
        return power(number, mod - 2, 2);
    }
}
