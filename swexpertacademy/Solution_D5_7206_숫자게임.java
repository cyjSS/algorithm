package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * 교수님 코드 보기 => 못품
 * @author cyj
 *
 */
public class Solution_D5_7206_숫자게임 {
	static int start,n;
	static int memo[];
	static boolean numbers[];
	static int ans;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		memo = new int[100000];
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			start = Integer.parseInt(br.readLine());
			numbers = new boolean[100];
			
			ans =0;
			if(memo[start]!=0) ans = memo[start];
			else {
				int len = (int)(Math.log10(start)+1);
				subset(0,start,len,0);
				memo[start] = ans;
			}
				
			
			System.out.println("#"+test+" "+ans);
		}
	}
	private static void subset(int cnt, int num, int lenN, int turn) {
		if(lenN==1) {
			ans = Math.max(ans, turn);
			return;
		}
		if(memo[num]!=0) {
			ans = Math.max(ans, turn+memo[num]);
			return;
		}
		if(cnt==lenN-1) {
			N = num;
			int result =1;
			int piece[] = new int[lenN];
			int idx =0;
			for (int i = cnt-1; i >= 0; i--) {
				if(numbers[i]) {
					piece[idx] = N/(int)Math.pow(10,(i+1));
					N %= (int)Math.pow(10,(i+1));
					idx++;
				}
			}
			piece[idx]=N;
			for (int i = 0; i < lenN; i++) {
				if(piece[i]!=0) result *= piece[i]; 
			}
			N = result;
			if(N==num) return;
//			numbers = new boolean[100];
			subset(0, N, (int)(Math.log10(N)+1),turn+1);
			return;
		}
		numbers[cnt] = false;
		subset(cnt+1, num, lenN, turn);
		numbers[cnt] = true;
		subset(cnt+1, num, lenN, turn);
	}
	static String src = "1\r\n" + 
			"99999";
}
