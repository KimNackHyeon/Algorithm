package test;

import java.util.Arrays;

public class PG_level2_2021데브매칭_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };

		solution(lottos, win_nums);
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		Arrays.sort(lottos);
		Arrays.sort(win_nums);

		int match = 0;
		int what = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j]) {
					match++;
					break;
				}
			}
			if (lottos[i] == 0) {
				what++;
			}
		}
		System.out.println(match);
		System.out.println(what);
		answer[0] = 7 - (match + what);
		answer[1] = 7 - match;
		if(match == 0) {
			answer[1] = 6;
		}
		if(what == 6) {
			answer[0] = 1;
		}
		if(match == 0 && what == 0) {
			answer[0] = 6;
			answer[1] = 6;
		}

		return answer;
	}
}
