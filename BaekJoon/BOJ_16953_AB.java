package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16953_AB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		long Bl = (long)B;

		Queue<long[]> q = new LinkedList<>();

		q.add(new long[] { A, 1 });

		while (!q.isEmpty()) {
			long n = q.peek()[0];
			long cnt = q.peek()[1];

//			System.out.println(n);
			q.poll();
			if (n == Bl) {
				System.out.println(cnt);
				return;
			}

			if (n * 2 <= B) {
				q.add(new long[] { n * 2, cnt + 1 });
			}
			if (n * 10 + 1 < Integer.MAX_VALUE && n * 10 + 1 <= B) {
				q.add(new long[] { n * 10 + 1, cnt + 1 });
			}
		}
		System.out.println(-1);

	}
}
