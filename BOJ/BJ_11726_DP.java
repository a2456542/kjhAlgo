package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=N;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[N]%10007);
		System.out.println(sb);
	}

}