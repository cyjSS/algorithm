package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S3_15652 {
	static int N,M;
	static int input[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[M];
		combination(0,1);

	}
	private static void combination(int cnt, int start) {
		if(cnt==M) {
			for(int j : input) System.out.print(j+" ");
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			input[cnt] = i;
			combination(cnt+1, i);
		}
		
	}
	static String src = "3 3";
}
