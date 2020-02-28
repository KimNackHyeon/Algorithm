package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_D3_5948_새샘이의735게임 {
	static int[] nums;
	static int[] temp;
	static TreeSet<Integer> tree;
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = in.readLine();
			StringTokenizer st = new StringTokenizer(input);
			nums = new int[7];

			int idx = 0;
			while (st.hasMoreTokens()) {
				nums[idx++] = Integer.parseInt(st.nextToken());
			}
			
			temp = new int[3];
			tree = new TreeSet<>();
			sum = 0;
			Combi(0, 0);
			Object[] result = tree.toArray();
			System.out.println("#" + test_case + " " + result[tree.size()-5]);
		}

	}

	public static void Combi(int start, int count) {
		if (count == 3) {
			for (int i : temp) {
				sum += i;
			}
			tree.add(sum);
			sum = 0;
			return;
		}
		for (int i = start; i < nums.length; i++) {
			temp[count] = nums[i];
			Combi(i + 1, count + 1);
		}
	}

}
