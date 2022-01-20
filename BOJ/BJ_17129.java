package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17129 {
	static int n,m,res=0;
	static boolean isOk;
	static int[][] map;
	static boolean[][] visited;
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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		int x=0,y=0;
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j)-'0';
				if(str.charAt(j)-'0'==2) {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(new Pos(x,y,0));
		
		StringBuilder sb = new StringBuilder();
		if(isOk)
			sb.append("TAK\n").append(res);
		else
			sb.append("NIE");
		
		System.out.println(sb);

	}
	
	static void bfs(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		visited[p.x][p.y] = true;
		while(!q.isEmpty()) {
			Pos t = q.poll();
			int x = t.x;
			int y = t.y;
			int dis = t.dis;
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]!=1) {
					if(map[nx][ny]!=0) {
						isOk = true;
						res = dis+1;
						return;
					}
					q.add(new Pos(nx,ny,dis+1));
					visited[nx][ny] = true;
				}
			}
			
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}

}
