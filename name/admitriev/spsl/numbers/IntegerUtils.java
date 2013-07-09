package name.admitriev.spsl.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerUtils {

	public static long[][] binomials(int n, long mod){
		long[][] c = new long[n + 1][];
		for(int i = 0; i <= n; ++i){
			c[i] = new long[i + 1];
			c[i][0] = c[i][i] = 1;
			for(int j = 1; j < i; ++j){
				c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
				if(c[i][j] > mod)
					c[i][j] -= mod;
			}
		}
		return c;
	}

	public static int[] factorials(int n, int mod){
		int [] fact = new int[n + 1];
		fact[0] = 1;
		for(int i = 1; i <= n; ++i)
			fact[i] = (int) (fact[i - 1] * 1L * i % mod);
		return fact;
	}

	public static long min(long... longs){
		long min = Long.MAX_VALUE;
		for(long l: longs)
			min =  Math.min(min, l);
		return min;
	}

	public static long max(long... longs) {
		long max = Long.MIN_VALUE;
		for(long l: longs)
			max = Math.max(max, l);
		return max;
	}

	public static ArrayList<Integer> getDivisors(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i * i <= n;++i){
			if(n % i == 0){
				list.add(i);
				if(i * i != n)
					list.add(n / i);
			}
		}
		return list;
	}

	public static int min(int... ints){
		int min = Integer.MAX_VALUE;
		for(int i: ints)
			min =  Math.min(min, i);
		return min;
	}

	public static int max(int... ints){
		int max = Integer.MIN_VALUE;
		for(int i: ints)
			max =  Math.max(max, i);
		return max;
	}

	public static double min(double... doubles){
		double min = Double.MAX_VALUE;
		for(double d: doubles)
			min = Math.min(min, d);
		return min;
	}

	public static double max(double... doubles){
		double max = Double.MAX_VALUE;
		for(double d: doubles)
			max = Math.max(max, d);
		return max;
	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
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
		long result = 1 % mod;
		base %= mod;
		while (power > 0) {
			if (power % 2 == 1) {
				result *= base;
				result %= mod;
			}
			base *= base;
			base %= mod;
			power >>= 1;
		}
		return result;
	}

	public static long power(long base, long power) {
		long result = 1;
		while (power > 0) {
			if (power % 2 == 1)
				result *= base;
			base *= base;
			power >>= 1;
		}
		return result;

	}

	public static long modInverse(long number, long mod) {
		return power(number, mod - 2, mod);
	}

	public static boolean isPrime(long number) {
		for (int i = 2; i * i <= number; ++i) {
			if (number % i == 0) {
				return false;
			}
		}
		return number == 1 ? false : true;
	}

	public static boolean[] getPrimesMap(int to) {
		boolean[] result = new boolean[to + 1];
		Arrays.fill(result, true);
		result[0] = result[1] = false;
		for (int i = 2; i <= to; ++i) {
			if (result[i]) {
				if (i * 1L * i <= to) {
					for (int j = i * i; j <= to; j += i) {
						result[j] = false;
					}
				}
			}
		}
		return result;
	}

	public static List<Integer> getPrimes(int to) {
		List<Integer> result = new ArrayList<Integer>();
		boolean[] map = getPrimesMap(to);
		for (int i = 2; i <= to; ++i) {
			if (map[i]) {
				result.add(i);
			}
		}
		return result;
	}

	public static long getNextPrime(long n) {
		while (true) {
			++n;
			if (isPrime(n)) {
				return n;
			}
		}
	}
}
