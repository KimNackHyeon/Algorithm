package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {

	static int N;
	static double answer;
	static double E;
	static long[][] map;
	static long[][] graph; // 가중치 그래프

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());

			map = new long[N][2];
			StringTokenizer xLine = new StringTokenizer(in.readLine());
			StringTokenizer yLine = new StringTokenizer(in.readLine());

			for (int i = 0; i < N; i++) {
				map[i] = new long[] { Long.parseLong(xLine.nextToken()), Long.parseLong(yLine.nextToken()) };
			}

			E = Double.parseDouble(in.readLine());

			// 가중치 그래프
			graph = new long[N][N];
			long[] from, to;
			for (int r = 0; r < N; r++) {
				from = map[r];
				for (int c = r + 1; c < N; c++) {
					to = map[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0] - to[0])
							+ (from[1] - to[1]) * (from[1] - to[1]);
				}
			}

			answer = prim(0) * E;

			System.out.println("#" + t + " " + Math.round(answer));
		}
	}

	private static double prim(int start) {
		long cost = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(); // MST에 들어가지 않은 정점들
		Edge[] dynamicGraph = new Edge[N]; // 모든 정점 관리

		for (int n = 0; n < dynamicGraph.length; n++) {
			dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
			if (n == start) {
				dynamicGraph[n].cost = 0;
			}
			pq.add(dynamicGraph[n]);
		}

		while (!pq.isEmpty()) {
			Edge front = pq.poll();
			cost += front.cost;

			for (int i = 0; i < dynamicGraph.length; i++) {
				Edge child = dynamicGraph[i];
				if (pq.contains(child)) {
					long tempCost = graph[front.idx][child.idx];
					if (tempCost < child.cost) {
						child.cost = tempCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		return cost;
	}

	static class Edge implements Comparable<Edge> {
		int idx;
		long cost;

		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}

	}

}
