package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1743 {
	static int N,M,K,max,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		max = 1;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(!visited[i][j] && map[i][j]==1) {
					cnt = 0;
					dfs(i,j);
					max = Math.max(max, cnt);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		System.out.println(sb);

	}
	
	public static void dfs(int x,int y) {
		cnt++;
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x+dir[i][0];
			int ny = y+dir[i][1];
			
			if(isIn(nx,ny)) {
				if(!visited[nx][ny] && map[nx][ny]==1)
					dfs(nx,ny);
			}
		}
	}
	
	public static boolean isIn(int x,int y) {
		return x>0&&x<=N&&y>0&&y<=M;
	}

}
