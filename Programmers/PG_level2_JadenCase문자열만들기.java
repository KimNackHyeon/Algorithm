package test;

import java.util.Arrays;

public class PG_level2_JadenCase문자열만들기 {
	public static void main(String[] args) {
//		String s = "3people unFollowed me";
		String s = " adgagd 3eagdag ";
		solution(s);
	}

	public static String solution(String s) {
		String answer = "";

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(i == 0) {
				if('a' <= c && c <= 'z') {
					c -= 32;
				}else if('A' <= c && c <= 'Z') {
					c += 32;
				}
			}else if(s.charAt(i-1) == ' '){
				if('a' <= c && c <= 'z') {
					c -= 32;
				}else if('A' <= c && c <= 'Z') {
					c += 32;
				}
			}
			sb.append(c);
		}
		
		answer = sb.toString();
		System.out.println(answer);
		return answer;
	}
}
