package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_13398_연속합2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int dp[][] = new int[2][N];
		dp[0][0] = arr[0]; 
		dp[1][0] = arr[0];
		answer = Math.max(dp[0][0], dp[1][0]);
		if(N==1) {
			System.out.println(answer);
			return;
		}
		
		dp[0][1] = Math.max(dp[0][0]+arr[1], arr[1]);
		dp[1][1] = arr[1];
		answer = Math.max(answer, Math.max(dp[0][1], dp[1][1]));
		
		for (int i = 2; i < N; i++) {
			dp[0][i] = Math.max(arr[i], dp[0][i-1]+arr[i]);
			dp[1][i] = Math.max(dp[1][i-1]+arr[i], dp[0][i-2]+arr[i]);
			answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
		}

		System.out.println(answer);

	}

}
