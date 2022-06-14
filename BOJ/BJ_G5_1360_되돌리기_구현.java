package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_G5_1360_되돌리기_구현 {
	static class State{
		String cur;
		int time;
		public State(String cur, int time) {
			this.cur = cur;
			this.time = time;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<State> li = new ArrayList<>();
		li.add(new State("",0));
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("type")) {
				String add = li.get(i).cur + st.nextToken();
				int time = Integer.parseInt(st.nextToken());
				li.add(new State(add,time));
			}
			else {
				int back = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				int target = time-back-1;
				if(target<0) {
					li.add(new State("",time));
					continue;
				}
				for(int j=i;j>=0;j--) {
					if(li.get(j).time<=target) {
						li.add(new State(li.get(j).cur,time));
						break;
					}
				}
			}
		}

		System.out.println(li.get(N).cur);

	}

}
