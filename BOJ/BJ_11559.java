package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_11559 {
	static int W = 6,H = 12,res = 0;
	static char[][] board;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static class Pos{
		int x,y;
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[H][W];
		visited = new boolean[H][W];
		for(int i=0;i<H;i++) {
			String tmp = br.readLine();
			for(int j=0;j<W;j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		play();
		
		StringBuilder sb = new StringBuilder();
		sb.append(res);
		System.out.println(sb);
	}
	
	static void play() {
		boolean isEnd = false;

		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(board[i][j]!='.' && !visited[i][j]) {
					if(!remove(i,j))
						isEnd = true;
				}
			}
		}
		if(!isEnd) return;
		gravity();
		res++;
		play();
	}
	
	static boolean remove(int x,int y) {
		Queue<Pos> q = new LinkedList<>();
		List<Pos> li = new ArrayList<>();
		q.add(new Pos(x,y));
		li.add(new Pos(x,y));
		int cnt = 1;
		visited[x][y] = true;
		char color = board[x][y];
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+dir[i][0];
				int ny = p.y+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && board[nx][ny]==color) {
					visited[nx][ny] = true;
					q.add(new Pos(nx,ny));
					li.add(new Pos(nx,ny));
					cnt++;
				}
			}
		}
		if(cnt>=4) {
			for(int i=0;i<li.size();i++) {
				board[li.get(i).x][li.get(i).y] = '.';
			}
			return false;
		}
		return true;
	}
	
	static boolean isIn(int x,int y) {
		return x>=0&&x<H&&y>=0&&y<W;
	}
	
	static void gravity() {
		for(int i=0;i<H;i++) {
			Arrays.fill(visited[i], false);
		}
		for(int j=0;j<W;j++) {
			boolean isDrop = false;
			for(int i=H-1;i>=0;i--) {
				if(board[i][j]=='.') {
					isDrop = true;
					break;
				}
			}
			
			if(!isDrop) continue;
			
			int drop = -1;
			for(int i=H-1;i>=0;i--) {
				if(board[i][j]=='.' && drop==-1)
					drop = i;
				else if(board[i][j]!='.' && drop!=-1) {
					char tmp = board[i][j];
					board[i][j] = board[drop][j];
					board[drop][j] = tmp;
					drop--;
				}
			}
			
			
		}
	}

}
