package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_�����ǰ��峭���� {

	static int answer, N;
	static int[] input;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(in.readLine());

			input = new int[10];
			for (int i = 0; i < 10; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			N = Integer.parseInt(in.readLine());
			answer = -1;
			nums = new int[1000001]; // ���� �� �ִ� ���� ��� �����ϱ� ���� �迭

			if (N == 1 && input[1] == 1) { // 1�̸� �ٷ� ��� ���
				answer = 2;
			} else {
				selectNum(0, 0);
				calc(N);
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	private static void selectNum(int n, int count) { // ��Ž�� �̿��Ͽ� ��� �� ã��
		if (count > 7 || N < n) { // 6�ڸ��� �Ѿ�ų� N���� Ŀ���� ����
			return;
		}
		if (count > 0) { // 1~6�ڸ� �����̸� ���⸦ ���� Ƚ�� ����
			nums[n] = count;
		}
		for (int i = 0; i < 10; i++) {
			if (input[i] == 1) { // ���⿡�� ���� �� �ִ� �����̸�
				selectNum(10 * n + i, count + 1); // �ϳ� ������ ���� �����Է�
			}
		}

	}

	private static void calc(int n) { // �� �� ������ �ϴ��� ���
		int cnt = 0;
		for (int i = N; i > 1; i--) {
			while (true) {
				if (n % i == 0 && nums[i] > 0) { // ���� �� �ִ� ���� �߿��� ���������� ���� ������
					cnt += 1 + nums[i]; // �� ���� ���� Ƚ���� �����ְ�
					n /= i; // ������.
				} else // �ƴϸ� ����
					break;
			}
			if (n == 1) { // 1�̸� ����
				answer = cnt;
				return;
			}
		}
	}
}
