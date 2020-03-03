package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7208_ÁöµµÄ¥ÇÏ±â {

	static int answer, N;
	static int[] world;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());

			world = new int[N];

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				world[i] = Integer.parseInt(st.nextToken());
			}

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			check(0, 0);

			System.out.println("#" + t + " " + answer);
		}

	}

	static void check(int idx, int count) {
		if (idx == N) {
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && world[i] == world[j]) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				answer = Math.min(answer, count);
			}
			return;
		}

		int temp;
		for (int color = 1; color < 5; color++) {
			if (world[idx] == color) {
				check(idx + 1, count);
			} else {
				temp = world[idx];
				world[idx] = color;
				check(idx + 1, count + 1);
				world[idx] = temp;
			}

		}

	}
}
