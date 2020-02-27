package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_1225_��ȣ������ {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution1225.txt"));
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		for (int test_case = 1; test_case <= 10; test_case++) {
			list.clear(); 				// ����Ʈ �ʱ�ȭ
			int t = sc.nextInt();		// �׽�Ʈ���̽� ��ȣ �Է�
			for (int i = 0; i < 8; i++) {
				list.add(sc.nextInt());	// ���� 8�� �Է�
			}
			int count = 1;				// ��ȣ������ ���� ��
			while (true) {
				int temp = list.remove(0) - count;	// ����Ʈ�� ù��° ���� ������ ����.
				count++;				// 1->2->3->4->5->1....
				if (count > 5)
					count = 1;
				if (temp <= 0) {		// 0�� ������ ����
					temp = 0;
					list.add(temp);
					break;
				}
				list.add(temp);			// 0�� �ƴϸ� �� �ڷ� ������.
			}
			System.out.print("#" + t + " ");
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}