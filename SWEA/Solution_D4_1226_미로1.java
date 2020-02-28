package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1226_¹Ì·Î1 {

	static Queue<int[]> q;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int Answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(in.readLine());
			int[][] miro = new int[16][16];
			boolean[][] check = new boolean[16][16];

			int start_y = 0;
			int start_x = 0;

			int end_y = 0;
			int end_x = 0;

			for (int i = 0; i < 16; i++) {
				String input = in.readLine();
				for (int j = 0; j < input.length(); j++) {
					miro[i][j] = Integer.parseInt(input.charAt(j) + "");
					if (miro[i][j] == 2) {
						start_y = i;
						start_x = j;
					}
					if (miro[i][j] == 3) {
						end_y = i;
						end_x = j;
					}
				}
			}
			q = new LinkedList<>();
			q.add(new int[] { start_y, start_x });
			bfs(end_y, end_x, miro, check);
			System.out.println("#" + T + " " + Answer);
		}
	}

	private static void bfs(int end_y, int end_x, int[][] miro, boolean[][] check) {
		Answer = 0;
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny >= 0 && ny < 16 && nx >= 0 && nx < 16 && miro[ny][nx] == 0 && check[ny][nx] == false) {
					check[ny][nx] = true;
					q.add(new int[] { ny, nx });
				}
				if (ny == end_y && nx == end_x) {
					Answer = 1;
				}
			}
		}
	}
}
