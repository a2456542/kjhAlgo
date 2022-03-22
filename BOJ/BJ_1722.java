package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1722 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] fac = new long[21];
		fac[0] = 1;
		fac[1] = 1;
		for(int i=2;i<=20;i++)
			fac[i] = fac[i-1]*i;
		System.out.println(Arrays.toString(fac));
		int num = Integer.parseInt(st.nextToken());
		if(num==1) {
			long k = Long.parseLong(st.nextToken());
			int[] res = new int[N+1];
			boolean[] visited = new boolean[N+1];
			int idx = 1;
			while(idx<=N) {
				for(int i=1;i<=N;i++) {
					if(!visited[i]) {
						if(k-fac[N-idx]>0) {
							k -= fac[N-idx];
							continue;
						}
						else {
							res[idx] = i;
							idx++;
							visited[i] = true;	
							break;
						}
					}
				}
			}
			for(int i=1;i<=N;i++){
				sb.append(res[i]+" ");
			}
		}
		else {
			int[] input = new int[N+1];
			long res = 1;
			boolean[] visited = new boolean[N+1];
			for(int i=1;i<=N;i++)
				input[i] = Integer.parseInt(st.nextToken());
			for(int i=1;i<=N;i++) {
				for(int j=1;j<input[i];j++) {
					if(!visited[j])
						res += fac[N-i];
				}
				visited[input[i]] = true;
			}
			sb.append(res);
		}
		
		System.out.println(sb);

	}

}
