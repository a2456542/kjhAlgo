package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10026 {
	static int N,w,nw;
	static char[][] map;
	static boolean[][] wmap;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		wmap = new boolean[N][N];
		visited = new boolean[N][N];
		w = nw = 0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
				if(str.charAt(j)=='B')
					wmap[i][j] = true;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					DFS(i,j);
					nw++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					wDFS(i,j);
					w++;
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(nw).append(" ").append(w);
		System.out.println(sb);
	}
	
	static void DFS(int a, int b) {
		visited[a][b] = true;
		
		for(int i=0;i<4;i++) {
			int na = a+dir[i][0];
			int nb = b+dir[i][1];
			
			if(isIn(na,nb)) {
				if(map[na][nb]==map[a][b] && !visited[na][nb])
					DFS(na,nb);
			}
		}
	}
	
	static void wDFS(int a, int b) {
		visited[a][b] = true;
		
		for(int i=0;i<4;i++) {
			int na = a+dir[i][0];
			int nb = b+dir[i][1];
			
			if(isIn(na,nb)) {
				if(wmap[na][nb]==wmap[a][b] && !visited[na][nb])
					wDFS(na,nb);
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}

}
