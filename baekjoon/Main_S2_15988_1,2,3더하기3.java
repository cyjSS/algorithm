package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S2_15988_최영진 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= 1000000; i++) 
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
        
        
	}
	static String src = "3\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"10";
}
