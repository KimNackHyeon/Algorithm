package test;

import java.util.Stack;

public class PG_level1_2019카카오_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		solution(board, moves);
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer>[] map = new Stack[board.length];

		for (int i = 0; i < map.length; i++) {
			map[i] = new Stack<>();
			for (int j = board[i].length - 1; j >= 0; j--) {
				if (board[j][i] != 0) {
					map[i].push(board[j][i]);
				}
			}
		}

//		for (Stack<Integer> s : map) {
//			System.out.println(s);
//		}

		Stack<Integer> result = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			if (map[moves[i] - 1].isEmpty())
				continue;
			int n = map[moves[i] - 1].pop();

			if (result.isEmpty()) {
				result.push(n);
			} else if (result.peek() == n) {
				result.pop();
				answer+=2;
			} else {
				result.push(n);
			}
		}

//		System.out.println(result);
//		System.out.println(answer);
		return answer;
	}
}
