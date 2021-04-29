package test;

public class PG_level3_2xn≈∏¿œ∏µ {
	public static void main(String[] args) {
		int n = 4;
		solution(n);
	}

	public static int solution(int n) {
		int[] dp = new int[60001];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
//        dp[4] = 5;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}

		return dp[4] % 1000000007;
	}
}
