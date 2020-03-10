package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_�������� {

	static int N, W, H, min;
	static int[][] map;
	static int[] ball;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken()); // ������ ���� ����
			W = Integer.parseInt(st.nextToken()); // �迭�� ���� ũ��
			H = Integer.parseInt(st.nextToken()); // �迭�� ���� ũ��

			map = new int[H][W]; // ������ ������ �迭

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				int idx = 0;
				while (st.hasMoreTokens()) {
					map[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			ball = new int[N]; // ������ ������ ��ġ�� ������ �迭

			min = Integer.MAX_VALUE;
			selPos(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void selPos(int start, int count) { // ������ ������ ��ġ�� ���ϴ� ��Ž
		if (min == 0) { // �ּڰ��� 0�̸� ����
			return;
		}
		if (count == N) { // ���� ������ N�� ���ٸ�
			// �迭 ����
			int[][] tmap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					tmap[i][j] = map[i][j];
				}
			}

			// ������ �迭�� �̿��Ͽ�
			for (int i = 0; i < N; i++) {
				for (int y = 0; y < H; y++) {
					if (tmap[y][ball[i]] != 0) {
						drop(y, ball[i], tmap); // ������ ����߸���
						down(tmap); // ������ ������
						break;
					}
				}
			}

			// ������ ����߸��� �� ���� ������ �� ���
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

	private static void down(int[][] tmap) { // ������ ������ �Լ�
		int[] re = new int[H]; // ������ �ӽ÷� ������ �迭
		for (int x = 0; x < W; x++) {
			int idx = 0;
			for (int y = H - 1; y >= 0; y--) {
				if (tmap[y][x] != 0) { // ������ �� ������ ������ �������� �迭�� ����
					re[idx++] = tmap[y][x];
				}
			}

			for (int i = 0; i < H; i++) { // �ؿ������� �ϳ��� ä���.
				tmap[H - i - 1][x] = re[i];
			}
			Arrays.fill(re, 0); // �迭 �ʱ�ȭ
		}

	}

	private static boolean check(int y, int x) {
		return y >= 0 && x >= 0 && y < H && x < W;
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void drop(int y, int x, int[][] tmap) { // ������ ����߸��� �Լ�
		int sy = y; // ������
		int sx = x;

		int cnt = tmap[sy][sx]; // ������ ������ ���� ����
		tmap[sy][sx] = 0; // �ϴ� ������ ���� �μ���

		for (int i = 1; i < cnt; i++) { // ������ ���� ���ڸ�ŭ �����¿�� �μ���.
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
