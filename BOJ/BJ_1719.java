package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		int[][] arr = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = c;
			arr[b][a] = c;
		}
		
		int[] D = new int[N+1];
		Arrays.fill(D, INF);
		boolean[] visited = new boolean[N+1];
		D[1] = 0;
		
		for(int i=0;i<N;i++) {
			int min = INF, cur = 0;
			for(int j=1;j<=N;j++) {
				if(!visited[j] && D[j]<min) {
					min = D[j];
					cur = j;
				}
			}
			visited[cur] = true;
			for(int j=1;j<=N;j++) {
				if(!visited[j] && arr[cur][j]!=0 && D[j]>min+arr[cur][j]) {
					D[j] = min+arr[cur][j];
				}
			}
		}

		for(int i=1;i<=N;i++) {
			System.out.print(D[i]+" ");
		}
		
	}

}
