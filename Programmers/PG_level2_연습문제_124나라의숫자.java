package test;

public class PG_level2_연습문제_124나라의숫자 {
	public static void main(String[] args) {
		int n = 40;
		solution(n);
	}

	public static String solution(int n) {
		String answer = "";

		int[] nums = { 1, 2, 4 };

		StringBuilder sb = new StringBuilder();
//		if (n <= 3) {
//			return nums[n - 1] + "";
//		}

		while (n >= 1) {
			if (n % 3 != 0) {
				sb.append(nums[n % 3 - 1]);
			} else {
				sb.append(nums[2]);
			}
			n--;
			n /= 3;
		}
		answer = sb.reverse().toString();
		System.out.println(answer);
		return answer;
	}
}
