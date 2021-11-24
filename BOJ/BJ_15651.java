package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15651 {
	static int N,M;
	static int[] arr,res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		res = new int[M];
		for(int i=1;i<=N;i++) {
			arr[i] = i;
		}
		solve(0);
		System.out.println(sb);
	}

	static void solve(int r) {
		if(r==M) {
			for(int i=0;i<M;i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			res[r] = arr[i];
			solve(r+1);
		}
	}
}
