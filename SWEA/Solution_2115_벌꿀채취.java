package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_¹ú²ÜÃ¤Ãë {

	static int answer, C, M, max1, max2;
	static int[][] honey;
	static int[] honey2;
	static boolean[] check;
	static int[] re;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey2 = new int[N * N];
			check = new boolean[N * N];

			int idx = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				while (st.hasMoreTokens()) {
					honey2[idx++] = Integer.parseInt(st.nextToken());
				}
			}
			re = new int[M * 2];
			answer = 0;
			select(N, M * 2, 0, 0);
			System.out.println("#" + t + " " + answer);
		}

	}

	private static void select(int n, int m, int start, int count) {
		if (count == m) {
			sum(re);
			return;
		}
		for (int i = start; i < n * n; i++) {
			if ((i % n <= n - M) && check[i] == false) {
				for (int j = 0; j < M; j++) {
					re[count + j] = honey2[i + j];
					check[i + j] = true;
				}
				select(n, m, i + M, count + M);
				for (int j = 0; j < M; j++) {
					re[count + j] = honey2[i + j];
					check[i + j] = false;
				}
			}

		}
	}

	private static void sum(int[] re2) {
		int sum1 = 0;
		int sum2 = 0;
		max1 = Integer.MIN_VALUE;
		max2 = Integer.MIN_VALUE;
		for (int i = 0; i < 1 << M; i++) {
			sum1 = 0;
			sum2 = 0;
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) != 0) {
					sum1 += re2[j];
					sum2 += re2[j] * re2[j];
				}
			}
			if (sum1 <= C) {
				max1 = Math.max(max1, sum2);
			}
			sum1 = 0;
			sum2 = 0;
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) != 0) {
					sum1 += re2[j + M];
					sum2 += re2[j + M] * re2[j + M];
				}
			}
			if (sum1 <= C) {
				max2 = Math.max(max2, sum2);
			}
			answer = Math.max(answer, max1 + max2);
		}

	}

}
