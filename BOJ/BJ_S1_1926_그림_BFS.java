package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1926_그림_BFS {
	static int[][] map;
	static boolean[][] visited;
	static int n,m,cnt,max;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static class Pos{
		int x,y;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && map[i][j]==1) {
					cnt++;
					BFS(new Pos(i,j));
				}
			}
		}
		System.out.println(cnt+"\n"+max);
	}
	
	static void BFS(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		visited[p.x][p.y] = true;
		q.add(p);
		int area = 0;
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			int x = t.x;
			int y = t.y;
			area++;
			
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				
				if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					q.add(new Pos(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
		max = Math.max(max, area);
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<n&&y>=0&&y<m;
	}

}
