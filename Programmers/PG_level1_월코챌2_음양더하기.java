package codechallenge;

public class PG_level1_����ç2_������ϱ� {
	public static void main(String[] args) {
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };
	}

	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		
		for (int i = 0; i < absolutes.length; i++) {
			if(signs[i]) {
				answer += absolutes[i];
			}else {
				answer -= absolutes[i];
			}
		}
		
		return answer;
	}
}
