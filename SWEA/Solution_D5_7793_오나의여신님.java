package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D5_7793_�����ǿ��Ŵ� {

	static int N, M, answer;
	static char[][] map; // ������ ����� �迭
	static int[][] visit; // �̵�Ƚ���� ����� �迭
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
			int sy = 0; // ���� ����
			int sx = 0;
			int ey = 0; // ���� ����
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

		// �Ǹ��� ��ġ�� ã�Ƽ� ť�� �ֱ�
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*') {
					q.add(new int[] { i, j });
				}
			}
		}
		q.add(new int[] { sy, sx, 0 }); // �������� ��ġ�� ť�� �ֱ�

		while (!q.isEmpty()) {
			if (q.peek().length == 2) { // �Ǹ���
				int y = q.peek()[0];
				int x = q.peek()[1];
				q.poll();

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (check(ny, nx) && (map[ny][nx] == '.' || map[ny][nx] == 'S')) {
						map[ny][nx] = '*'; // �Ǹ��� ������ ǥ��
						q.add(new int[] { ny, nx });
					}

				}
			} else if (q.peek().length == 3) { // ����̸�
				int y = q.peek()[0];
				int x = q.peek()[1];
				int cnt = q.peek()[2];
				q.poll();

				cnt++;
				if (y == ey && x == ex) { // ���������� ���� ����
					break;
				}

				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (check(ny, nx) && (map[ny][nx] == '.' || map[ny][nx] == 'D')) { // �Ǹ��� �ƴ� ��ġ�� �̵�
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
