package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1868_파핑파핑지뢰찾기 {

	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static boolean[][] visit;
	static int[][] mine;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());

			char[][] map = new char[N][N];
			mine = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				map[i] = input.toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];

						if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == '*') {
							mine[i][j] = 1;
							mine[ny][nx] = 9;
						}
					}
					if (mine[i][j] == 0 && map[i][j] == '.')
						visit[i][j] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!(visit[i][j] == true && mine[i][j] == 0))
						continue;
					for (int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];

						if (ny >= 0 && ny < N && nx >= 0 && nx < N && mine[ny][nx] != 0) {
							visit[ny][nx] = true;
						}
					}
					visit[i][j] = false;
				}
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == false && mine[i][j] == 0) {
						visit[i][j] = true;
						dfs(N, i, j);
						cnt++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == false && map[i][j] == '.') {
						cnt++;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}

	}

	private static void dfs(int n, int y, int x) {
		for (int d = 0; d < dx.length; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && ny < n && nx >= 0 && nx < n && mine[ny][nx] == 0 && visit[ny][nx] == false) {
				visit[ny][nx] = true;
				dfs(n, ny, nx);
			}
		}
	}
}
