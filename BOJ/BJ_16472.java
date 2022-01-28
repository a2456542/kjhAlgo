package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_16472 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		if(c.length==1) { //길이가 1이면 어짜피 1
			System.out.println(1);
			return;
		}
		int[] alpArr = new int[26]; //알파벳 카운트
		int start = 0;
		alpArr[c[start]-'a']++; //시작지점 미리 더해줌
		int cnt = 1; //서로 다른 알파벳 갯수
		int max = 0;
		for(int i=1;i<c.length;i++) { //2번째 알파벳부터 검사
			if(alpArr[c[i]-'a']==0) { //없는 알파벳 등장
				if(cnt<N) { //카운트 여유 있으면 1더하고 넘어감
					alpArr[c[i]-'a']++;
					cnt++;	
				}
				else { //여유 없으면
					alpArr[c[i]-'a']++;
					int n = start;
					while(true) { //여유 있어질때까지 시작지점 더해줌
						alpArr[c[n]-'a']--;
						n++;
						int tmp = 0;
						for(int j=0;j<26;j++) { //카운트 검사
							if(alpArr[j]!=0)
								tmp++;
						}
						if(tmp<=N)
							break;
					}
					start = n;
				}
				max = Math.max(max, i-start+1);
			}
			else {
				alpArr[c[i]-'a']++;
				max = Math.max(max, i-start+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max);
		System.out.println(sb);

	}

}
