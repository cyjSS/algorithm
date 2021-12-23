package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_2437_저울 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int map[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		int max = 0;
		for (int i = 0; i < N; i++) {
			if(map[i]<=max+1) max += map[i];
			else break;
		}

		System.out.println(max+1);
	}
	static String src = "4\r\n" + 
			"1 1 3 5";
}
