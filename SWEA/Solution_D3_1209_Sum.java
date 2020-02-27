package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum {

	static int[] dx = { 1, 0, 1, -1 }; // 좌 하 대각선우 대각선좌
	static int[] dy = { 0, 1, 1, 1 }; // 좌 하 대각선우 대각선좌

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Solution1209.txt")));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			int t = Integer.parseInt(in.readLine());
			int[][] nums = new int[100][100];

			for (int j = 0; j < 100; j++) {
				String input = in.readLine();
				StringTokenizer st = new StringTokenizer(input);
				int idx = 0;
				while (st.hasMoreTokens()) {
					nums[j][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			int max = Integer.MIN_VALUE;

			// 왼쪽으로만 더하기
			for (int k = 0; k < 100; k++) {
				int sum = 0;
				for (int m = 0; m < 100; m++) {
					sum += nums[k][m];
				}
				max = Math.max(max, sum);
			}

			// 아래로만 더하기
			for (int k = 0; k < 100; k++) {
				int sum = 0;
				for (int m = 0; m < 100; m++) {
					sum += nums[m][k];
				}
				max = Math.max(max, sum);
			}
			// 대각선 더하기
			int x = 0, y = 0;
			int sum = 0;
			
			while (y + dy[2] < 100 && x + dx[2] < 100) {
				y += dy[2];
				x += dx[2];
				sum += nums[y][x];
			}
			max = Math.max(max, sum);
			// 대각선 더하기
			x = 0;
			y = 0;
			sum = 0;
			while (y + dy[3] < 100 && x + dx[3] > 0) {
				y += dy[3];
				x += dx[3];
				sum += nums[y][x];
			}
			max = Math.max(max, sum);
			
			System.out.println("#" + t + " " + max);
		}
	}
}
