package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			move(d);
		}

	}

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	private static void move(int d) {
		int mx = x + dx[d];
		int my = y + dy[d];
		
		if (!(mx >= 0 && my >= 0 && mx < N && my < M)) {
			return;
		}
		
		int[] temp = dice.clone();
		
		if (d == 1) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
			
		} else if (d == 2) {
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if (d == 3) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else if (d == 4) {
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}

		if (map[mx][my] == 0) {
			map[mx][my] = dice[6];
		} else {
			dice[6] = map[mx][my];
			map[mx][my] = 0;
		}
		
		x += dx[d];
		y += dy[d];
		System.out.println(dice[1]);
	}


}
