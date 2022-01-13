package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300 {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] info = new int[2][7];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			info[S][Y]++;
		}
		int res = 0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<7;j++) {
				if(info[i][j]!=0) {
					if(info[i][j]%K!=0)
						res += (info[i][j]/K)+1;
					else
						res += (info[i][j]/K);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(res);
		System.out.println(sb);
	}

}
