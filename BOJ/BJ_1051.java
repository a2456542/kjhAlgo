package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1051 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		int max = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int n=j+1;n<M;n++) {
					if(map[i][j]==map[i][n]) {
						if(i+n-j<N && map[i][j]==map[i+(n-j)][j]) {
							if(map[i][j]==map[i+(n-j)][n]) {
								max = Math.max(max, (n-j+1)*(n-j+1));
							}
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		System.out.println(sb);

	}
}
