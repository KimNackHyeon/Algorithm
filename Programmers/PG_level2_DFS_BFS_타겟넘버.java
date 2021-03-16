package test;

public class PG_level2_DFS_BFS_Å¸°Ù³Ñ¹ö {
	public static void main(String[] args) {
//		int[] numbers = { 1, 1, 1 };
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		solution(numbers, target);
	}
	static int answer;
	public static int solution(int[] numbers, int target) {
		answer = 0;

		dfs(0, 0, target, numbers);

		return answer;
	}

	private static void dfs(int c, int sum, int target, int[] numbers) {
		if (c == numbers.length) {
			if (sum == target) {
				System.out.println(sum);
				answer++;
			}
			return;
		}
		dfs(c + 1, sum + numbers[c], target, numbers);
		dfs(c + 1, sum - numbers[c], target, numbers);
	}

}
