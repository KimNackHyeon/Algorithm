package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(in.readLine());

		int[][] fibo = new int[41][3];
		fibo[0][0] = 0;
		fibo[0][1] = 1; // 0 이 들어간 거
		fibo[0][2] = 0; // 1이 들어간거
		fibo[1][0] = 1;
		fibo[1][1] = 0;
		fibo[1][2] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i][0] = fibo[i - 2][0] + fibo[i - 1][0];
			fibo[i][1] = fibo[i - 2][1] + fibo[i - 1][1];
			fibo[i][2] = fibo[i - 2][2] + fibo[i - 1][2];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(in.readLine());
			sb.append(fibo[N][1]).append(" ").append(fibo[N][2]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
