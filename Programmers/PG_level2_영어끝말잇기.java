package test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PG_level2_영어끝말잇기 {
	public static void main(String[] args) {
		int n = 3;
		String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };

		solution(n, words);
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		Set<String> set = new TreeSet<>();
		set.add(words[0]);
		char prev = words[0].charAt(words[0].length() - 1);
		for (int i = 1; i < words.length; i++) {
			if (set.contains(words[i])) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			} else {
				set.add(words[i]);
				char next = words[i].charAt(0);
				if(next != prev) {
					answer[0] = (i % n) + 1;
					answer[1] = (i / n) + 1;
					break;
				}else {
					prev = words[i].charAt(words[i].length() - 1);
				}
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
