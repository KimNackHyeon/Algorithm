package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PG_level2_2018카카오_뉴스클러스터링 {
	public static void main(String[] args) {
//		String str1 = "FRANCE";
//		String str2 = "french";
//		String str1 = "E=M*C^2";
//		String str2 = "e=m*c^2";
//		String str1 = "aa1+aa2";
//		String str2 = "AaAa12";
		String str1 = "AAbbaa_AA";
		String str2 = "BBB";
		solution(str1, str2);
	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		List<String> set1 = make(str1); // str1 다중 집합
		List<String> set2 = make(str2); // str2 다중 집합

		if (set1.size() == 0 && set2.size() == 0) { // 둘 다 공집합일 경우
			return 65536;
		}

		float gyo = 0;
		if(set1.size() <= set2.size()) {
			gyo =interSection(set1, set2);
		} else {
			gyo = interSection(set2, set1);
		}
		float hap = set1.size() + set2.size() - gyo;
		float jacquard = gyo / hap;
		answer = (int)(jacquard * 65536);

//		System.out.println(gyo + " " + hap);
//		System.out.println(jacquard);
//		System.out.println(set1);
//		System.out.println(set2);
//		System.out.println(answer);

		return answer;
	}

	private static int interSection(List<String> set1, List<String> set2) {
		int cnt = 0;
		boolean[] check = new boolean[set2.size()];
		for (int i = 0; i < set1.size(); i++) {
			for (int j = 0; j < set2.size(); j++) {
				if(set1.get(i).equals(set2.get(j)) && !check[j]) {
					cnt++;
					check[j] = true;
					break;
				}
			}
		}
		return cnt;
	}

	// 다중 집합 생성
	private static List<String> make(String str) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < str.length() - 1; i++) {
			String temp = str.charAt(i) + "" + str.charAt(i + 1);
			// 영문자로만 구성된 문자열만 남기기
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				if ('A' <= str.charAt(i + 1) && str.charAt(i + 1) <= 'Z') {
					result.add(temp);
				}
			}
		}

		return result;
	}
}
