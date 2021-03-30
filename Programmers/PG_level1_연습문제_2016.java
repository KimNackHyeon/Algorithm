package test;

public class PG_level1_연습문제_2016 {

	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		solution(a, b);
	}

	public static String solution(int a, int b) {
		String answer = "";
		String[] days = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
		int[] cnt = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int sum = b;
		for (int i = 0; i < a; i++) {
			sum += cnt[i];
		}

		answer = days[sum % 7];
//		System.out.println(sum);
//		System.out.println(sum % 7);
//		System.out.println(answer);
		return answer;
	}
}
