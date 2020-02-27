package test;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1260_DFS¿ÍBFS {

	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			map[num1][num2] = 1;
			map[num2][num1] = 1;
		}
		
		visit = new boolean[N + 1];

		dfs(V);
		System.out.println();
		q = new LinkedList<>();
		visit = new boolean[N + 1];
		bfs(V);
	}

	public static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i < map.length; i++) {
			if (map[v][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		q.offer(v);
		while(!q.isEmpty()) {
			v = q.poll();
			for (int i = 1; i < map.length; i++) {
				if(map[v][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.offer(i);
					System.out.print(i + " ");
				}
			}
		}
	}
}
