package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_16236_아기상어 {

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

		shark = 2; // 상어의 최초 크기
		eat = 0; // 상어가 먹은 물고기 초기값
		boolean flag = true;
		while (flag) {
			flag = false;
			min = Integer.MAX_VALUE;
			my = Integer.MAX_VALUE;
			mx = Integer.MAX_VALUE;
			eat2(start_y, start_x, 1);
			if (min != Integer.MAX_VALUE) { // 먹을 수 있는 물고기가 있으면
				flag = true;
				answer += check[my][mx] - 1; // 이동 거리 계산
				map[start_y][start_x] = 0; // 먹은 후에 위치 바꿔주기
				map[my][mx] = 9;
				start_y = my;
				start_x = mx;
				eat++; // 먹고
				if (eat == shark) { // 먹은 물고기가 자신의 크기와 같다면
					eat = 0;
					shark++; // 크기 증가
				}
//				for (int a = 0; a < N; a++) {
//					for (int b = 0; b < N; b++) {
//						System.out.print(map[a][b] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("----------------------");
				check = new int[N][N]; // check2 배열 초기화
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
							if (check[ny][nx] < min) { // 거리가 가장 가까운 것 찾기
								my = ny;
								mx = nx;
								min = check[ny][nx];
							} else if (check[ny][nx] == min) { // 거리가 가까운 것이 여러마리면
								if (my > ny) { // 가장 위쪽에 있는 것
									my = ny;
									mx = nx;
								} else if (my == ny) { // 가장 위쪽에 있는 것들 중
									if (mx > nx) { // 가장 왼쪽에 있는 것
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
