package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18404 {
	static int N,M,cnt;
	static int[][] map,res;
	static boolean[][] visited;
	static class Pos{
		int x,y,num;
		public Pos(int x,int y,int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	static Queue<Pos> q = new LinkedList<>();
	static int[][] dir = {{-2,1},{-1,2},{2,1},{1,2},{2,-1},{1,-2},{-2,-1},{-1,-2}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		res = new int[N][N];
		visited = new boolean[N][N];
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken())-1;
		int startY = Integer.parseInt(st.nextToken())-1;
		int[][] arr = new int[M][2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 1;
			arr[i][0] = x-1;
			arr[i][1] = y-1;
		}
		bfs(new Pos(startX,startY,0));

		for(int i=0;i<M;i++) {
			sb.append(res[arr[i][0]][arr[i][1]]).append(" ");
		}
		
		System.out.println(sb);

	}
	
	static void bfs(Pos p) {
		q.clear();
		visited[p.x][p.y] = true; 
		q.add(p);

		while(!q.isEmpty()) {
			Pos t = q.poll();
			int x = t.x;
			int y = t.y;
			
			for(int i=0;i<8;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny]) {
					q.add(new Pos(nx,ny,t.num+1));
					visited[nx][ny] = true;
					res[nx][ny] = t.num+1;
				}
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}

}
