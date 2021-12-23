package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15654_최영진 {
	static int N,M;
	static int input[];
	static int numbers[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine()+" ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[M];
		st = new StringTokenizer(br.readLine()+" ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		permutation(0, 0);
		
	}
	private static void permutation(int cnt, int flag) {
		if(cnt==M) {
			for(int j : numbers) System.out.print(j+" ");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i)!=0) continue;
			numbers[cnt] = input[i];
			permutation(cnt+1, flag|1<<i);
		}
	}
	static String src = "3 1\r\n" + 
			"4 5 2";
}
