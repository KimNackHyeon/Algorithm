package codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PG_level2_¿ùÄÚÃ§2_°ıÈ£È¸ÀüÇÏ±â {
	public static void main(String[] args) {
//		String s = "[](){}";
//		String s = "}]()[{";
		String s = "[)(]";

		solution(s);
	}

	public static int solution(String s) {
		int answer = s.length();

		List<Character> list = new ArrayList<>();
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		for (int i = 0; i < list.size(); i++) {
			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {

				if (list.get(j) == '[' || list.get(j) == '{' || list.get(j) == '(') {
					st.push(list.get(j));
				} else {
					if(st.isEmpty()) {
						answer--;
						flag = true;
						break;
					}
					char c = st.pop();
					if (c == '[') {
						if(!(list.get(j) == ']')) {
							answer--;
							flag = true;
							break;
						}
					} else if (c == '{') {
						if(!(list.get(j) == '}')) {
							answer--;
							flag = true;
							break;
						}
					} else if (c == '(') {
						if(!(list.get(j) == ')')) {
							answer--;
							flag = true;
							break;
						}
					}
				}
			}
			if(!flag && !st.isEmpty()) {
				answer--;
			}
			st.clear();
			list.add(list.remove(0));
		}

		return answer;
	}
}
