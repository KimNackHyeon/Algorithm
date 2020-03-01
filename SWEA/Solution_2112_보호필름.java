package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

	static int D, W, K, min;
	static int[] re;
	static int[] zeroOrone;
	static int[] num = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int[][] film = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					film[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			if (K == 1 || K == D) {
				System.out.println("#" + t + " " + 0);
			} else {
				for (int i = 0; i <= D; i++) {
					re = new int[i];
					zeroOrone = new int[i];
					checkFilm(i, 0, 0, film);
				}
				System.out.println("#" + t + " " + min);
			}

		}
	}

	private static void change(int r, int count, int start, int[][] film) {
//		if (min == 0) {
//			return;
//		}
		if (count > K) {
			return;
		}
		if (count == r) {
			int[][] temp = new int[D][W];
			if(min < r) {
				return;
			}
			// 필름을 씌울 배열복사
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					temp[i][j] = film[i][j];
				}
			}

			for (int i = 0; i < re.length; i++) {
				for (int j = 0; j < W; j++) {
					temp[re[i]][j] = zeroOrone[i];
				}
			}

			int ans = searchFilm(temp);
			if (ans < W) {
				return;
			}
			if (ans == W)
				min = Math.min(re.length, min);
			return;
		}

		for (int i = 0; i < 2; i++) {
			zeroOrone[count] = num[i];
			change(r, count + 1, i + 1, film);
		}
	}

	private static void checkFilm(int r, int count, int start, int[][] film) {
		if (count == r) {
			// System.out.println("re = " + Arrays.toString(re));
			change(r, 0, 0, film);
			if(min < r) {
				return;
			}
			return;
		}

		for (int i = start; i < D; i++) {
			re[count] = i;
			checkFilm(r, count + 1, i + 1, film);
		}
	}

	private static int searchFilm(int[][] film) {
		int count = 0;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < D - K + 1; j++) {
				String check_0 = "";
				String check_1 = "";
				String temp = "";
				for (int a = j; a < K + j; a++) {
					check_0 += "0";
					check_1 += "1";
					temp += film[a][i];
				}
				if (temp.equals(check_0) || temp.equals(check_1)) {
					count++;
					break;
				}
			}
		}
		return count;
	}
}
