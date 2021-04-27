package test;

public class PG_level2_점프와순간이동 {
	public static void main(String[] args) {
		int n = 5000;
		solution(n);
	}

	public static int solution(int n) {
		int ans = 0;

		while (n > 0) {
			ans += n % 2;
			n /= 2;
			System.out.println("ans : " + ans);
			System.out.println(n);
		}

		return ans;
	}
}
