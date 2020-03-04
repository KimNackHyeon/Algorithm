package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_16236_�Ʊ��� {

	static int answer, N, shark, min, eat, my, mx;
	static int[][] map;
	static int[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		check = new int[N][N];

		int start_y = 0;
		int start_x = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int idx = 0;
			while (st.hasMoreTokens()) {
				map[i][idx] = Integer.parseInt(st.nextToken());
				if (map[i][idx] == 9) {
					start_y = i;
					start_x = idx;
				}
				idx++;
			}
		}

		shark = 2; // ����� ���� ũ��
		eat = 0; // �� ���� ����� �ʱⰪ
		boolean flag = true;
		while (flag) {
			flag = false;
			min = Integer.MAX_VALUE;
			my = Integer.MAX_VALUE;
			mx = Integer.MAX_VALUE;
			eat2(start_y, start_x, 1);
			if (min != Integer.MAX_VALUE) { // ���� �� �ִ� ����Ⱑ ������
				flag = true;
				answer += check[my][mx] - 1; // �̵� �Ÿ� ���
				map[start_y][start_x] = 0; // ���� �Ŀ� ��ġ �ٲ��ֱ�
				map[my][mx] = 9;
				start_y = my;
				start_x = mx;
				eat++; // �԰�
				if (eat == shark) { // ���� ����Ⱑ �ڽ��� ũ��� ���ٸ�
					eat = 0;
					shark++; // ũ�� ����
				}
//				for (int a = 0; a < N; a++) {
//					for (int b = 0; b < N; b++) {
//						System.out.print(map[a][b] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("----------------------");
				check = new int[N][N]; // check2 �迭 �ʱ�ȭ
			}
		}
		System.out.println(answer);

	}

	private static void eat2(int sy, int sx, int count) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sy, sx, count });
		check[sy][sx] = count;
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int cnt = q.peek()[2];
			q.poll();
			check[y][x] = cnt;

			cnt++;
			for (int i = 0; i < N; i++) {
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (!(ny >= 0 && nx >= 0 && ny < N && nx < N)) {
						continue;
					}
					if (map[ny][nx] <= shark && check[ny][nx] == 0) {
						check[ny][nx] = cnt;
						if (map[ny][nx] < shark && map[ny][nx] != 0) {
							if (check[ny][nx] < min) { // �Ÿ��� ���� ����� �� ã��
								my = ny;
								mx = nx;
								min = check[ny][nx];
							} else if (check[ny][nx] == min) { // �Ÿ��� ����� ���� ����������
								if (my > ny) { // ���� ���ʿ� �ִ� ��
									my = ny;
									mx = nx;
								} else if (my == ny) { // ���� ���ʿ� �ִ� �͵� ��
									if (mx > nx) { // ���� ���ʿ� �ִ� ��
										my = ny;
										mx = nx;
									}
								}
							}
						}
						q.add(new int[] { ny, nx, cnt });
					}
				}
			}
		}
	}
}
