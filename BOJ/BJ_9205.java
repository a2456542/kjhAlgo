package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205 {
	static int n,sX,sY,eX,eY;
	static int[][] cuList;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n+2];
			cuList = new int[n+2][2];
			
			st = new StringTokenizer(br.readLine());
			sX = Integer.parseInt(st.nextToken());
			sY = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<=n;i++) {
				st = new StringTokenizer(br.readLine());
				cuList[i][0] = Integer.parseInt(st.nextToken());
				cuList[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			eX = Integer.parseInt(st.nextToken());
			eY = Integer.parseInt(st.nextToken());
			cuList[n+1][0] = eX;
			cuList[n+1][1] = eY;
			
			StringBuilder sb = new StringBuilder();
			sb.append(bfs());
			System.out.println(sb);
		}
	}
	
	static String bfs() {
	      Queue<int[]> q = new LinkedList<>();
	      q.add(new int[] {sX, sY});
	      while(!q.isEmpty()) {
	         int[] cur = q.poll();
	         int x = cur[0];
	         int y = cur[1];
	         if(x==eX && y==eY) 
	        	 return "happy";
	         
	         for(int i = 1; i <= n+1; i++) {
	            int nx = cuList[i][0]; 
	            int ny = cuList[i][1];
	            if(!visited[i] && (Math.abs(x-nx)+Math.abs(y-ny))<=1000) {
	               q.add(new int[] {nx, ny});
	               visited[i] = true;
	            }
	         }
	      }
	      return "sad";
	   }

}
