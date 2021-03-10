package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG_level3_힙_디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
//		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 }, { 4, 3 } };
		solution(jobs);
	}

	public static int solution(int[][] jobs) {
		int answer = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		int time = 0;
		int sum = 0;
		int index = 0;
		while (index < jobs.length || !pq.isEmpty()) {

			while (index < jobs.length && jobs[index][0] <= time) {
				pq.add(jobs[index++]);
			}

			if (pq.isEmpty()) {
				time = jobs[index][0];
			} else {
				int[] now = pq.poll();
				sum += time + now[1] - now[0];
				time += now[1];
			}
		}
		answer = sum / jobs.length;
		System.out.println(answer);
		return answer;
	}
}
