package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] val = new int[n+1];
		for(int i=1;i<=n;i++)
			val[i] = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = val[1];
		if(n>=2)
			dp[2] = dp[1]+val[2];
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-3]+val[i-1], dp[i-2])+val[i];
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[n]);
		System.out.println(sb);

	}

}
