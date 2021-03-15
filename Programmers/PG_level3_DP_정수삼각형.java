package test;

import java.util.Arrays;

public class PG_level3_DP_Á¤¼ö»ï°¢Çü {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		solution(triangle);
	}

	public static int solution(int[][] triangle) {
		int answer = 0;

		int[][] dp = new int[triangle.length][triangle.length];

		dp[0][0] = triangle[0][0];

		for (int i = 0; i < dp.length - 1; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
//				System.out.println("1. " + dp[i][j] + " " + triangle[i + 1][j]);
//				System.out.println("2. " + dp[i][j] + " " + triangle[i + 1][j+1]);
				dp[i + 1][j] = Math.max(dp[i + 1][j],dp[i][j] + triangle[i + 1][j]);
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1],dp[i][j] + triangle[i + 1][j + 1]);
				answer = Math.max(answer,Math.max(dp[i + 1][j], dp[i + 1][j + 1]));
			}
		}

		for (int[] is : dp) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println(answer);

		return answer;
	}
}
