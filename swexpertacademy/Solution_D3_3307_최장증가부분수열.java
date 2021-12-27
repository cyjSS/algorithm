package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int LIS[] = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			System.out.println("#"+test+" "+max);
//			System.out.println(Arrays.toString(LIS));
		}
	}
	static String src = "2\r\n" + 
			"5\r\n" + 
			"1 3 2 5 4 \r\n" + 
			"6\r\n" + 
			"4 2 3 1 5 6";
}
