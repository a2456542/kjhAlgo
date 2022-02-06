package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[N+1];
		int[] pSum = new int[N+1];
		
		for(int i=0;i<B;i++) {
			arr[Integer.parseInt(br.readLine())] = true;
		}

		for(int i=1;i<=N;i++) {
			pSum[i] = arr[i]?pSum[i-1]+1:pSum[i-1];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=K;i<=N;i++) {
			int n = pSum[i]-pSum[i-K];
			min = Math.min(n, min);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(min);
		System.out.println(min);
	}

}
