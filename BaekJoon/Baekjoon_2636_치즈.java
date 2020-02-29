package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2636_ġ�� {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] cheese = new int[N][M];
		boolean[][] check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			int idx = 0;
			while (st2.hasMoreTokens()) {
				cheese[i][idx++] = Integer.parseInt(st2.nextToken());
			}
		}

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<>();
		int air = 0;
		int hour = 0;
		int cheeseCnt = 0;
		while (air < N * M) {
			hour++;
			q.add(new int[] { 0, 0 });
			air = 0;
			// ġ�� �ֺ��� ���� Ž��
			while (!q.isEmpty()) {
				int y = q.peek()[0];
				int x = q.peek()[1];
				q.poll();
				// check[y][x] = true;
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					// ���⸦ ã�Ƽ� 2�� �ٲ��ش�
					if (ny >= 0 && ny < N && nx >= 0 && nx < M && cheese[ny][nx] != 1 && check[ny][nx] == false) {
						cheese[ny][nx] = 2;
						check[ny][nx] = true;
						air++;
						q.add(new int[] { ny, nx });
					}
				}
			}
			if(air == N *M) {
				break;
			}

			// ���⸦ ������ �κ��� 0���� �ٲ㼭 ���� ���� ǥ��
			cheeseCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == 1) { // ġ� ������
						cheeseCnt++;
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];
							// ����� �����ٸ�
							if (ny >= 0 && ny < N && nx >= 0 && nx < M && cheese[ny][nx] == 2) {
								cheese[i][j] = 0; // ���̰�
								break; // ���� �κ� üũ
							}
						}
					}
				}
			}
			check = new boolean[N][M];
			q.clear();
		}
		System.out.println(hour - 1);
		System.out.println(cheeseCnt);
	}
}
