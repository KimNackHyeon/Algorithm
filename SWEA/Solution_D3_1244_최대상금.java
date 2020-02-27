package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1244_최대상금 {

	static int T;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution1244.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt(); // 테스트 케이스 수

		for (int test_case = 1; test_case <= T; test_case++) {
			int input = sc.nextInt();
			int change = sc.nextInt();
			String temp = input + "";
			int[] nums = new int[temp.length()];
			int Answer = 0;

			for (int i = 0; i < nums.length; i++) {
				nums[i] = temp.charAt(i) - '0';
			}
			
			int start = 0;
			int end = nums.length;
			while (change > 0) {
				
				int maxValue = -1;
				int maxIndex = -1;
				for (int i = start; i < end; i++) {
					if (nums[i] >= maxValue) {
						maxValue = nums[i];
						maxIndex = i;
					}
				}

				int swap;
				swap = nums[maxIndex];
				nums[maxIndex] = nums[start];
				nums[start] = swap;

				for (int i : nums) {
					System.out.print(i);
				}
				change--;
			}
			
			System.out.println();
			System.out.println("#" + test_case + " " + Answer);
		}

	}
}
