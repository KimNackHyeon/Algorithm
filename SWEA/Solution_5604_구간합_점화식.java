package test;

import java.util.HashMap;
import java.util.Scanner;

public class Solution_5604_구간합_점화식 {
	static int T;
	static long A, B, S;
	static HashMap<Long, Long> m = new HashMap<>();

	public static void main(String[] args) {
		for (int i = 1; i < 17; i++) {
			long v = pow10(0L + i);
			m.put((v - 1L), h(v - 1L));
		} // 9 99 999 9999
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			A = sc.nextLong();
			B = sc.nextLong();

			S = cal(B, A);
			System.out.println("#" + t + " " + S);
		}
	}

	private static long pow10(long n) {
		return (long) (Math.pow(10, n));
	}

	public static long cal(long b, long a) {
		if (a <= 1) {
			return f(b);
		} else if (a == b) {
			return f(b) - f(a - 1);
		} else {
			return f(b) - f(a - 1);
		}
	}

	private static long f(long n) {
		if (m.containsKey(n)) {
			return m.get(n);
		} else if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			m.put(n, f(n - 1L - n % v) + g(n));
			return m.get(n);
		}
	}

	private static long g(long n) {
		if (n <= 9) {
			return e(n);
		} else {
			long v = pow10(len(n));
			return (n / v) * (n % v + 1L) + f(n % v);
		}
	}

	private static Long h(long n) {
		long len = len(n) + 1L;
		return ((45L) * (len) * (1L + n)) / (10L);
	}

	private static long e(long n) {
		return n * (n + 1L) / 2L;
	}

	private static long len(long n) {
		return 0L + (n + "").length() - 1;
	}
}
