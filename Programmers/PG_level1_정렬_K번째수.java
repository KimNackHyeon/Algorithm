package test;

import java.util.Arrays;

public class PG_level1_����_K��°�� {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int idx = 0; idx < commands.length; idx++) {
			int i = commands[idx][0]; // �ڸ��� ���� �ε���
			int j = commands[idx][1]; // �ڸ��� �� �ε���
			int k = commands[idx][2]; // �� ��° ��

			int[] split = Arrays.copyOfRange(array, i - 1, j); // i ~ j ���� �ڸ���
			Arrays.sort(split); // ����
			answer[idx] = split[k-1];
		}
//		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
