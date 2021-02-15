package test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11656_접미사배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String[] arr = new String[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.next();
		}
		
		int answer = 0;
		boolean[] alpha = new boolean[26];
		for (int i = 0; i < arr.length; i++) {
			alpha = new boolean[26];
			if(arr[i].length() == 1) {
				answer++;
			}
			else {
				for (int j = 1; j < arr[i].length(); j++) {
					alpha[arr[i].charAt(j)-'a'] = true;
					if(arr[i].charAt(j) != arr[i].charAt(j-1)) {
						if(alpha[arr[i].charAt(j)-'a']) {
							System.out.println(arr[i].charAt(j-1) + " " + arr[i].charAt(j));
							System.out.println("hey!!");
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
}
