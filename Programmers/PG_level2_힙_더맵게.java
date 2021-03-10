package test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PG_level2_힙_더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		solution(scoville, K);
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		// 스코빌 지수를 담을 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 우선순위 큐에 스코빌 지수 초기값들 넣기
		for (int i : scoville) {
			pq.add(i);
		}

		while (true) {
			int sum = 0;

			if (pq.peek() >= K) {
				return answer;
			}
			
			if (pq.size() <= 1) {
				return -1;
			}

			int sco1 = pq.poll(); // 가장 맵지 않음 음식의 스코빌 지수
			int sco2 = pq.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수

			sum = sco1 + (sco2 * 2); // 섞은 음식의 스코빌 지수

			answer++; // 섞은 횟수 증가
			pq.add(sum); // 섞은 스코빌 지수 우선순위 큐 삽입
//			System.out.println(pq);

		}
	}
}
