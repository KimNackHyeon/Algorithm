package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_9282_초콜릿과건포도 {

	static int answer;
	static int[][] choco;
	static int[][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			choco = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					choco[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			dp = new int[N + 1][M + 1][N + 1][M + 1];

			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < M + 1; j++) {
					for (int j2 = 0; j2 < N + 1; j2++) {
						for (int k = 0; k < M + 1; k++) {
							dp[i][j][j2][k] = Integer.MAX_VALUE;
						}
					}
				}
			}

			answer = slice(0, 0, N, M);

			System.out.println("#" + t + " " + answer);
		}

	}

	private static int slice(int y, int x, int n, int m) {

		if (n == 1 && m == 1) { // 한 칸 짜리면
			return 0;
		}

		if (dp[y][x][n][m] != Integer.MAX_VALUE) {
			return dp[y][x][n][m];
		}

		int grape = 0;
		// 짜르기 전 초콜릿에 담긴 건포도 수
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + m; j++) {
				grape += choco[i][j];
			}
		}

		// 가로로 잘랐을 때
		for (int i = 1; i < n; i++) {
			if (dp[y][x][i][m] == Integer.MAX_VALUE) {
				dp[y][x][i][m] = slice(y, x, i, m); // 가로로 잘랐을 때 위쪽 부분
			}
			if (dp[y + i][x][n - i][m] == Integer.MAX_VALUE) {
				dp[y + i][x][n - i][m] = slice(y + i, x, n - i, m); // 아래쪽 부분
			}
			dp[y][x][n][m] = Math.min(dp[y][x][n][m], grape + dp[y][x][i][m] + dp[y + i][x][n - i][m]);
		}

		// 세로로 잘랐을 때
		for (int i = 1; i < m; i++) {
			if (dp[y][x][n][i] == Integer.MAX_VALUE) {
				dp[y][x][n][i] = slice(y, x, n, i); // 세로로 잘랐을 때 왼쪽 부분
			}
			if (dp[y][x + i][n][m - i] == Integer.MAX_VALUE) {
				dp[y][x + i][n][m - i] = slice(y, i + x, n, m - i); // 오른쪽 부분
			}
			dp[y][x][n][m] = Math.min(dp[y][x][n][m], grape + dp[y][x][n][i] + dp[y][x + i][n][m - i]);
		}
		return dp[y][x][n][m];
	}
}
