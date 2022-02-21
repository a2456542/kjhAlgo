package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055 {
	static int R,C,cnt;
	static char[][] map;
	static int[][] res;
	static int[] D;
	static boolean[][] visited;
	static boolean isEnd;
	static Queue<Pos> wq = new LinkedList<>();
	static Queue<Pos> sq = new LinkedList<>();
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		res = new int[R][C];
		visited = new boolean[R][C];
		D = new int[2];
		for(int i=0;i<R;i++) {
			String tmp = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = tmp.charAt(j);
				if(tmp.charAt(j)=='D') {
					D[0] = i;
					D[1] = j;
				}
				else if(tmp.charAt(j)=='S')
					sq.add(new Pos(i,j));
				else if(tmp.charAt(j)=='*') {
					wq.add(new Pos(i,j));
				}
			}
		}
		cnt = 0;
		solve();
		
		StringBuilder sb = new StringBuilder();
		if(isEnd)
			sb.append("KAKTUS");
		else
			sb.append(cnt);
		System.out.println(sb);
		
	}

	static void solve() {
		outer:while(!sq.isEmpty()) {	
//			for(int c=0;c<4;c++) {
//				if(isIn(D[0]+dir[c][0],D[1]+dir[c][1]) && map[D[0]+dir[c][0]][D[1]+dir[c][1]]=='.')
//					break;
//				isEnd = true;
//				break outer;
//			}
			for(int w=0;w<wq.size();w++) {
				Pos p = wq.remove();
				int wx = p.x;
				int wy = p.y;
				for(int i=0;i<4;i++) {
					int nx = wx+dir[i][0];
					int ny = wy+dir[i][1];
					if(isIn(nx,ny)) {
						if(map[nx][ny]=='.') {
							map[nx][ny] = '*';
							wq.add(new Pos(nx,ny));
						}
					}
				}
			}
			
			Pos s = sq.remove();
			int sx = s.x;
			int sy = s.y;
			visited[sx][sy] = true;
			for(int i=0;i<4;i++) {
				int nx = sx+dir[i][0];
				int ny = sy+dir[i][1];
				if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]=='.') {
					sq.add(new Pos(nx,ny));
					res[nx][ny] = res[sx][sy]+1;
				}
				else if(nx==D[0] && ny==D[1]) {
					cnt = res[sx][sy]+1;
					break outer;
				}
			}
		}
	}
	
	static boolean isIn(int x,int y) {
		return x>=0 && x<R && y>=0 && y<C;
	}
}	
