package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S3_15651 {
	static int N,M;
	static int input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[M];
		
		permutation(0);
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		if(cnt==M) {
			for(int j : input) sb.append(j+" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			input[cnt] = i;
			permutation(cnt+1);
		}
	}
	static String src = "3 3";
}
