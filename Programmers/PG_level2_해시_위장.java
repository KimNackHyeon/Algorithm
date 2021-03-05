package test;

import java.util.HashMap;

public class PG_level2_해시_위장 {
	public static void main(String[] args) {
//		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
//				{ "green_turban", "headgear" } };
//		String[][] clothes = {{"yellowhat", "bottom"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };
		solution(clothes);
	}

	public static int solution(String[][] clothes) {
		int answer = 0;

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		int sum = 1;
		for (String s : map.keySet()) {
			sum *= map.get(s) + 1;
		}
		answer = sum - 1;
		return answer;
	}

}
