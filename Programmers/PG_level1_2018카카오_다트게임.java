package test;

import java.util.Arrays;

public class PG_level1_2018카카오_다트게임 {
	public static void main(String[] args) {
//		String dartResult = "1S2D*3T";
		String dartResult = "1D2S#10S";
		solution(dartResult);
	}

	public static int solution(String dartResult) {
		int answer = 0;

		int[] result = new int[3];
		int index = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			char input = dartResult.charAt(i); // 문자

			if (input == 'S' || input == 'D' || input == 'T') {
				int num = bonus(input, dartResult, i);
				result[index++] = num;
			} else if (input == '*' || input == '#') {
				option(result, input, index);
			}
		}

		System.out.println(Arrays.toString(result));
		for (int i : result) {
			answer += i;
		}
		System.out.println(answer);
		return answer;
	}

	private static void option(int[] result, char input, int index) {
		switch (input) {
		case '*':
			result[index - 1] *= 2;
			if (index != 1) {
				result[index - 2] *= 2;
			}
			break;
		case '#':
			result[index - 1] *= -1;
			break;

		default:
			break;
		}
	}

	private static int bonus(char input, String dartResult, int index) {
		int num = dartResult.charAt(index - 1) - '0';

		if (index >= 2) {
			if (dartResult.charAt(index - 2) == '1') {
				num = 10;
			}
		}
		switch (input) {
		case 'D':
			num = num * num;
			break;
		case 'T':
			num = num * num * num;
			break;
		default:
			break;
		}

		return num;
	}
}
