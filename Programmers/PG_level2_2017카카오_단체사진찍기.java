package test;

import java.util.ArrayList;
import java.util.List;

public class PG_level2_2017카카오_단체사진찍기 {
	public static void main(String[] args) {
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };

		solution(n, data);
	}

	static String[] people = { "A", "C", "F", "J", "M", "N", "R", "T" };
	static boolean[] check;
	static int ans;

	public static int solution(int n, String[] data) {
		int answer = 0;
		List<String> result = new ArrayList<>();
		ans = 0;
		check = new boolean[8];
		perm(8, 8, 0, result, data);
		answer = ans;
		System.out.println(answer);
		return answer;
	}

	private static void perm(int n, int r, int c, List<String> result, String[] data) {
		if (r == c) {
			int cnt = 0;
			for (int i = 0; i < data.length; i++) {
				char p1 = data[i].charAt(0);
				char p2 = data[i].charAt(2);
				char op = data[i].charAt(3);
				int num = data[i].charAt(4) - '0';

				int dist = Math.abs(result.indexOf(p1 + "") - result.indexOf(p2 + "")) - 1;
				switch (op) {
				case '=':
					if (num == dist) {
						cnt++;
					} else {
						return;
					}
					break;
				case '<':
					if (num > dist) {
						cnt++;
					} else {
						return;
					}
					break;
				case '>':
					if (num < dist) {
						cnt++;
					} else {
						return;
					}
					break;
				default:
					break;
				}
			}
			if (cnt == data.length) {
				ans++;
			}
			return;
		}
		for (int i = 0; i < people.length; i++) {
			if (!check[i]) {
				result.add(people[i]);
				check[i] = true;
				perm(n, r, c + 1, result, data);
				result.remove(people[i]);
				check[i] = false;
			}
		}
	}
}
