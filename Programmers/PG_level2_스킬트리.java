package test;

import java.util.HashMap;
import java.util.Map;

public class PG_level2_스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		solution(skill, skill_trees);
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i);
		}
		
		System.out.println(map);
		
		for (int i = 0; i < skill_trees.length; i++) {
			int idx = 0;
			boolean check = true;
			for (int j = 0; j < skill_trees[i].length(); j++) {
//				System.out.println(skill_trees[i]);
				char sk = skill_trees[i].charAt(j);
				if(map.containsKey(sk)) {
//					System.out.println(sk);
					if(idx == map.get(sk)) {
						idx++;
					}else {
						check = false;
						break;
					}
				}
			}
			if(check) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		return answer;
	}
}
