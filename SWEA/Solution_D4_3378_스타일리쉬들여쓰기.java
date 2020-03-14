package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3378_��Ÿ�ϸ����鿩���� {

	static int[][] m;
	private static int[][] dap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // �������� �ڵ� ��
			int q = Integer.parseInt(st.nextToken()); // ���� �ڵ� ��

			// ������ �ڵ� �м�
			m = new int[p][4]; // . �� �� ��
			for (int i = 0; i < p; i++) { // �� �� �Է¹ް� .�� ����, ��ȣ ���� ���
				String line = in.readLine();
				int index = 0; // .�� ����
				while (line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index;
				if (i > 0) { // ���� ������ �ʱ�ȭ
					m[i][1] = m[i - 1][1]; // �Ұ�ȣ
					m[i][2] = m[i - 1][2]; // �߰�ȣ
					m[i][3] = m[i - 1][3]; // ���ȣ
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

			// �� �ڵ� �м�
			dap = new int[q][4]; // . �� �� ��
			for (int i = 0; i < q; i++) { // �� �� �Է¹ް� .�� ����, ��ȣ ���� ���
				String line = in.readLine();
				int index = 0; // .�� ����

				if (i > 0) { // ���� ������ �ʱ�ȭ
					dap[i][1] = dap[i - 1][1]; // �Ұ�ȣ
					dap[i][2] = dap[i - 1][2]; // �߰�ȣ
					dap[i][3] = dap[i - 1][3]; // ���ȣ
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
			for (int i = 0; i < q; i++) { // .�� ���� �ʱ�ȭ
				dap[i][0] = -2;
			}
			// �ߺ� ����
			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (check(R, C, S)) { // ������ �ڵ��� RCS ����?
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
	 * �� �ڵ忡�� �鿩���⸦ �� �� �ؾ��ϴ��� ���
	 */
	public static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i - 1][1] * R + dap[i - 1][2] * C + dap[i - 1][3] * S;
			if (dap[i][0] == -2) { // ���� �������� ������
				dap[i][0] = x;
			} else if (dap[i][0] != x) { // �������� �ٸ� ���̸�
				dap[i][0] = -1;
			}
		}
	}

	/**
	 * ������ �ڵ忡�� �ذ� �Ǵ��� üũ�ؼ� ����
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
