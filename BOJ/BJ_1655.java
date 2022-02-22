package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(left.size()==right.size()) {
				left.add(n);
				if(!right.isEmpty() && left.peek()>right.peek()) {
					left.add(right.poll());
					right.add(left.poll());
				}
			}
			else {
				right.add(n);
				if(left.peek()>right.peek()) {
					left.add(right.poll());
					right.add(left.poll());
				}
			}

			sb.append(left.peek()+"\n");
		}
		
		System.out.println(sb);
	}

}
