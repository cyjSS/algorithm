package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {
	static int T,N,M;
	static int numbers[];
	static int inputs[];
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			numbers = new int[2];
			inputs = new int[N+1];
			ans=0;
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				inputs[i]=Integer.parseInt(st1.nextToken());
			}
			combination(0,1);
			if(ans!=0) {
				System.out.println("#"+test_case+" "+ans);
			}else {
				System.out.println("#"+test_case+" "+-1);
			}
		}
	}
	private static void combination(int cnt, int start) {
		if(cnt==2) {
			int sum=0;
			for (int i = 0; i < 2; i++) {
				sum += numbers[i];
			}if(sum <= M) {
				ans = Math.max(ans,sum);
			}
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = inputs[i];
			combination(cnt+1,i+1);
		}
	}
}
