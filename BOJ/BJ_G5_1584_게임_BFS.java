package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_G5_1584_게임_BFS {
	static int N,M;
	static int[][] map = new int[501][501];
	static int[][] cost = new int[501][501];
	static boolean[][] visited = new boolean[501][501];
	static class Pos{
		int x,y;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int xMin = Math.min(x1, x2);
			int xMax = Math.max(x1, x2);
			int yMin = Math.min(y1, y2);
			int yMax = Math.max(y1, y2);
			for(int i=xMin;i<=xMax;i++) {
				for(int j=yMin;j<=yMax;j++) {
					if(map[i][j]!=2) {
						map[i][j] = 1;
					}
				}
			}
		}
		M = Integer.parseInt(br.readLine());
		for(int n=0;n<M;n++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int xMin = Math.min(x1, x2);
			int xMax = Math.max(x1, x2);
			int yMin = Math.min(y1, y2);
			int yMax = Math.max(y1, y2);
			for(int i=xMin;i<=xMax;i++) {
				for(int j=yMin;j<=yMax;j++) {
					map[i][j] = 2;
				}
			}
		}
		BFS(new Pos(0,0));
		if(visited[500][500]) {
			System.out.println(cost[500][500]);
		}
		else {
			System.out.println(-1);
		}
	}
	
	static void BFS(Pos p) {
		Deque<Pos> dq = new LinkedList<>();
		dq.addFirst(p);
		visited[p.x][p.y] = true; 
		while(!dq.isEmpty()) {
			Pos t = dq.pollFirst();
			int x = t.x;
			int y = t.y;
			if(x==500 && y==500) {
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]!=2) {
					if(map[nx][ny]==0) {
						dq.addFirst(new Pos(nx,ny));
						cost[nx][ny] = cost[x][y];
					}
					else {
						dq.addLast(new Pos(nx,ny));
						cost[nx][ny] = cost[x][y]+1;
						
					}
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<=500&&y>=0&&y<=500;
	}

}
