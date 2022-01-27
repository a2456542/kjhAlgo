package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N+M;i++) {
			if(i==N)
				st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}

}
