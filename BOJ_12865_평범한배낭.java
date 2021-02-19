package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 물품의 수
		int K = sc.nextInt(); // 버틸 수 있는 무게

		int[] weight = new int[N]; // 물품의 무게
		int[] value = new int[N]; // 물품의 가중치
		int[][] dp = new int[N + 1][K+1];

		for (int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

//		System.out.println(Arrays.toString(weight));
//		System.out.println(Arrays.toString(value));

		for (int i = 0; i < N + 1; i++) {
			for (int w = 0; w < K+1; w++) {
				if (i == 0 || w == 0) {
					dp[i][w] = 0;
				}else if(weight[i-1] <= w) {
					dp[i][w] = Math.max(value[i-1]+dp[i-1][w-weight[i-1]],dp[i-1][w]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}

//		for (int i = 0; i < N + 1; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(dp[N][K]);

	}
}
