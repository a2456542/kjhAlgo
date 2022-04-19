package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.charAt(0)-'0'==0) {
			System.out.println(0);
			return;
		}
		long[] dp = new long[str.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=str.length();i++) {
			if(str.charAt(i-1)-'0'==0) {
				if(str.charAt(i-2)-'0'==1 || str.charAt(i-2)-'0'==2) {
					dp[i] = dp[i-2]%1000000;
				}
				else {
					System.out.println(0);
					return;
				}
			}
			else {
				if(str.charAt(i-2)-'0'==0) {
					dp[i] = dp[i-1]%1000000;
				}
				else {
					int tmp = (str.charAt(i-2)-'0')*10 + (str.charAt(i-1)-'0');
					if(tmp<=26)
						dp[i] = (dp[i-1]+dp[i-2])%1000000;
					else
						dp[i] = dp[i-1]%1000000;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dp[str.length()]);
		System.out.println(sb);
		
	}

}
