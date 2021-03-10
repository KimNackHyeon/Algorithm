package test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PG_level2_��_���ʰ� {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		solution(scoville, K);
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		// ���ں� ������ ���� �켱���� ť
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// �켱���� ť�� ���ں� ���� �ʱⰪ�� �ֱ�
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

			int sco1 = pq.poll(); // ���� ���� ���� ������ ���ں� ����
			int sco2 = pq.poll(); // �� ��°�� ���� ���� ������ ���ں� ����

			sum = sco1 + (sco2 * 2); // ���� ������ ���ں� ����

			answer++; // ���� Ƚ�� ����
			pq.add(sum); // ���� ���ں� ���� �켱���� ť ����
//			System.out.println(pq);

		}
	}
}
