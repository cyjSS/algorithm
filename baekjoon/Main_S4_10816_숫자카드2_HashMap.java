package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_10816_최영진_HashMap {

	static int N,M,cnt;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		HashMap<Integer, Integer> map = new HashMap<>();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			map.put(temp, map.getOrDefault(temp,0)+1);
//			System.out.println(map);
			
		}
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(temp, 0)).append(" ");
		}
		System.out.println(sb);
		
	}
	

	static String src = "10\r\n" + 
			"6 3 2 10 10 10 -10 -10 7 3\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
}
