package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1748 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = (int)(Math.log10(N)+1);
		long sum = 0;
		int idx = 1;
		while(true) {
			sum += (Math.pow(10, idx)-Math.pow(10, idx-1))*idx;
			if(idx==len) {
				sum -= (Math.pow(10, idx)-N)*idx;
				break;
			}
			idx++;
		}
		sum+=idx;
		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		System.out.println(sb);
		

	}

}
