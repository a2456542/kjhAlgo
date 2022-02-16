package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1038 {
	static int N,cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		int n = 0;
		if(N>1022) System.out.println("-1");
		else if(N==1022) System.out.println("9876543210");
		else {
			while(true) {
				if(cnt==N) break;
				String str = Integer.toString(n);
				int len = str.length();
				if(len>=3) {
					if(n<(len-1)*(int)Math.pow(10, len-1)) {
						n = (len-1)*(int)Math.pow(10, len-1);
						continue;
					}
				}
				if(isOk(n)) cnt++;
				n++;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(n);
			System.out.println(n);
		}
	}
	
	static boolean isOk(int n) {
		String str = Integer.toString(n);
		int len = str.length();
		int[] arr = new int[len];
		for(int i=0;i<len;i++) {
			arr[i] = str.charAt(i);
			if(i>0 && arr[i]>=arr[i-1])
				return false;
		}
		return true;
	}
}
