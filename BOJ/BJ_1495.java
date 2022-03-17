package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1495 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] vol = new int[N+1];
		boolean[][] volNum = new boolean[N+1][M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			vol[i] = Integer.parseInt(st.nextToken());
		}
		boolean isOk = false;
		volNum[0][S] = true;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=M;j++) {
				if(volNum[i-1][j]) {
					if(j+vol[i]<=M)
						volNum[i][j+vol[i]] = true;
					if(j-vol[i]>=0)
						volNum[i][j-vol[i]] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M;i>=0;i--) {
			if(volNum[N][i]) {
				sb.append(i);
				isOk = true;
				break;
			}
		}
		
		if(isOk)
			System.out.println(sb);
		else
			System.out.println(-1);

	}

}
