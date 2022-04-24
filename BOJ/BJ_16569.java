package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16569 {
	static int[][] map;
	static int[][] vol;
	static boolean[][] visited;
	static int M,N,V,minTime,height;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static Queue<Pos> q = new LinkedList<>();
	static class Pos{
		int x,y,time;
		public Pos(int x,int y,int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		vol = new int[M+1][N+1];
		for(int i=1;i<=M;i++)
			Arrays.fill(vol[i], Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			vol[x][y] = Math.min(time, vol[x][y]);
			map[x][y] = -1;
			volcano(new Pos(x,y,time));
		}
		
		run(new Pos(startX,startY,0));
		
		StringBuilder sb = new StringBuilder();
		sb.append(height+" "+minTime);
		System.out.println(sb);

	}
	
	static void volcano(Pos p) {
		q.clear();
		visited = new boolean[M+1][N+1];
		visited[p.x][p.y] = true;
		q.add(p);
		while(!q.isEmpty()) {
			Pos t = q.poll();
			int x = t.x;
			int y = t.y;
			int time = t.time;
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && (time+1)<vol[nx][ny]) {
					q.add(new Pos(nx,ny,time+1));
					visited[nx][ny] = true;
					vol[nx][ny] = time+1;
				}
			}
		}
	}
	
	static void run(Pos p) {
		q.clear();
		visited = new boolean[M+1][N+1];
		visited[p.x][p.y] = true;
		minTime = 0;
		height = map[p.x][p.y];
		q.add(p);
		while(!q.isEmpty()) {
			Pos t = q.poll();
			int x = t.x;
			int y = t.y;
			int time = t.time;
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && (time+1)<vol[nx][ny] && map[nx][ny]!=-1) {
					q.add(new Pos(nx,ny,time+1));
					visited[nx][ny] = true;
					if(map[nx][ny]>height) {
						height = map[nx][ny];
						minTime = time+1;
					}
				}
			}
		}
	}

	static boolean isIn(int x,int y) {
		return x>0&&x<=M&&y>0&&y<=N;
	}
}
