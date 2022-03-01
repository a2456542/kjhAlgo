package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_22252 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long sum = 0;
		HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if(n==1) {	
				int k = Integer.parseInt(st.nextToken());
				if(map.containsKey(name)) {
					for(int j=0;j<k;j++) {
						map.get(name).add(Integer.parseInt(st.nextToken()));
					}
				}
				else {
					PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
					for(int j=0;j<k;j++)
						q.add(Integer.parseInt(st.nextToken()));
					
					map.put(name, q);
				}
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				if(map.containsKey(name)) {
					int tmp = 0;
					while(!map.get(name).isEmpty() && tmp<b) {
						sum += map.get(name).poll();
						tmp++;
					}
				}
			}	
		}
		
		System.out.println(sum);

	}

}
