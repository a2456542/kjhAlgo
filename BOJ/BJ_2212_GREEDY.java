package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2212_GREEDY {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		if(N<K) {
			System.out.println(0);
			return;
		}
		int[] sen = new int[N];
		int[] gap = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			sen[i] = Integer.parseInt(st.nextToken());	
		Arrays.sort(sen);
		
		for(int i=0;i<N-1;i++) {
			gap[i] = sen[i+1]-sen[i];
		}
		Arrays.sort(gap);

		int sum = 0;
		for(int i=0;i<N-1-(K-1);i++) {
			sum += gap[i];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		System.out.println(sb);
	}

}
