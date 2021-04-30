package test;

import java.util.Arrays;

public class PG_level2_Çà·ÄÀÇ°ö¼À {
	public static void main(String[] args) {
//		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
//		int[][] arr2 = { { 3, 3 }, { 3, 3 } };

//		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//		int[][] arr2 ={{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		
		int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] arr2 ={{1, 4}, {2, 5}, {3, 6}};
		solution(arr1, arr2);
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		int n = arr1.length;
		int m = arr2.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				int sum = 0;
				int[] temp1 = arr1[i];

				int[] temp2 = new int[m];
				for (int k = 0; k < m; k++) {
					temp2[k] = arr2[k][j];
				}
				for (int k = 0; k < m; k++) {
					sum += temp1[k] * temp2[k];
				}
				System.out.println(Arrays.toString(temp1));
				System.out.println(Arrays.toString(temp2));
				System.out.println();
				answer[i][j] = sum;
			}
		}
		for (int[] is : answer) {
			System.out.println(Arrays.toString(is));
		}
		return answer;
	}
}
