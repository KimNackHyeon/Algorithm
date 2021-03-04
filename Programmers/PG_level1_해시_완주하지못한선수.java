package test;

import java.util.HashMap;

public class PG_level1_해시_완주하지못한선수 {
	public static void main(String[] args) {
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] participant = { "mislav", "stanko", "mislav", "ana"};
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String[] completion = { "stanko", "ana", "mislav" };
		solution(participant, completion);
	}

	private static String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < participant.length; i++) {
			if (!map.containsKey(participant[i])) {
				map.put(participant[i], 1);
			} else {
				map.put(participant[i], map.get(participant[i]) + 1);
			}
		}
		
		for (int i = 0; i < completion.length; i++) {
			map.put(completion[i], map.get(completion[i]) - 1);
		}
		
		for (String s : map.keySet()) {
			if(map.get(s) != 0) {
				answer = s;
			}
		}

		return answer;
	}

}
