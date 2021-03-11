package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PG_level3_힙_이중우선순위큐 {
	public static void main(String[] args) {
//		String[] op = { "I 16", "D 1" };
//		String[] op = { "I 7","I 5","I -5","D -1"};
		String[] op = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };

		System.out.println(Arrays.toString(solution(op)));
	}

	public static int[] solution(String[] operations) {
		int[] answer = new int[2];

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순
		PriorityQueue<Integer> pq_reverse = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

		for (int i = 0; i < operations.length; i++) {
			String[] split = operations[i].split(" ");

			String op = split[0];
			int num = Integer.parseInt(split[1]);

			switch (split[0]) {
			case "I": // 삽입
				pq.add(num);
				pq_reverse.add(num);
				break;

			case "D": // 삭제
				if (split[1].equals("-1")) { // 최솟값 삭제
					pq_reverse.remove(pq.poll());
				} else { // 최댓값 삭제
					pq.remove(pq_reverse.poll());
				}
				break;

			default:
				break;
			}
		}
		
		if (pq.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = pq_reverse.peek();
			answer[1] = pq.peek();
		}

		return answer;
	}
}
