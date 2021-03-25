package test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PG_level1_월코챌1_두개뽑아서더하기 {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		solution(numbers);
	}
	
	public static int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
        
//        System.out.println(set);
        answer = new int[set.size()];
        int idx = 0;
        for (Integer i : set) {
			answer[idx++] = i;
		}
        
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
