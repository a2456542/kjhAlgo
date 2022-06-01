package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1012_유기농배추_DFS {
	static int M,N,K,cnt;
	static int[][] farm;
	static boolean[][] visited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			farm = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[y][x] = 1;
			}
			cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
						if(!visited[i][j] && farm[i][j]==1) {
							DFS(i,j);
							cnt++;
						}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}
	
	static void DFS(int y,int x) {
		visited[y][x] = true;
		for(int i=0;i<4;i++) {
			int nx = x+dir[i][0];
			int ny = y+dir[i][1];
			if(isIn(ny,nx)) {
				if(farm[ny][nx]==1 && !visited[ny][nx])
					DFS(ny,nx);
			}
		}
	}
	
	static boolean isIn(int y,int x) {
		return x>=0 && x<M && y>=0 && y<N;
	}

}
