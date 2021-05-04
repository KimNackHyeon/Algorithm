package test;

import java.util.LinkedList;
import java.util.Queue;

public class PG_level2_찾프마_게임맵최단거리 {
	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		solution(maps);
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static int solution(int[][] maps) {
		int answer = 0;

		int N = maps.length;
		int M = maps[0].length;
		int[][] check = new int[N][M];

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, 1 });
		check[0][0] = 1;
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int cnt = q.peek()[2];

			q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (!(ny >= 0 && nx >= 0 && ny < N && nx < M && maps[ny][nx] == 1)) {
					continue;
				}
				if (check[ny][nx] == 0) {
					q.add(new int[] { ny, nx, cnt + 1 });
					check[ny][nx] = cnt + 1;
				}
			}

		}
		System.out.println(check[N - 1][M - 1]);
		answer = check[N - 1][M - 1];
		if (check[N - 1][M - 1] == 0) {
			answer = -1;
		}
		return answer;
	}
}
