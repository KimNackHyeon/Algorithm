package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PG_level2_스택큐_기능개발 {
	public static void main(String[] args) {
//		int[] progresses = { 93, 30, 55 };
//		int[] speeds = { 1, 30, 5 };
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };
//		int[] progresses = { 99, 99, 99, 99, 80, 99 };
//		int[] speeds = { 1, 1, 1, 1, 1, 1 };
		solution(progresses, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};

		int[] days = new int[progresses.length];
		List<Integer> list = new ArrayList<>();
		Stack<Integer> st = new Stack<>();

		int max = 0;
		for (int i = 0; i < progresses.length; i++) {
			int nmg = 100 - progresses[i];
			int day = nmg / speeds[i];
			if ((day * speeds[i]) + progresses[i] < 100) {
				day++;
			}
			days[i] = day;
			if (st.empty()) {
				st.push(days[i]);
				max = days[i];
			} else {
				if (max < days[i]) {
//					System.out.print(max + "일차 : ");
					list.add(st.size());
					while (!st.empty()) {
						st.pop();
//						System.out.print(st.pop() +" ");
					}
//					System.out.println();
				}
				st.push(days[i]);
				max = Math.max(max, days[i]);
			}
//			System.out.println(st);
		}
//		System.out.print(max + "일차 : ");
//		while (!st.empty()) {
//			System.out.print(st.pop() +" ");
//		}
//		System.out.println();
		list.add(st.size());
		
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
