package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		dp[0] = arr[0]; 
		int answer = dp[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);

	}

}
