package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution1225.txt"));
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		for (int test_case = 1; test_case <= 10; test_case++) {
			list.clear(); 				// 리스트 초기화
			int t = sc.nextInt();		// 테스트케이스 번호 입력
			for (int i = 0; i < 8; i++) {
				list.add(sc.nextInt());	// 숫자 8개 입력
			}
			int count = 1;				// 암호문에서 빼는 값
			while (true) {
				int temp = list.remove(0) - count;	// 리스트의 첫번째 값을 가져와 뺀다.
				count++;				// 1->2->3->4->5->1....
				if (count > 5)
					count = 1;
				if (temp <= 0) {		// 0이 나오면 종료
					temp = 0;
					list.add(temp);
					break;
				}
				list.add(temp);			// 0이 아니면 맨 뒤로 보낸다.
			}
			System.out.print("#" + t + " ");
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}