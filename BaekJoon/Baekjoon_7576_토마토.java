package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7576_토마토 {

	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	static Queue<YX> q;
	static int M, N, Answer;
	static int[][] tomato; // 토마토 창고에 대한 2차원 배열

	static class YX {
		int y;
		int x;
		int cnt;

		YX(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 토마토 창고 세로 크기
		M = Integer.parseInt(st.nextToken()); // 토마토 창고 가로 크기

		tomato = new int[M][N];
		int start_y = 0; // 토마토의 위치
		int start_x = 0; 

		q = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			int idx = 0;
			while (st2.hasMoreTokens()) {
				tomato[i][idx++] = Integer.parseInt(st2.nextToken());
				if (tomato[i][idx - 1] == 1) { // 토마토가 있는 곳은
					start_y = i;
					start_x = idx - 1;
					q.offer(new YX(start_y, start_x, 0)); // 바로 큐에 넣고
				}
			}
		}

		bfs();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (tomato[i][j] == 0)  // 토마토 창고에 아직 익지 않는 것이 있다면
					Answer = -1; // -1 을 출력
			}
		}

		System.out.println(Answer);

	}

	public static void bfs() {

		while (!q.isEmpty()) {
				YX temp = q.poll();
				int y = temp.y;
				int x = temp.x;
				int cnt = temp.cnt;
				cnt++;
				for (int d = 0; d < dx.length; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];

					if (ny >= 0 && ny < M && nx >= 0 && nx < N && tomato[ny][nx] == 0) {
						tomato[ny][nx] = 1;
						q.offer(new YX(ny, nx, cnt));
					}
				}
				Answer = cnt-1;
		}
	}
}
