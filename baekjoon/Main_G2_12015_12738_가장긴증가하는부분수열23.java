package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G2_12015_12738_가장긴증가하는부분수열23 {
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
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, map[i]);
			if(temp<0) temp = temp*-1-1;
			
			LIS[temp] = map[i];
			
			if(temp==size) ++size;
		}
		
		System.out.println(size);
//		System.out.println(Arrays.toString(LIS));
		
	}
	static String src = "6\r\n" + 
			"10 20 10 30 20 50";
}
