package test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PG_level2_완전탐색_소수찾기 {
	public static void main(String[] args) {
//		String numbers = "17";
//		String numbers = "011";
		String numbers = "1234";
		solution(numbers);
	}

	static Set<Integer> set = new TreeSet<>();

	public static int solution(String numbers) {

		for (int i = 1; i <= numbers.length(); i++) {
			boolean visit[] = new boolean[numbers.length()];
			int[] result = new int[i];
			perm(numbers.length(), i, result, 0, numbers, visit);
		}
		System.out.println(set);
		return set.size();
	}

	private static void perm(int n, int r, int[] result, int c, String numbers, boolean[] visit) {
		if (r == c) {
			String temp = "";
			for (int i = 0; i < result.length; i++) {
				temp += result[i];
			}
			int num = Integer.parseInt(temp);
			if (num <= 1)
				return;
			if (num != 2 && num % 2 == 0)
				return;
			for (int i = 3; i <= (int) Math.sqrt(num); i++) {
				if (num % i == 0)
					return;
			}
			set.add(num);
			return;
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[c] = numbers.charAt(i) - '0';
				perm(n, r, result, c + 1, numbers, visit);
				visit[i] = false;
			}
		}
	}
}
