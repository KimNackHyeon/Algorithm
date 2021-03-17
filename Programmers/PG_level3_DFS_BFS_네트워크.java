package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PG_level3_DFS_BFS_네트워크 {
	public static void main(String[] args) {
//		int n = 3;
//		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int n = 4;
		int[][] computers = { { 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 0, 0, 1 } };

		solution(n, computers);
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		int size = computers.length;
		boolean[] visit = new boolean[size];
		for (int num = 0; num < size; num++) {
			if (!visit[num]) {
				System.out.println(num);
				answer++;
				bfs(num, visit, computers);
			}
		}

		System.out.println(answer);

		return answer;
	}

	private static void bfs(int start, boolean[] visit, int[][] computers) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		visit[start] = true;
		while (!q.isEmpty()) {
			int num = q.poll();

			for (int i = 0; i < computers[num].length; i++) {
				if (computers[num][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
