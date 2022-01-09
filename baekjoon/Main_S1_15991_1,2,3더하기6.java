package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S1_15991 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[100001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		for(int i = 7; i <= 100000; i++) 
			dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1000000009;
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
        
	}
	static String src = "10\r\n" + 
			"1001\r\n" + 
			"500\r\n" + 
			"1003\r\n" + 
			"1004\r\n" + 
			"1005\r\n" + 
			"1006\r\n" + 
			"1007\r\n" + 
			"1008\r\n" + 
			"1009\r\n" + 
			"1010";
}
