package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine()); // 정수의 개수
		PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min_pq = new PriorityQueue<>();
	

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(max_pq.size() == min_pq.size()) {
				max_pq.add(num);
			}else {
				min_pq.add(num);
			}
			
			if(!min_pq.isEmpty() && !max_pq.isEmpty()) {
				if(min_pq.peek() < max_pq.peek()) {
					int temp = min_pq.poll();
					min_pq.add(max_pq.poll());
					max_pq.add(temp);
				}
			}
			
			System.out.println(max_pq);
			System.out.println(min_pq);
			System.out.println(max_pq.peek());
			System.out.println(min_pq.peek());
			System.out.println();
			sb.append(max_pq.peek()).append("\n");
		}
		
		System.out.println(sb.toString());

	}
}
