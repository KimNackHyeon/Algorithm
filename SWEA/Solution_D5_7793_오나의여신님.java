package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_7793_오나의여신님 {

	static int N, M, answer;
	static char[][] map; // 지도가 저장될 배열
	static int[][] visit; // 이동횟수가 저장될 배열
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visit = new int[N][M];
			int sy = 0; // 시작 지점
			int sx = 0;
			int ey = 0; // 도착 지점
			int ex = 0;

			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < input.length(); j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'S') {
						sy = i;
						sx = j;
					}
					if (map[i][j] == 'D') {
						ey = i;
						ex = j;
					}
				}
			}

			bfs(sy, sx, ey, ex);
			if (visit[ey][ex] != 0) {
				System.out.println("#" + t + " " + visit[ey][ex]);
			} else
				System.out.println("#" + t + " GAME OVER");
		}
	}

	private static boolean check(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < M) {
			return true;
		}
		return false;
	}

	private static void bfs(int sy, int sx, int ey, int ex) {
		Queue<int[]> q = new LinkedList<>();

		// 악마의 위치를 찾아서 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*') {
					q.add(new int[] { i, j });
				}
			}
		}
		q.add(new int[] { sy, sx, 0 }); // 시작점의 위치를 큐에 넣기

		while (!q.isEmpty()) {
			if (q.peek().length == 2) { // 악마면
				int y = q.peek()[0];
				int x = q.peek()[1];
				q.poll();

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (check(ny, nx) && (map[ny][nx] == '.' || map[ny][nx] == 'S')) {
						map[ny][nx] = '*'; // 악마를 지도에 표시
						q.add(new int[] { ny, nx });
					}

				}
			} else if (q.peek().length == 3) { // 사람이면
				int y = q.peek()[0];
				int x = q.peek()[1];
				int cnt = q.peek()[2];
				q.poll();

				cnt++;
				if (y == ey && x == ex) { // 도착지점에 오면 종료
					break;
				}

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (check(ny, nx) && (map[ny][nx] == '.' || map[ny][nx] == 'D')) { // 악마가 아닌 위치면 이동
						if (visit[ny][nx] == 0) {
							visit[ny][nx] = cnt;
							q.add(new int[] { ny, nx, cnt });
						}
					}

				}
			}
		}
	}

}
