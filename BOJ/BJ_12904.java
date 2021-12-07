package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12904 {
	static String S,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		S = br.readLine();
		T = br.readLine();
		StringBuffer tmp;
		while(T.length()>S.length()) {
			if(T.charAt(T.length()-1)=='A') {
				T = T.substring(0,T.length()-1);
			}
			else if(T.charAt(T.length()-1)=='B') {
				T = T.substring(0,T.length()-1);
				tmp = new StringBuffer(T);
				T = tmp.reverse().toString();
			}
		}
		StringBuilder sb = new StringBuilder();
		if(S.equals(T))
			sb.append(1);
		else
			sb.append(0);
		System.out.println(sb);
	}
}
