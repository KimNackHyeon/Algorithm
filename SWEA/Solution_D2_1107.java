package test;

import java.util.Scanner;

public class Solution_D2_1107 {

	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = sc.next();
			String temp = "";
			for(int i = 0; i < 10; i++) {
				temp += input.charAt(i);
				String cp = input.substring(i+1,temp.length()+i+1);
				if(temp.equals(cp)) {
					break;
				}
			}
			System.out.println("#"+ test_case + " " + temp.length());
		}
	}
}
