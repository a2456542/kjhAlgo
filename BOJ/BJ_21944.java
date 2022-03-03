package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_21944 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, TreeMap<Integer,Integer>> noAlgoMap = new TreeMap<>();
		TreeMap<Integer, TreeMap<Integer,TreeMap<Integer,Integer>>> algoMap = new TreeMap<>();
		Map<Integer, int[]> recQ = new HashMap<>();
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int[] arr = {L,G};
			recQ.put(P, arr);
			if(noAlgoMap.getOrDefault(L, null)==null) {
				TreeMap<Integer, Integer> q = new TreeMap<>();
				q.put(P, 1);
				noAlgoMap.put(L, q);//난이도 분류 트리맵 넣기		
			}
			else {
				noAlgoMap.get(L).put(P, 1);	
			}
			if(algoMap.getOrDefault(G, null)==null) {
				TreeMap<Integer, TreeMap<Integer,Integer>> p = new TreeMap<>();
				TreeMap<Integer, Integer> l = new TreeMap<>();
				l.put(P, 1);
				p.put(L, l);
				algoMap.put(G, p);//알고리즘 분류 트리맵 넣기
			}
			else {
				if(algoMap.get(G).getOrDefault(L, null)==null) {
					TreeMap<Integer, Integer> q = new TreeMap<>();
					q.put(P, 1);
					algoMap.get(G).put(L, q);
				}
				else {
					algoMap.get(G).get(L).put(P, 1);
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			String calc = st.nextToken();
			if(calc.equals("recommend")) {
				int G = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if(x==1) {
					sb.append(algoMap.get(G).lastEntry().getValue().lastKey()).append("\n");
				}
				else {
					sb.append(algoMap.get(G).firstEntry().getValue().firstKey()).append("\n");
				}
			}
			else if(calc.equals("recommend2")) {
				int x = Integer.parseInt(st.nextToken());
				if(x==1) {
					sb.append(noAlgoMap.lastEntry().getValue().lastKey()).append("\n");
				}
				else {
					sb.append(noAlgoMap.firstEntry().getValue().firstKey()).append("\n");
				}
			}
			else if(calc.equals("recommend3")) {
				int x = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				if(x==1) {
					int min = 0;
					for(Map.Entry<Integer,TreeMap<Integer,Integer>> entry : noAlgoMap.entrySet()) {
						int key = entry.getKey();
						if(key>=L) {
							min = entry.getValue().firstKey();
							break;
						}
					}
					if(min==0)
						sb.append(-1).append("\n");
					else
						sb.append(min).append("\n");
				}
				else {
					int max = 0;
					for(Map.Entry<Integer,TreeMap<Integer,Integer>> entry : noAlgoMap.entrySet()) {
						int key = entry.getKey();
						if(key>=L)
							break;
						max = entry.getValue().lastKey();	
					}
					if(max==0)
						sb.append(-1).append("\n");
					else
						sb.append(max).append("\n");
				}
			}
			else if(calc.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int[] arr = {L,G};
				recQ.put(P, arr);
				if(noAlgoMap.getOrDefault(L, null)==null) {
					TreeMap<Integer, Integer> q = new TreeMap<>();
					q.put(P, 1);
					noAlgoMap.put(L, q);//난이도 분류 트리맵 넣기		
				}
				else {
					noAlgoMap.get(L).put(P, 1);	
				}
				if(algoMap.getOrDefault(G, null)==null) {
					TreeMap<Integer, TreeMap<Integer,Integer>> p = new TreeMap<>();
					TreeMap<Integer, Integer> l = new TreeMap<>();
					l.put(P, 1);
					p.put(L, l);
					algoMap.put(G, p);//알고리즘 분류 트리맵 넣기
				}
				else {
					if(algoMap.get(G).getOrDefault(L, null)==null) {
						TreeMap<Integer, Integer> q = new TreeMap<>();
						q.put(P, 1);
						algoMap.get(G).put(L, q);
					}
					else {
						algoMap.get(G).get(L).put(P, 1);
					}
				}
			}
			else {
				int P = Integer.parseInt(st.nextToken());
				int[] tmp = recQ.get(P);
				algoMap.get(tmp[1]).get(tmp[0]).remove(P);
				if(algoMap.get(tmp[1]).get(tmp[0]).size()==0) {
					algoMap.get(tmp[1]).remove(tmp[0]);
					if(algoMap.get(tmp[1]).size()==0)
						algoMap.remove(tmp[1]);
				}
				noAlgoMap.get(tmp[0]).remove(P);
				if(noAlgoMap.get(tmp[0]).size()==0)
					noAlgoMap.remove(tmp[0]);
			}
		}

		System.out.println(sb);
	}

}
