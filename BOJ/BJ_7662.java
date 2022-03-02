package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			map.clear();
			for(int j=0;j<k;j++) {
				st = new StringTokenizer(br.readLine());
				String calc = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(calc.equals("I")) {
					map.put(num, map.getOrDefault(num, 0)+1);
				}
				else {
					if(map.size()!=0) {
						if(num==1) {
							if(map.get(map.lastKey())==1)
								map.remove(map.lastKey());
							else {
								map.put(map.lastKey(), map.get(map.lastKey())-1);
							}
						}
						else {
							if(map.get(map.firstKey())==1)
								map.remove(map.firstKey());
							else {
								map.put(map.firstKey(), map.get(map.firstKey())-1);
							}
						}
					}
				}	
			}
			if(map.size()==0)
				sb.append("EMPTY\n");
			else {
				sb.append(map.lastKey()+" "+map.firstKey()+"\n");
			}
		}
		
		System.out.println(sb);

	}

}
