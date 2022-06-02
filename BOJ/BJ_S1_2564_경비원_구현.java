package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원_구현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] store = new int[N][2];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			store[n][0] = Integer.parseInt(st.nextToken());
			store[n][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dDir = Integer.parseInt(st.nextToken());
		int dPos = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			if(dDir<=2) {
				if(store[i][0]<=2) {
					if(dDir==store[i][0]) {
						sum += Math.abs(dPos-store[i][1]);
					}
					else {
						if(dPos+store[i][1]<(W-dPos)+(W-store[i][1])) {
							sum += dPos+store[i][1]+H;
						}
						else {
							sum += (W-dPos)+(W-store[i][1])+H;
						}
					}
				}
				else {
					if(dDir==1) {
						if(store[i][0]==3)
							sum += dPos+store[i][1];
						else
							sum += (W-dPos)+store[i][1];
					}
					else {
						if(store[i][0]==3)
							sum += dPos+(H-store[i][1]);
						else
							sum += (W-dPos)+(H-store[i][1]);
					}
				}
			}
			else {
				if(store[i][0]>2) {
					if(dDir==store[i][0]) {
						sum += Math.abs(dPos-store[i][1]);
					}
					else {
						if(dPos+store[i][1]<(H-dPos)+(H-store[i][1])) {
							sum += dPos+store[i][1]+W;
						}
						else {
							sum += (W-dPos)+(W-store[i][1])+W;
						}
					}
				}
				else {
					if(dDir==3) {
						if(store[i][0]==1)
							sum += dPos+store[i][1];
						else
							sum += (H-dPos)+store[i][1];
					}
					else {
						if(store[i][0]==1)
							sum += dPos+(W-store[i][1]);
						else
							sum += (H-dPos)+(W-store[i][1]);
					}
				}
			}
		}
		System.out.println(sum);
	}

}
