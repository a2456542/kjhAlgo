package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1759 {
	static int L,C,jaOk;
	static char[] arr;
	static boolean[] visited;
	static boolean moOk;
	static char[] mo = {'a','e','i','o','u'};
	static char[] ja = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
	static List<String> res = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		visited = new boolean[C];
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		comb(0,C,L);
	}
	
	static void comb(int idx, int n, int r) {
		if(r==0) {
			moOk = false;
			jaOk = 0;
			res.clear();
			for(int i=0;i<n;i++) {
				if(visited[i])
					res.add(Character.toString(arr[i]));
			}
			for(String i: res) {
				for(int j=0;j<mo.length;j++) {
					if(i.equals(Character.toString(mo[j])))
						moOk = true;
				}
				for(int k=0;k<ja.length;k++) {
					if(i.equals(Character.toString(ja[k])))
						jaOk++;
				}
			}
			if(moOk && jaOk>=2) {
				for(String i:res) {
					System.out.print(i);
				}
				System.out.println();
				return;
			}
			else
				return;	
		}
		if(idx==n)
			return;
		
		visited[idx] = true;
		comb(idx+1,n,r-1);
		visited[idx] = false;
		comb(idx+1,n,r);
	}

}
