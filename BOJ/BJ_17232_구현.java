package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17232_구현 {
	static int N,M,T,K,a,b;
	static char[][] map;
	static int[][] sumArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map = new char[N+1][M+1];
		sumArr = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=1;j<=M;j++) {
				map[i][j] = tmp[j-1];
			}
		}
		
		play();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void play() {
		while(T>0) {
			find();
			update();
			T--;
		}
		finalUpdate();
	}
	
	static void finalUpdate() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j]=='L')
					map[i][j] = '*';
			}
		}
	}
	
	static void update() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j]=='D')
					map[i][j] = '.';
				else if(map[i][j]=='B')
					map[i][j] = '*';
			}
		}
	}
	
	static void checkSum() {
		for(int i=1;i<=N;i++) {
			Arrays.fill(sumArr[i], 0);
		}
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=1;j<=M;j++) {
				if(map[i][j]=='*' || map[i][j]=='L')
					sum++;
				sumArr[i][j] = sum;
			}
		}
		
		for(int i=1;i<=M;i++) {
			int sum = 0;
			for(int j=2;j<=N;j++) {
				sumArr[j][i] = sumArr[j-1][i]+sumArr[j][i];
			}
		}
	}
	
	static void find() {
		checkSum();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j]=='*' || map[i][j]=='L' || map[i][j]=='D') {
					checkLive(i,j);
				}
				else {
					checkDead(i,j);
				}
			}
		}
	}
	
	static void checkLive(int x,int y) {	
		int px = Math.min(x+K, N);
		int mx = Math.max(x-K-1, 0);
		int py = Math.min(y+K, M);
		int my = Math.max(y-K-1, 0);
		int n = sumArr[px][py]-sumArr[mx][py]-sumArr[px][my]+sumArr[mx][my]-1;
		if(n>=a && n<=b) {
			map[x][y] = 'L';
		}
		else if(n<a) {
			map[x][y] = 'D';
		}
		else if(n>b) {
			map[x][y] = 'D';
		}
	}
	
	static void checkDead(int x,int y) {
		int px = Math.min(x+K, N);
		int mx = Math.max(x-K-1, 0);
		int py = Math.min(y+K, M);
		int my = Math.max(y-K-1, 0);
		int n = sumArr[px][py]-sumArr[mx][py]-sumArr[px][my]+sumArr[mx][my];
		if(n>a && n<=b) {
			map[x][y] = 'B';
		}
	}
}
