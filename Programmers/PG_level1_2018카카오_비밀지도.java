package test;

import java.util.Arrays;

public class PG_level1_2018카카오_비밀지도 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };

		solution(n, arr1, arr2);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			String map1 = encrypt(arr1[i], n);
			String map2 = encrypt(arr2[i], n);
			String result = "";
			for (int j = 0; j < n; j++) {
				char compare = (char) (map1.charAt(j) | map2.charAt(j));
				if (compare == '1') {
					result += "#";
				} else {
					result += " ";
				}
			}
			answer[i] = result;
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static String encrypt(int i, int n) {
		StringBuilder sb = new StringBuilder();

		while (i >= 1) {
			sb.append(i % 2);
			i /= 2;
		}

		while (sb.toString().length() < n) {
			sb.append(0);
		}

		return sb.reverse().toString();
	}

}
