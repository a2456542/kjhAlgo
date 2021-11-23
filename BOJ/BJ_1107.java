package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cur = 100;
		List<Integer> li = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		if(M!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				li.add(Integer.parseInt(st.nextToken()));
			}
		}
		String[] sArr = String.valueOf(N).split("");
		int[] arr = new int[sArr.length];
		for(int i=0;i<sArr.length;i++) {
			arr[i] = Integer.parseInt(sArr[i]);
		}
	
		for(int i=0;i<sArr.length;i++) {
			if(li.contains(arr[i])) {
				int up = arr[i], down = arr[i];
				boolean isUp = true, isDown = true;
				
				while(li.contains(up)) {
					up++;
					if(up>9) {
						isUp = false;
						break;
					}
				}
				
				while(li.contains(down)) {
					down--;
					if(down<0) {
						isDown = false;
						break;
					}
				}
				
				if(isUp && isDown) {
					if(Math.abs(arr[i]-up)>Math.abs(arr[i]-down))
						arr[i] = down;
					else
						arr[i] = up;
				}
				else if(!isUp && isDown)
					arr[i] = down;
				else if(isUp && !isDown)
					arr[i] = up;
			}
		}
		
		String Sr = "";
		int tmp;
		for(int i=0;i<sArr.length;i++) {
			Sr += String.valueOf(arr[i]);
		}
		tmp = Integer.parseInt(Sr);
		int res = 0;
		if(tmp!=0)
			res = Math.min(Math.abs(cur-tmp), Math.abs(tmp-N)+(int)(Math.log10(tmp)+1));
		else
			res = Math.min(cur, N+1);
		
		if(N==100)
			res = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(res);
		System.out.println(sb);
		System.out.println(tmp);
	}

}
