package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2630_색종이만들기 {

	static int N, blueCnt, whiteCnt;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine()); // 종이 한 변의 길이

		map = new int[N][N];
		visit = new boolean[N][N];
		// 색종이 입력 N x N
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int idx = 0;
			while (st.hasMoreTokens()) {
				map[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}
		for (int n = N; n >= 1; n /= 2) { // 색종이의 한 변 길이 - 8 4 2 1
			for (int y = 0; y < N; y += n) {
				for (int x = 0; x < N; x += n) {
					// System.out.println("n = " + n);
					Check(y, x, n);
				}
			}
		}
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}

	// 색종이를 잘라서 정사각형인지 체크
	private static void Check(int y, int x, int n) {
		int zeroCnt = 0;
		int oneCnt = 0;
		for (int i = y; i <= y + n - 1; i++) {
			for (int j = x; j <= x + n - 1; j++) {
				if (visit[i][j] == false && map[i][j] == 0) {
					zeroCnt++;
				}
				if (visit[i][j] == false && map[i][j] == 1) {
					oneCnt++;
				}
			}
		}
		if (oneCnt == n * n) {
			blueCnt++;
		} else if (zeroCnt == n * n) {
			whiteCnt++;
		} else
			return;
//		 System.out.println(y + " " + x + " ~ " + (y + n - 1) + " " + (x + n - 1));
		// 정사각형이라면 체크하기
		for (int i = y; i <= y + n - 1; i++) {
			for (int j = x; j <= x + n - 1; j++) {
				visit[i][j] = true;
			}
		}
	}

}
