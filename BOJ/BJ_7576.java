package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {
	static class Pos{
		int x,y;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int M,N,day;
	static int[][] box;
	static boolean[][] visited;
	static Queue<Pos> q = new LinkedList<>();
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visited = new boolean[N][M];
		boolean check = false;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1)
					q.add(new Pos(j,i));
				if(box[i][j]==0) {
					check = true;
				}
			}
		}
		if(!check) {
			sb.append(0);
			System.out.println(sb);
			return;
		}
		day = 0;
		bfs();
		int max = 0;
		outer:for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j]==0) {
					max = 0;
					break outer;
				}	
				max = Math.max(max, box[i][j]);
			}
		}
		
		sb.append(max-1);
		System.out.println(sb);
	}

	static void bfs() {
		while(!q.isEmpty()) {
			Pos a = q.poll();
			visited[a.y][a.x]= true; 
			int x = a.x;
			int y = a.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && box[ny][nx]==0 && !visited[ny][nx]) {
					q.add(new Pos(nx,ny));
					visited[ny][nx] = true;
					box[ny][nx] = box[y][x]+1;
				}
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
}
