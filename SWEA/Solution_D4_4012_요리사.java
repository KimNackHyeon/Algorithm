package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4012_¿ä¸®»ç {

	static int[][] food;
	static int[] A;
	static int[] B;
	static boolean[] check;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());

			food = new int[N][N];
			check = new boolean[N];

			for (int i = 0; i < N; i++) {
				int idx = 0;
				StringTokenizer st = new StringTokenizer(in.readLine());
				while (st.hasMoreTokens()) {
					food[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}
			
			A = new int[N / 2];
			B = new int[N / 2];
			min = Integer.MAX_VALUE;
			combi(N, N/2, 0, 0);
			System.out.println("#" + t + " " + min);

		}
	}

	private static void combi(int n, int r, int start, int count) {
		if (count == r) {
			int j = 0;
			for (int i = 0; i < check.length; i++) {
				if (check[i] == false) {
					B[j++] = i;
				}
			}
			
			int sum_A = 0;
			int sum_B = 0;
			
			for (int i = 0; i < A.length; i++) {
				for (int k = 0; k < A.length; k++) {
					sum_A += food[A[i]][A[k]];
					sum_B += food[B[i]][B[k]];
				}
			}

			min = Math.min(min, Math.abs(sum_A - sum_B));
			return;
		}

		for (int i = start; i < n; i++) {
			A[count] = i;
			check[i] = true;
			combi(n, r, i + 1, count + 1);
			check[i] = false;
		}
	}
}