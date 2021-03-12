package test;

import java.util.Arrays;
import java.util.Collections;

public class PG_level2_Á¤·Ä_HIndex {
	public static void main(String[] args) {
//		int[] citations = { 3, 0, 6, 1, 5 };
//		int[] citations = { 8, 10, 5, 4, 3 };
//		int[] citations = { 25, 8, 5, 3, 3 };
		int[] citations = {1000, 6, 5, 4, 1, 0 };
		solution(citations);
	}

	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);
		int len = citations.length - 1;

//		for (int i = 10000; i >= 0; i--) {
//			int high = 0;
//			int low = 0;
//			for (int j = 0; j <= len; j++) {
//				if (i <= citations[j]) {
//					high++;
//				}
//				if (i >= citations[j]) {
//					low++;
//				}
//			}
//			if (high >= i && i >= low) {
//				answer = i;
//				break;
//			}
////			System.out.println(i + " : " + high + " " + low);
//		}
		
		int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
            System.out.println(citations[i] + " " + min + " " + max);
        }
		return answer;
	}
}
