package test;

import java.util.Arrays;

public class PG_level2_스택큐_주식가격 {
	public static void main(String[] args) {
//		int[] prices = { 1, 2, 3, 2, 3 };
		int[] prices = { 1, 2, 3, 2, 3, 1 }; // 5 4 1 2 1 0 
		solution(prices);
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for (int i = 0; i < answer.length; i++) {

			for (int j = i + 1; j < answer.length; j++) {
				answer[i]++;
				if (prices[i] > prices[j]) {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
