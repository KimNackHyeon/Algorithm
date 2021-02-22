package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15989_123¥ı«œ±‚4 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int[][] dp = new int[10001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i < dp.length; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][2] + dp[i - 2][1];
			dp[i][3] = dp[i - 3][3] + dp[i - 3][2] + dp[i - 3][1];
		}
//		System.out.println("   0  1  2  3");
//		for (int i = 1; i < 11; i++) {
//			System.out.println(i + " " + Arrays.toString(dp[i]));
//		}

		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += dp[num][j];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());

	}
}
