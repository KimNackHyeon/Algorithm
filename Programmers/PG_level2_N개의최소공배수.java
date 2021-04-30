package test;

public class PG_level2_N개의최소공배수 {
	public static void main(String[] args) {
//		int[] arr = { 2, 6, 8, 14 };
		int[] arr = { 3,2,6 };
		solution(arr);
	}

	public static int solution(int[] arr) {
		int answer = arr[0];

		for (int i = 1; i < arr.length; i++) {
			answer = solve(answer, arr[i]);
		}
		System.out.println(answer);

		return answer;
	}

	private static int solve(int num1, int num2) {
		gcd(num1,num2);

		return (num1 * num2) / gcd(num1,num2);
	}

	private static int gcd(int num1, int num2) {
		int tmp;
		while(num2!=0) {
			tmp = num2;
			num2 = num1 % num2;
			num1 = tmp;
		}
		return num1;
	}
	
	
}
