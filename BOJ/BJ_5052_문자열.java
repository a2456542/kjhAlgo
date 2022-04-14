package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_5052_문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		outer:for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			String[] phone = new String[n];
			for(int i=0;i<n;i++) {
				phone[i] = br.readLine();
			}
			Arrays.sort(phone);
			for(int j=0;j<n-1;j++) {
				if(phone[j].charAt(0)==phone[j+1].charAt(0) && phone[j+1].startsWith(phone[j])) {
					sb.append("NO\n");
					continue outer;
				}
			}
			sb.append("YES\n");
		}
		System.out.println(sb);

	}

}
