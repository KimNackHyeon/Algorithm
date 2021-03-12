package test;

public class PG_level2_¿ÏÀüÅ½»ö_Ä«Æê {
	public static void main(String[] args) {
//		int brown = 10;
//		int yellow = 2;
		int brown = 24;
		int yellow = 24;
		solution(brown, yellow);
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int area = brown + yellow;
		for (int i = 3; i < area; i++) {
			if (area % i == 0 && i >= (area / i) && (area / i) >= 3) {
				int x = i;
				int y = area / i;
				if ((x + y - 2) * 2 == brown) {
					System.out.println(i + " " + area / i);
					answer[0] = x;
					answer[1] = y;
				}
			}
		}

		return answer;
	}
}
