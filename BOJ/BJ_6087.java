package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6087 {
	static class Pos{
		int x,y,dir,cnt;
		public Pos(int x,int y,int dir,int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0 && x<H && y>=0 && y<W;
	}
	static int W,H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		char[][] map = new char[H][W];
		//boolean[][] visited = new boolean[H][W];
		int[][] mirror = new int[H][W];
		for(int i=0;i<H;i++)
			Arrays.fill(mirror[i], -1);
		int[] start = {-1,-1};
		int[] end = new int[2];
		for(int i=0;i<H;i++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			for(int j=0;j<W;j++) {
				map[i][j] = c[j];
				if(c[j]=='C') {
					if(start[0]==-1) {
						start[0] = i;
						start[1] = j;
					}
					else {
						end[0] = i;
						end[1] = j;
					}
				}
			}
		}
		
		Queue<Pos> q = new LinkedList<>();
		for(int i=0;i<4;i++) {
			q.add(new Pos(start[0],start[1],i,0));
		}
		//visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
//			if(p.x==end[0] && p.y==end[1])
//				break;
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dir[i][0];
				int ny = p.y+dir[i][1];
				if(isIn(nx,ny)) {
					if(map[nx][ny]=='.' || map[nx][ny]=='C') {
						int cnt = p.cnt;
						if(p.dir!=i)
							cnt++;
						
						if(mirror[nx][ny]==-1) {
							mirror[nx][ny] = cnt;
							q.add(new Pos(nx,ny,i,cnt));
						}
						else if(mirror[nx][ny]>=cnt) {
							mirror[nx][ny] = cnt;
							q.add(new Pos(nx,ny,i,cnt));
						}
					}
				}
			}
		}
		for(int i=0;i<H;i++) {
			System.out.println(Arrays.toString(mirror[i]));
		}
		StringBuilder sb = new StringBuilder();
		sb.append(mirror[end[0]][end[1]]);
		System.out.println(sb);

	}
}
