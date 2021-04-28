package test;

public class PG_level2_최대값과최솟값 {
	public static void main(String[] args) {
		String s = "1 2 3 4";
		solution(s);
	}
	
	public static String solution(String s) {
        String answer = "";
        
        String[] num = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < num.length; i++) {
			max = Math.max(max, Integer.parseInt(num[i]));
			min = Math.min(min, Integer.parseInt(num[i]));
		}
        
        answer = min + " "+ max;
        
        return answer;
    }
}
