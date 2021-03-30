package test;

import java.util.Arrays;

public class PG_level1_Greedy_Ã¼À°º¹ {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 1, 2, 3 };
		int[] reserve = { 2, 3, 4 };
		solution(n, lost, reserve);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;

		int[] student = new int[n];

		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i] - 1]++;
		}
		for (int i = 0; i < lost.length; i++) {
			student[lost[i] - 1]--;
		}
//		System.out.println(Arrays.toString(student));
		for (int i = 0; i < lost.length; i++) {
			if (student[lost[i] - 1] == -1) {
				if (lost[i] - 2 >= 0 && student[lost[i] - 2] > 0) {
					student[lost[i] - 2]--;
					continue;
				} else if (lost[i] < n && student[lost[i]] > 0) {
					student[lost[i]]--;
					continue;
				}
				answer--;
			}
		}
//		System.out.println(answer);
		return answer;
	}
}
