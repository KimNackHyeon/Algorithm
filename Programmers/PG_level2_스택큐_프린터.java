package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_level2_����ť_������ {
	public static void main(String[] args) {
//		int[] priorities = { 2, 1, 3, 2 };
//		int location = 2;
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		solution(priorities, location);
	}

	public static int solution(int[] priorities, int location) {
//		int answer = 0;

		int[] prints = new int[priorities.length];

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(new int[] { i + 1, priorities[i] });
		}

		int priority = 0;
		while (!list.isEmpty()) {
			int index = 0;
			boolean flag = false;
			for (int j = index + 1; j < list.size(); j++) {
				if (list.get(index)[1] < list.get(j)[1]) { // �켱���� �� �� �켱������ ���� ���� �ִٸ�
					int[] temp = list.remove(index); // ������ �� �ڷ�
					list.add(temp);
					flag = true;
					break;
				}
			}

			if (!flag) {
				prints[list.remove(index)[0] - 1] = priority + 1;
				priority++;
			}
			index++;
//			System.out.println(Arrays.toString(prints));
		}

		return prints[location];
	}

}
