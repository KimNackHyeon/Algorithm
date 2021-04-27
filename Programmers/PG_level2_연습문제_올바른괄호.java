package test;

import java.util.Stack;

public class PG_level2_연습문제_올바른괄호 {
	public static void main(String[] args) {
//		String s = "()()";
		String s = ")()(";
		System.out.println(solution(s));
	}
	
	static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				st.push(c);
			}else {
				if(st.isEmpty()) {
					return false;
				}
				if(st.peek() == '(') {
					st.pop();
				}else {
					return false;
				}
			}
		}
        if(!st.isEmpty()) {
        	return false;
        }
        
        return answer;
    }
}
