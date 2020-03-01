package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_¼ö¿µÀå {

	static int answer;
	static int[] money;
	static int[] plan;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			money = new int[3];
			money[0] = Integer.parseInt(st.nextToken());
			money[1] = Integer.parseInt(st.nextToken());
			money[2] = Integer.parseInt(st.nextToken());
			answer = Integer.parseInt(st.nextToken());

			plan = new int[12];
			st = new StringTokenizer(in.readLine());

			for (int i = 0; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			sum(0, 0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void sum(int mon, int s) {
		if (mon >= 12) {
			answer = Math.min(answer, s);
			return;
		}
		sum(mon + 1, s + plan[mon] * money[0]);
		sum(mon + 1, s + money[1]);
		sum(mon + 3, s + money[2]);
	}
}
