package test;

import java.util.Arrays;

public class PG_level3_DP_µî±·±æ {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 }, { 1, 2 } };
		solution(m, n, puddles);
	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;

		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		int mod = 1000000007;

		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = 1;
		}

		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0)
					continue;
				if (map[i][j] == 1)
					continue;
				if (i == 0 && dp[i][j - 1] != 0) {
					dp[i][j] = 1;
				}
				if (j == 0 && dp[i - 1][j] != 0) {
					dp[i][j] = 1;
				}
			}
		}

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < m; x++) {
				if (map[y][x] == 1)
					continue;
				dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % mod;
			}
		}

		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

		System.out.println();
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		answer = dp[n - 1][m - 1];
		System.out.println(answer);

		return answer;
	}
}
