package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;	

public class Solution_test_2112_보호필름 {
	static int D,W,K;
	static boolean map[][], reset[][];
	static boolean numbers[];
	static int change[];
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[D][W];
			reset = new boolean[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp==0) reset[i][j] = true;
					else reset[i][j] = false;
				}
			}
			copy();
			if(check()) {
				System.out.println("#"+test+" "+0);
				continue;
			}
			if(K==1) {
				System.out.println("#"+test+" "+0);
				continue;
			}
			ans =Integer.MAX_VALUE;
			numbers = new boolean[D];
			subset(0);
			System.out.println("#"+test+" "+ans);
		}
	}
	private static void perm(int cnt, int total) {
		if(cnt==total) {
			int j=0;
			for (int i = 0; i < D; i++) {
				if(numbers[i]) {
					if(change[j]==0) {
						for (int k = 0; k < W; k++) {
							map[i][k] = true;
						}
					}else {
						for (int k = 0; k < W; k++) {
							map[i][k] = false;
						}
					}
					j++;
				}
			}
			if(check()) {
				ans = Math.min(ans, total);
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			change[cnt] = i;
			perm(cnt+1,total);
		}
	}
	private static void subset(int cnt) {
		if(cnt==D) {
			copy();
			int count=0;
			for (int i = 0; i < D; i++) {
				if(numbers[i]) count++;
			}
			if(count>K || count>=ans) return;
			change = new int[count];
			perm(0,count);
			return;
		}
		numbers[cnt] = true;
		subset(cnt+1);
		numbers[cnt] = false;
		subset(cnt+1);
	}
	
	private static void copy() {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				if(reset[i][j]) map[i][j] = true;
				else map[i][j] = false;
			}
		}
	}
	private static boolean check() {
		for (int i = 0; i < W; i++) {
			int cnt =0; int cntA =0; int cntB =0;
			for (int j = 0; j < D; j++) {
				if(map[j][i]) {
					cntA++;
					cntB=0;
				}else {
					cntB++;
					cntA=0;
				}
				cnt=Math.max(cnt, Math.max(cntA, cntB));
			}
			if(cnt<K) return false;
		}
		return true;
	}
	static String src = "2\r\n" + 
			"6 8 3\r\n" + 
			"0 0 1 0 1 0 0 1\r\n" + 
			"0 1 0 0 0 1 1 1\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"1 1 1 1 0 0 0 1\r\n" + 
			"0 1 1 0 1 0 0 1\r\n" + 
			"1 0 1 0 1 1 0 1\r\n" + 
			"6 8 3\r\n" + 
			"1 1 1 1 0 0 1 0\r\n" + 
			"0 0 1 1 0 1 0 1\r\n" + 
			"1 1 1 1 0 0 1 0\r\n" + 
			"1 1 1 0 0 1 1 0\r\n" + 
			"1 1 0 1 1 1 1 0\r\n" + 
			"1 1 1 0 0 1 1 0";
}
