package test;

public class PG_level2_¿¬½À¹®Á¦_¶¥µû¸Ô±â {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		solution(land);
	}

	static int solution(int[][] land) {
		int answer = 0;
		int N = land.length;
		int[][] dp = new int[N][4];

		dp[0][0] = land[0][0];
		dp[0][1] = land[0][1];
		dp[0][2] = land[0][2];
		dp[0][3] = land[0][3];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < 4; d++) {
					if(j == d) continue;
					dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][d]);
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, dp[N-1][i]);
		}
		return answer;
	}

}
