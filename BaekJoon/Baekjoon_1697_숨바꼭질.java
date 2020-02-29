package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1697_¼û¹Ù²ÀÁú {

	static int K, N, min;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		min = Math.abs(K - N);
		check = new boolean[200003];
		if (N <= K) {
			go2(N);
		}
		System.out.println(min);
	}

	private static void go2(int n) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { n, 0 });
		check[n] = true;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int count = q.peek()[1];
			q.poll();

			if (count > min) {
				break;
			}
			if (x == K) {
				min = Math.min(min, count);
			}
			int[] dx = { x + 1, x - 1, 2 * x };
			count++;
			for (int d = 0; d < dx.length; d++) {
				int nx = dx[d];
				if (0 <= nx && nx <= 200002 && check[nx] == false) {
					q.add(new int[] { nx, count });
					check[nx] = true;
				}
			}
		}

	}
}
