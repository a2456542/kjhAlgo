package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1339 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//boolean[] check = new boolean[26];
		//int[] num = new int[26];
		Integer[] w = new Integer[26];
		Arrays.fill(w, 0);
		//Queue<Character>[] q = new Queue[10];
		//for(int i=0;i<10;i++) q[i] = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			int len = tmp.length();
			for(int j=0;j<len;j++) {
				//q[len-j].add(tmp.charAt(j));
				w[tmp.charAt(j)-'A'] += (int)Math.pow(10, len-j-1);
			}
		}
		
		
		Arrays.sort(w,Collections.reverseOrder());
		System.out.println(Arrays.toString(w));
		
		int cnt = 9;
		int res = 0;
		for(int i=0;i<26;i++) {
			res += w[i]*cnt;
			cnt--;
		}
//		for(int i=9;i>=0;i--) {
//			while(!q[i].isEmpty()) {
//				if(!check[q[i].peek()-'A']) {
//					char tmp = q[i].poll();
//					check[tmp-'A'] = true;
//					num[tmp-'A'] = cnt;
//					res += (cnt*Math.pow(10, i-1));
//					cnt--;
//				}
//				else {
//					char tmp = q[i].poll();
//					res += (num[tmp-'A']*Math.pow(10, i-1));
//				}
//			}
//		}

		StringBuilder sb = new StringBuilder();
		sb.append(res);
		System.out.println(sb);

	}

}
