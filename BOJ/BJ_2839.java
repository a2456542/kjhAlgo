package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839 {
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(true) {					
			if(N<0) {
				System.out.println(-1);
				break;
			}
			if(N%5==0) {
				cnt += N/5;
				StringBuilder sb = new StringBuilder();
				sb.append(cnt);
				System.out.println(cnt);
				break;
			}	
			N = N-3;
			cnt++;
		}
	}
}
