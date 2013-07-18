package name.admitriev.spsl.numbers;

import java.math.BigInteger;

public class LongRational implements Comparable<LongRational> {
    public long numerator, denominator;

    public LongRational(long numerator, long denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException();
        long gcd = IntegerUtils.gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    public LongRational(long numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public LongRational add(LongRational r) {
        long y = denominator / (IntegerUtils.gcd(denominator, r.denominator)) * r.denominator ;
        long x = numerator * (y / denominator) + r.numerator * (y / r.denominator);
        return new LongRational(x, y);
    }

    public LongRational subtract(LongRational r) {
        return add(r.negate());
    }

    public LongRational multiply(LongRational r) {
        long y = denominator * r.denominator;
        long x = numerator * r.numerator;
        return new LongRational(x, y);
    }

    public LongRational revert() {
        return new LongRational(denominator, numerator);
    }

    public LongRational divide(LongRational r) {
        return multiply(r.revert());
    }

    public LongRational negate() {
        return new LongRational(-numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(LongRational other) {
        return compare(numerator * other.denominator, denominator * other.numerator);
    }

    private int compare(long a, long b) {
        return a < b ? -1 : (a > b ? 1 : 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LongRational that = (LongRational) o;

        if (denominator != that.denominator) return false;
        if (numerator != that.numerator) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    public long ceil() {
        long result = numerator / denominator;
        if(numerator % denominator != 0) {
            if(numerator > 0)
                ++result;
        }
        return result;
    }

    public long floor() {
        long result = numerator / denominator;
        if(numerator % denominator != 0) {
            if(numerator < 0)
                --result;
        }
        return result;
    }
}
