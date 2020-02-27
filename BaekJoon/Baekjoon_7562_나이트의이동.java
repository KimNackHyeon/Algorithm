package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_7562_나이트의이동 {

	static class YX {
		int y;
		int x;
		int cnt;

		YX(int y, int x,int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static boolean[][] visit;
	static Queue<YX> q;
	static int I, cnt, end_x, end_y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			I = sc.nextInt();

			int start_y = sc.nextInt();
			int start_x = sc.nextInt();

			end_y = sc.nextInt();
			end_x = sc.nextInt();
			
			visit = new boolean[I][I];
			q = new LinkedList<>();
			move(start_y, start_x);
		}
		

	}

	public static void move(int y, int x) {
		if (end_x == x && end_y == y) {
			System.out.println(0);
			return;
		}
		cnt = 0;
		visit[y][x] = true;
		q.offer(new YX(y, x, cnt));

		while (!q.isEmpty()) {
			YX temp = q.poll();
			y = temp.y;
			x = temp.x;
			cnt = temp.cnt;
			cnt++;
			for (int d = 0; d < dx.length; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny >= 0 && ny < I && nx >= 0 && nx < I && visit[ny][nx] == false) {
					visit[ny][nx] = true;
					q.offer(new YX(ny, nx, cnt));
				}
			}

			if (end_x == x && end_y == y) {
				System.out.println(cnt-1);
			}
		}
	}
}
