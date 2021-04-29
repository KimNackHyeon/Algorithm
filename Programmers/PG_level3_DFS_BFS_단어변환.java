package test;

import java.util.LinkedList;
import java.util.Queue;

public class PG_level3_DFS_BFS_단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
//		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] words = { "hot", "dot", "dog", "lot", "log" };

		solution(begin, target, words);
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (check(begin, words[i])) {
				bfs(i, words, target);
			}
		}
		answer = ans;
		if(answer == Integer.MAX_VALUE){
            return 0;
        }
		return answer;
	}

	static int ans;

	private static void bfs(int i, String[] words, String target) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visit = new boolean[words.length];

		q.add(new int[] { i, 1 });
		visit[i] = true;

		while (!q.isEmpty()) {
			int wordIdx = q.peek()[0];
			int cnt = q.peek()[1];

			q.poll();
			if (words[wordIdx].equals(target)) {
				ans = Math.min(ans, cnt);
				break;
			}

			for (int j = 0; j < words.length; j++) {
				if (!visit[j] && check(words[wordIdx], words[j])) {
					q.add(new int[] { j, cnt + 1 });
					visit[j] = true;
				}
			}
		}

	}

	private static boolean check(String begin, String word) {
		int cnt = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != word.charAt(i)) {
				cnt++;
			}
		}
		if (cnt == 1) {
			return true;
		} else {
			return false;
		}

	}
}
