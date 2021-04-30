package test;

import java.util.*;

public class PG_level2_최솟값만들기 {
	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };

		solution(A, B);
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);
		int n = A.length;
		for (int i = 0; i < n; i++) {
			answer += A[i] * B[n - i - 1];
		}
		System.out.println(answer);
		return answer;
	}
}
