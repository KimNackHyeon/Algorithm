package test;

public class PG_level2_피보나치수 {
	public static void main(String[] args) {
		int n = 5;
		solution(n);
	}
	
	public static int solution(int n) {
        
        int[] fibo = new int[1000001];
        
        fibo[1] = 1;
        fibo[2] = 1;
        fibo[3] = 2;
        
        for (int i = 4; i < fibo.length; i++) {
			fibo[4] = fibo[i-2] + fibo[i-1];
		}
        
        return fibo[n];
    }
}
