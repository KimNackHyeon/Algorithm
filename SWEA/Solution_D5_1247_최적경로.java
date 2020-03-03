package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

	static int N, min;
	static int[][] xy;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());

			xy = new int[N + 2][2];

			StringTokenizer st = new StringTokenizer(in.readLine());
			xy[0][0] = Integer.parseInt(st.nextToken()); // 시작점
			xy[0][1] = Integer.parseInt(st.nextToken());
			xy[N+1][0] = Integer.parseInt(st.nextToken()); // 도착점
			xy[N+1][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i < N+1; i++) {
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
			}
			check = new boolean[N + 2];
			check[0] = true;
			min = Integer.MAX_VALUE;
			go(0, 0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void go(int start, int count, int sum) {
		if (sum >= min) {
			return;
		}

		if (count == N) {
			sum += Math.abs(xy[start][0] - xy[count + 1][0]) + Math.abs(xy[start][1] - xy[count + 1][1]);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (check[i] == false) {
				check[i] = true;
				go(i, count + 1, sum + Math.abs(xy[start][0] - xy[i][0]) + Math.abs(xy[start][1] - xy[i][1]));
				check[i] = false;
			}
		}
	}
}
