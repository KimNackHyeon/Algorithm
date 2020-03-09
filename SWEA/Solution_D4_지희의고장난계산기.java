package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_지희의고장난계산기 {

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
			nums = new int[1000001]; // 만들 수 있는 수를 모두 저장하기 위한 배열

			if (N == 1 && input[1] == 1) { // 1이면 바로 결과 출력
				answer = 2;
			} else {
				selectNum(0, 0);
				calc(N);
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	private static void selectNum(int n, int count) { // 완탐을 이용하여 모든 수 찾기
		if (count > 7 || N < n) { // 6자리를 넘어가거나 N보다 커지면 리턴
			return;
		}
		if (count > 0) { // 1~6자리 숫자이면 계산기를 누른 횟수 저장
			nums[n] = count;
		}
		for (int i = 0; i < 10; i++) {
			if (input[i] == 1) { // 계산기에서 누를 수 있는 숫자이면
				selectNum(10 * n + i, count + 1); // 하나 누르고 다음 숫자입력
			}
		}

	}

	private static void calc(int n) { // 몇 번 눌러야 하는지 계산
		int cnt = 0;
		for (int i = N; i > 1; i--) {
			while (true) {
				if (n % i == 0 && nums[i] > 0) { // 만들 수 있는 숫자 중에서 나누어지는 수가 있으면
					cnt += 1 + nums[i]; // 그 수를 만든 횟수를 더해주고
					n /= i; // 나눈다.
				} else // 아니면 종료
					break;
			}
			if (n == 1) { // 1이면 리턴
				answer = cnt;
				return;
			}
		}
	}
}
