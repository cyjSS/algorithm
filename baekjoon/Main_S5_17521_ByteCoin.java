package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_17521_최영진 {

	static long arr[];
	static long coin;
	static int n;
	static long W;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		W = Long.parseLong(st.nextToken());
		
		arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		if(n==1) {
			System.out.println(W);
			return;
		}
		
		coin = 0;
		if(arr[0]<arr[1]) {
			coin = W/arr[0];
			W %= arr[0];
			findHigh(1);
		}else {
			findLow(0);
		}
		System.out.println(W);
		
	}
	private static void findHigh(int start) {
		for (int i = start; i < n-1; i++) {
			if(i+1<n&&arr[i]>arr[i+1]) {
				W += arr[i]*coin;
				coin = 0;
				findLow(i);
				return;
			}
		}
		W += arr[n-1]*coin;
		
	}
	private static void findLow(int start) {
		for (int i = start; i < n-1; i++) {
			if(i+1<n&&arr[i]<arr[i+1]) {
				coin = W/arr[i];
				W %= arr[i];
				findHigh(i);
				return;
			}
		}
		W += arr[n-1]*coin;
	}
	static String src = "10 24\r\n" + 
			"5\r\n" + 
			"7\r\n" + 
			"5\r\n" + 
			"4\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"5\r\n" + 
			"3\r\n" + 
			"4";
}
