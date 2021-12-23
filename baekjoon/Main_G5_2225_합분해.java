package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2225_합분해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = 1000000000;
		
		long dp[][] = new long[201][201];
		Arrays.fill(dp[0], 1);
		for (int i = 0; i < 201; i++) {
			dp[i][1] = 1;
			dp[i][2] = i+1;
		}
		if(K>=3) {
			for (int n = 1; n < N+1; n++) {
				for (int i = 3; i < K+1; i++) {
					for (int j = 0; j < n+1; j++) {
						dp[n][i] = (dp[n][i] + (dp[j][i-2]*(n-j+1))%P) %P;
					}
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
	static String src = "6 4";
}
