package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10986_누적합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] nam = new long[M];
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			sum += Integer.parseInt(st.nextToken());
			sum %= M;
			nam[(int) sum]++;
		}
		
		long res = 0;
		for(int i=0;i<M;i++) {
			res += ((nam[i])*(nam[i]-1))/2;
		}
		res += nam[0];
		System.out.println(res);
	}

}
