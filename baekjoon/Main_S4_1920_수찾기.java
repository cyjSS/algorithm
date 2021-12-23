package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1920_최영진 {

	static int N,M;
	static int arr[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(binary(0, N-1, Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.println(sb);
	}
	private static int binary(int start, int end, int game) {
		int mid = (start+end)>>1;
		if(start>end) {
			return 0;
		}
		if(arr[mid]==game) {
			return 1;
		}
		if(arr[mid]>game) {
			end = mid-1;
			return binary(start,end,game);
		}
		else {
			start = mid+1;
			return binary(start,end,game);
		}
		
		
	}
	static String src = "5\r\n" + 
			"4 1 5 2 3\r\n" + 
			"5\r\n" + 
			"1 3 7 9 5";

}
