package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기 {

	static int[][] m;
	private static int[][] dap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // 마스터의 코드 수
			int q = Integer.parseInt(st.nextToken()); // 나의 코드 수

			// 마스터 코드 분석
			m = new int[p][4]; // . 소 중 대
			for (int i = 0; i < p; i++) { // 한 줄 입력받고 .의 개수, 괄호 개수 계산
				String line = in.readLine();
				int index = 0; // .의 개수
				while (line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index;
				if (i > 0) { // 이전 값으로 초기화
					m[i][1] = m[i - 1][1]; // 소괄호
					m[i][2] = m[i - 1][2]; // 중괄호
					m[i][3] = m[i - 1][3]; // 대괄호
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(':
						m[i][1]++;
						break;
					case ')':
						m[i][1]--;
						break;
					case '{':
						m[i][2]++;
						break;
					case '}':
						m[i][2]--;
						break;
					case '[':
						m[i][3]++;
						break;
					case ']':
						m[i][3]--;
						break;
					default:
						break;
					}
				}
			}

			// 내 코드 분석
			dap = new int[q][4]; // . 소 중 대
			for (int i = 0; i < q; i++) { // 한 줄 입력받고 .의 개수, 괄호 개수 계산
				String line = in.readLine();
				int index = 0; // .의 개수

				if (i > 0) { // 이전 값으로 초기화
					dap[i][1] = dap[i - 1][1]; // 소괄호
					dap[i][2] = dap[i - 1][2]; // 중괄호
					dap[i][3] = dap[i - 1][3]; // 대괄호
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(':
						dap[i][1]++;
						break;
					case ')':
						dap[i][1]--;
						break;
					case '{':
						dap[i][2]++;
						break;
					case '}':
						dap[i][2]--;
						break;
					case '[':
						dap[i][3]++;
						break;
					case ']':
						dap[i][3]--;
						break;
					default:
						break;
					}
				}

			}
			for (int i = 0; i < q; i++) { // .의 개수 초기화
				dap[i][0] = -2;
			}
			// 중복 순열
			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (check(R, C, S)) { // 마스터 코드의 RCS 인지?
							cal(R, C, S);
						}
					}
				}
			}
			sb.append('#').append(t).append(" 0");
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
			}
			sb.append('\n');

		}
		System.out.println(sb);
	}

	/**
	 * 내 코드에서 들여쓰기를 몇 번 해야하는지 계산
	 */
	public static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i - 1][1] * R + dap[i - 1][2] * C + dap[i - 1][3] * S;
			if (dap[i][0] == -2) { // 답을 구한적이 없으면
				dap[i][0] = x;
			} else if (dap[i][0] != x) { // 기존값과 다른 값이면
				dap[i][0] = -1;
			}
		}
	}

	/**
	 * 마스터 코드에서 해가 되는지 체크해서 리턴
	 */
	public static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] != m[i - 1][1] * R + m[i - 1][2] * C + m[i - 1][3] * S) {
				return false;
			}
		}
		return true;
	}
}
