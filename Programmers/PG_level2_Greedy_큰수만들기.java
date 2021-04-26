package test;

import java.util.Arrays;

public class PG_level2_Greedy_큰수만들기 {
	public static void main(String[] args) {
//		String number = "4177252841";
//		int k = 4;
		String number = "1231234";
		int k = 3;

		solution(number, k);
	}

	public static String solution(String number, int k) {
		String answer = "";

		int n = number.length();
		StringBuilder sb = new StringBuilder();

		int maxIdx = 0;
		for (int i = 0; i < n - k; i++) {
			char max = '0';
			for (int j = maxIdx; j <= k + i; j++) {
				if (max < number.charAt(j)) {
					maxIdx = j + 1;
					max = number.charAt(j);
				}
			}
			sb.append(max);
		}

		System.out.println(answer);
		return sb.toString();
	}
}
