package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PG_level3_Greedy_단속카메라 {
	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		solution(routes);
	}
	
	public static int solution(int[][] routes) {
        int answer = 0;
        
        List<int[]> list = new ArrayList<>();
        
        for (int[] is : routes) {
			list.add(is);
		}
        
        Collections.sort(list,(o1,o2) -> (o1[1] - o2[1]));
        
        
        int camera = 0;
        while(!list.isEmpty()) {
        	camera = list.remove(0)[1];
        	answer++;
        	
        	for (int i = 0; i < routes.length; i++) {
				if(camera >= routes[i][0]) {
					list.remove(routes[i]);
				}
			}
        }
        
        System.out.println(answer);
        for (int[] is : list) {
			System.out.println(Arrays.toString(is));
		}
        return answer;
    }
}
