package test;

import java.util.Arrays;

public class PG_level1_정렬_K번째수 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int idx = 0; idx < commands.length; idx++) {
			int i = commands[idx][0]; // 자르기 시작 인덱스
			int j = commands[idx][1]; // 자르기 끝 인덱스
			int k = commands[idx][2]; // 몇 번째 값

			int[] split = Arrays.copyOfRange(array, i - 1, j); // i ~ j 까지 자르기
			Arrays.sort(split); // 정렬
			answer[idx] = split[k-1];
		}
//		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
