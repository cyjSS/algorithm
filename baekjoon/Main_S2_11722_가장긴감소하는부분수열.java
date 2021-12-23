package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S2_11722_가장긴감소하는부분수열 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		
		int map[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int LIS[] = new int[N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if(map[i]<map[j]) LIS[i] = Math.max(LIS[i], LIS[j]+1);
			}
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);
	}
	static String src = "6\r\n" + 
			"10 30 10 20 20 10";
}
