package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2156_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++)
			wine[i] = Integer.parseInt(br.readLine());
		dp[1] = wine[1];
		if(n>=2) dp[2] = wine[1]+wine[2];
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+wine[i-1], dp[i-2])+wine[i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[n]);
		System.out.println(sb);
	}

}
