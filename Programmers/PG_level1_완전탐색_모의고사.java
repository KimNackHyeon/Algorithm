package test;

import java.util.Arrays;

public class PG_level1_완전탐색_모의고사 {
	public static void main(String[] args) {
//		int[] answers = { 1, 2, 3, 4, 5 };
		int[] answers = { 1, 3, 2, 4, 2 };
		solution(answers);
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};

		int[] people = { 0, 0, 0 };

		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == p1[i % 5]) {
				people[0]++;
			}
			if (answers[i] == p2[i % 8]) {
				people[1]++;
			}
			if (answers[i] == p3[i % 10]) {
				people[2]++;
			}

		}
		
		int max = Math.max(people[0], Math.max(people[1], people[2]));
		int cnt = 0;
		for (int i : people) {
			if(max == i) {
				cnt++;
			}
		}
		answer = new int[cnt];
		int index = 0;
		for (int i = 0; i < people.length; i++) {
			if(max == people[i]) answer[index++] = i+1;
		}
		System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.toString(people));

		return answer;
	}
}
