package test;

import java.util.Stack;

public class PG_level2_2017팁스타운_짝지어제거하기 {
	public static void main(String[] args) {
//		String s = "baabaa";
		String s = "baabaabbb";
//		String s = "cdcd";
		solution(s);
	}

	public static int solution(String s) {
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty()) {
				st.push(s.charAt(i));
			} else {
				if (st.peek() == s.charAt(i)) {
					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			}
		}

		if (st.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
}
