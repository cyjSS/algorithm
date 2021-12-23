package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B3_5612_최영진 {

	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];
		arr[0] = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		if(arr[0]>=0) System.out.println(arr[N]);
		else System.out.println(0);
		
	}
	static String src = "3\r\n" + 
			"2\r\n" + 
			"2 3\r\n" + 
			"2 3\r\n" + 
			"1 0";
}
