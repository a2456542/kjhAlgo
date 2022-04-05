package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715_GREEDY {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<N;i++)
			q.add(Integer.parseInt(br.readLine()));
		int cnt = 0;
		while(q.size()>1) {
			int a = q.poll();
			int b = q.poll();
			cnt += (a+b);
			q.add(a+b);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		System.out.println(sb);

	}

}
