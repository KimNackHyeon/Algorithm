package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static int N, W, H, min;
	static int[][] map;
	static int[] ball;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken()); // 떨어질 구슬 개수
			W = Integer.parseInt(st.nextToken()); // 배열의 가로 크기
			H = Integer.parseInt(st.nextToken()); // 배열의 세로 크기

			map = new int[H][W]; // 벽돌을 저장할 배열

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			ball = new int[N]; // 떨어질 구슬의 위치를 저장할 배열

			min = Integer.MAX_VALUE;
			selPos(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void selPos(int start, int count) { // 구슬이 떨어질 위치를 정하는 완탐
		if (min == 0) { // 최솟값이 0이면 종료
			return;
		}
		if (count == N) { // 뽑은 개수가 N과 같다면
			// 배열 복사
			int[][] tmap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					tmap[i][j] = map[i][j];
				}
			}

			// 복사한 배열을 이용하여
			for (int i = 0; i < N; i++) {
				for (int y = 0; y < H; y++) {
					if (tmap[y][ball[i]] != 0) {
						drop(y, ball[i], tmap); // 구슬을 떨어뜨리고
						down(tmap); // 벽돌을 내린다
						break;
					}
				}
			}

			// 구슬을 떨어뜨리고 난 후의 벽돌의 수 계산
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (tmap[i][j] != 0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		for (int i = 0; i < W; i++) {
			ball[count] = i;
			selPos(i + 1, count + 1);
		}
	}

	private static void down(int[][] tmap) { // 벽돌을 내리는 함수
		int[] re = new int[H]; // 벽돌을 임시로 저장할 배열
		for (int x = 0; x < W; x++) {
			int idx = 0;
			for (int y = H - 1; y >= 0; y--) {
				if (tmap[y][x] != 0) { // 벽돌의 빈 공간을 제외한 나머지를 배열에 저장
					re[idx++] = tmap[y][x];
				}
			}

			for (int i = 0; i < H; i++) { // 밑에서부터 하나씩 채운다.
				tmap[H - i - 1][x] = re[i];
			}
			Arrays.fill(re, 0); // 배열 초기화
		}

	}

	private static boolean check(int y, int x) {
		return y >= 0 && x >= 0 && y < H && x < W;
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void drop(int y, int x, int[][] tmap) { // 구슬을 떨어뜨리는 함수
		int sy = y; // 시작점
		int sx = x;

		int cnt = tmap[sy][sx]; // 시작점 벽돌에 적힌 숫자
		tmap[sy][sx] = 0; // 일단 시작점 벽돌 부수고

		for (int i = 1; i < cnt; i++) { // 벽돌에 적힌 숫자만큼 상하좌우로 부순다.
			for (int d = 0; d < 4; d++) {
				int ny = sy + (dy[d] * i);
				int nx = sx + (dx[d] * i);

				if (check(ny, nx) && tmap[ny][nx] >= 0) {
					if (tmap[ny][nx] > 1) {
						drop(ny, nx, tmap);
					}
					tmap[ny][nx] = 0;

				}
			}
		}

	}
}
