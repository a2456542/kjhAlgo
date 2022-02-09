package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		String N = br.readLine();
		for(int i=0;i<N.length();i++) {
			arr[N.charAt(i)-'0']++;
		}
		System.out.println(Arrays.toString(arr));
		if((arr[6]+arr[9])%2==1)
			arr[6] = (arr[6]+arr[9])/2+1;
		else
			arr[6] = (arr[6]+arr[9])/2;
		
		int max = 0;
		for(int i=0;i<=8;i++) {
			max = Math.max(arr[i], max);
		}
		
		System.out.println(Arrays.toString(arr));
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		System.out.println(sb);

	}

}
