package test;

import java.util.Scanner;

public class Solution_D3_3431_준환이의운동관리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			int Answer = 0;
			
			if(L > X)
				Answer = L - X;
			else if(U < X)
				Answer = -1;
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}
