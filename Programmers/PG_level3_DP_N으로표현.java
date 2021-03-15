package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PG_level3_DP_N으로표현 {
	public static void main(String[] args) {
		int N = 5;
		int number = 110;
//		int N = 2;
//		int number = 11;
		System.out.println(solution(N, number));
	}

	public static int solution(int N, int number) {
		int answer = -1;
		if (N == number) {
			return 1;
		}

		List<Set<Long>> list = new ArrayList<>();

		list.add(new TreeSet<>());
		list.add(new TreeSet<>());
		list.get(1).add((long) N);

		for (int i = 2; i <= 8; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append(N);
			}
			list.add(new TreeSet<>());
			list.get(i).add(Long.parseLong(sb.toString()));

			for (int j = 1; j < i; j++) {
				for (Long num1 : list.get(j)) {
					for (Long num2 : list.get(i - j)) {
						list.get(i).add(num1 + num2);
						list.get(i).add(num1 * num2);
						list.get(i).add(num1 - num2);
						if (num2 != 0 && num1 % num2 == 0) {
							list.get(i).add(num1 / num2);
						}
					}
				}
			}
//			for (Long l : list.get(i - 2)) {
//				list.get(i - 1).add(l + N);
//				list.get(i - 1).add(l * N);
//				list.get(i - 1).add(l - N);
//				if (l % N == 0) {
//					list.get(i - 1).add(l / N);
//				}
//			}
			System.out.println(i + " : " + list.get(i));
			if (list.get(i).contains((long) number)) {
				return i;
			}
		}

		for (Set<Long> set : list) {
			System.out.println(set);
		}

		return answer;
	}
}
