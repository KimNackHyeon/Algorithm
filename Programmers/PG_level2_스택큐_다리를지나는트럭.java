package test;

import java.util.LinkedList;
import java.util.Queue;

public class PG_level2_����ť_�ٸ���������Ʈ�� {
	public static void main(String[] args) {
//		int[] truck_weights = { 7, 4, 5, 6 };
//		int bridge_length = 2;
//		int weight = 10;

		int[] truck_weights = { 10 };
		int bridge_length = 100;
		int weight = 100;

		solution(bridge_length, weight, truck_weights);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;

		Queue<int[]> q = new LinkedList<>();

		int cnt = 0;
		int index = 0;
		int cWeight = 0; // ���� �ٸ����� Ʈ������ ����

		while (true) {
			if (!q.isEmpty()) {
				if (q.peek()[1] + bridge_length <= answer) { // Ʈ���� �ٸ��� �� �������ٸ�
					cWeight -= q.peek()[0];
//					System.out.println(q.peek()[0] + " Ʈ�� ���");
					cnt++;
					q.poll(); // ť���� Ʈ�� ����
				}
			}

			if (index < truck_weights.length) {
				if (cWeight + truck_weights[index] <= weight) {
//					System.out.println(truck_weights[index] + " Ʈ�� ����");
					cWeight += truck_weights[index];
					q.add(new int[] { truck_weights[index], answer });
					index++;
					
				}
			}

//			System.out.print(answer + " : �ٸ��� �ǳʴ� Ʈ�� ");
//			for (int[] i : q) {
//				System.out.print(Arrays.toString(i) +" ");
//			}
//			System.out.println();
			
			if (cnt == truck_weights.length) {
				break;
			}
			answer++;

		}
//		System.out.println(answer);
		return answer;
	}
}
