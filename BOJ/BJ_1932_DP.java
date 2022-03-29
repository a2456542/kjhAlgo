package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1932_DP {
	static int n;
	static int[][] tri;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tri = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=n;i++)
			dp[n][i] = tri[n][i];
		
		for(int i=n-1;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1])+tri[i][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[1][1]);
		System.out.println(sb);
	}
}
