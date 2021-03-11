package test;

import java.util.Arrays;
import java.util.Comparator;

public class PG_level2_정렬_가장큰수 {
	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };
//		int[] numbers = { 6, 10, 2 };
//		int[] numbers = { 0, 0, 0 };
		solution(numbers);
	}

	public static String solution(int[] numbers) {
		String answer = "";

		String[] itos = new String[numbers.length];
		for (int i = 0; i < itos.length; i++) {
			itos[i] = numbers[i] + "";
		}

		Arrays.sort(itos, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
					int num1 = Integer.parseInt(o1 + o2);
					int num2 = Integer.parseInt(o2 + o1);
					if (num1 > num2) {
						return -1;
					} else if (num1 < num2) {
						return 1;
					} else {
						return 0;
					}
			}

		});
		for (String s : itos) {
			answer += s;
		}
//		System.out.println(Arrays.toString(itos));
//		System.out.println(answer);
		if(answer.charAt(0) == '0') {
			return "0";
		}
		return answer;
	}
}
