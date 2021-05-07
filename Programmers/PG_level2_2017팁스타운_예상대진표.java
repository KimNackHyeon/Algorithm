package test;

public class PG_level2_2017팁스타운_예상대진표 {
	public static void main(String[] args) {
		solution(8, 4, 7);
	}

	public static int solution(int n, int a, int b) {
		int answer = 1;

		while (true) {
			if ((a + 1) / 2 == (b + 1) / 2) {
				break;
			}

			a = (a + 1) / 2;
			b = (b + 1) / 2;
			answer++;

		}
		System.out.println(answer);
		return answer;
	}
}
