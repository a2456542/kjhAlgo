package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589 {
	static int W,H,max = 0;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Pos> q = new LinkedList<>();
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static class Pos{
		int x,y,dis;
		public Pos(int x,int y,int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new boolean[H][W];
		for(int i=0;i<H;i++) {
			String str = br.readLine();
			for(int j=0;j<W;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(map[i][j]=='L') {
					bfs(new Pos(i,j,0));
				}
			}
		}
		
		System.out.println(max);

	}
	
	static void bfs(Pos p) {
		for(int i=0;i<H;i++)
			Arrays.fill(visited[i], false);
		
		visited[p.x][p.y] = true; 
		q.add(p);
		
		while(!q.isEmpty()) {
			Pos t = q.poll();
			int x = t.x;
			int y = t.y;
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]=='L') {
					visited[nx][ny] = true;
					q.add(new Pos(nx,ny,t.dis+1));
					max = Math.max(max, t.dis+1);
				}
			}
		}
		
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<H&&y>=0&&y<W;
	}

}
