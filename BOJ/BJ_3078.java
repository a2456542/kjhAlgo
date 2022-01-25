package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3078 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer>[] q = new Queue[21];
		for(int i=0;i<=20;i++)
			q[i] = new LinkedList<Integer>();
		
		long cnt = 0;
		for(int i=1;i<=N;i++) {
			int len = br.readLine().length();
			if(q[len].isEmpty())
				q[len].add(i);
			else {
				while(i-q[len].peek()>K) {
					q[len].poll();
					if(q[len].isEmpty())
						break;
				}
				
				cnt+=q[len].size();
				q[len].add(i);
			}
		}
	
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		System.out.println(sb);

	}

}
