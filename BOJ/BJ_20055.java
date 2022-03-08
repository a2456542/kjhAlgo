package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20055 {
	static int N,K,cnt=1;
	static int[] belt;
	static boolean[] robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[N*2];
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N*2;i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		play();
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		System.out.println(sb);

	}
	
	static void play() {
		while(true) {
			turn();
			move();
			putRobot();
			if(checkEnd())
				break;
			cnt++;
		}
	}
	
	static void turn() {
		int tmp = belt[(N*2)-1];
		for(int i=(N*2)-1;i>0;i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = tmp;
		
		for(int i=N-1;i>0;i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = false;
	}
	
	static void move() {
		if(robot[N-1])
			robot[N-1] = false; //맨끝 로봇 내리기
		for(int i=N-2;i>0;i--) {
			if(robot[i] && !robot[i+1] && belt[i+1]>0) { //i칸로봇 있고 앞칸 로봇 없고 내구도 남아있으면
				robot[i] = false;
				robot[i+1] = true;
				belt[i+1]--;	
			}
		}
	}
	
	static void putRobot() {
		if(belt[0]>0) {
			robot[0] = true;
			belt[0]--;
		}
	}
	
	static boolean checkEnd() {
		int cnt = 0;
		for(int i=0;i<N*2;i++) {
			if(belt[i]==0)
				cnt++;
		}
		
		return (cnt>=K)?true:false;
	}

}
