package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_18405_경쟁적전염_구현 {
	static int N,K;
	static int[][] map;
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
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<S;i++) {
			for(int j=1;j<=K;j++) {
				BFS(j);
				if(map[X-1][Y-1]!=0) {
					System.out.println(map[X-1][Y-1]);
					return;
				}
			}
		}
		System.out.println(map[X-1][Y-1]);

	}
	
	static void BFS(int n) {
		Queue<Pos> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==n) {
					q.add(new Pos(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(isIn(nx,ny) && map[nx][ny]==0) {
					map[nx][ny] = n;
				}
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}

}
