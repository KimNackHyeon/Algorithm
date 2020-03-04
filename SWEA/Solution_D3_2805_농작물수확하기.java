package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Solution2805.txt")));

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int Answer = 0;
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < input.length(); j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}

			int start = N / 2;
			int end = N / 2;
			boolean check = false;

			for (int k = 0; k < N; k++) {
				for (int i = start; i <= end; i++) {
					Answer += map[k][i];
				}
				if (check == false) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
				if (start == 0 && end == N - 1) {
					check = true;
				}
			}
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
