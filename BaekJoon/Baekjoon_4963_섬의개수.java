package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_4963_¼¶ÀÇ°³¼ö {

	static int[][] map;
	static int H, W;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) {
				break;
			}

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 1;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						cnt++;
						go(i, j, cnt);
					}
				}
			}
			System.out.println(cnt-1);
		}
	}


	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

	private static void go(int y, int x, int cnt) {
		map[y][x] =cnt;

		for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == 1) {
				map[ny][nx] = cnt;
				go(ny,nx,cnt);
			}
		}

	}
	
}
