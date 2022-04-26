package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_BFS {
	static int[][] map;
	static boolean[][] visited;
	static int N,min;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static Queue<Pos> q = new LinkedList<>();
	static class Pos{
		int x,y,cnt;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
		public Pos(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		numberingIslands();
		bfs();
		System.out.println(min);
	}
	
	static void numberingIslands() {
		int num = 2;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j]==1) {
					q.clear();
					map[i][j] = num;
					visited[i][j] = true;
					q.add(new Pos(i,j));
					while(!q.isEmpty()) {
						Pos p = q.poll();
						int x = p.x;
						int y = p.y;
						for(int d=0;d<4;d++) {
							int nx = x+dir[d][0];
							int ny = y+dir[d][1];
							if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]==1) {
								q.add(new Pos(nx,ny));
								map[nx][ny] = num;
								visited[nx][ny] = true;
							}
						}
					}
					num++;
				}
			}
		}
	}
	
	static void bfs() {
		int num = -1;
		for(int i=0;i<N;i++) {
			outer:for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					num = map[i][j];
					for(int d=0;d<N;d++)
						Arrays.fill(visited[d], false);
					q.clear();
					visited[i][j] = true;
					q.add(new Pos(i,j,0));
					while(!q.isEmpty()) {
						Pos p = q.poll();
						int x = p.x;
						int y = p.y;
						int cnt = p.cnt;
						for(int d=0;d<4;d++) {
							int nx = x+dir[d][0];
							int ny = y+dir[d][1];
							if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]!=num) {
								if(map[nx][ny]==0) {
									visited[nx][ny] = true;
									q.add(new Pos(nx,ny,cnt+1));
								}
								else {
									min = Math.min(min, cnt);
									continue outer;
								}
							}
						}
					}
				}	
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}

}
