package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PG_level3_해시_베스트앨범 {
	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "jazz", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		solution(genres, plays);
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		HashMap<String, Integer> cntMap = new HashMap<>();
		HashMap<String, List<int[]>> playMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
			if (playMap.containsKey(genres[i])) {
				List<int[]> list = playMap.get(genres[i]);
				list.add(new int[] {i, plays[i]});
				playMap.put(genres[i], list);
			}else {
				List<int[]> list = new ArrayList<>();
				list.add(new int[] {i, plays[i]});
				playMap.put(genres[i], list);
			}
		}
		
		int cnt = 0; // answer 배열의 길이를 구하기 위한 변수
		for (String s : playMap.keySet()) {
			if(playMap.get(s).size() >= 2) {
				cnt += 2;
			}else {
				cnt++;
			}
		}

		answer = new int[cnt];
		
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(cntMap.entrySet());
	    Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

	    LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
	    for (Map.Entry<String, Integer> entry : entries) {
	        result.put(entry.getKey(), entry.getValue());
	    }
		
//	    System.out.println(result);
		
		
		int index = 0;
		for (String s : result.keySet()) {
			List<int[]> list = playMap.get(s);
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] < o2[1]) {
						return 1;
					}else if(o1[1] > o2[1]) {
						return -1;
					}else {
						if(o1[0] < o2[0]) {
							return -1;
						}else if(o1[0] > o2[0]) {
							return 1;
						}else {
							return 0;
						}
					}
				}
			});
			if(list.size() >= 2) {
				answer[index++] = list.get(0)[0];
				answer[index++] = list.get(1)[0];
			} else {
				answer[index++] = list.get(0)[0];
			}
		}

//		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
