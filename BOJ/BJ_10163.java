package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163 {
	static int N;
	static int[][] map = new int[1001][1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] pos = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int n=0;n<a;n++) {
				for(int m=0;m<b;m++) {
					map[pos[0]+n][pos[1]+m] = i;
				}
			}
		}
		int[] res = new int[N+1];
		for(int i=0;i<1001;i++) {
			for(int j=0;j<1001;j++) {
				if(map[i][j]>=1) {
					res[map[i][j]]++;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(res[i]);
			System.out.println(sb);
		}

	}

}
