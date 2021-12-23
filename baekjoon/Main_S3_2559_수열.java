package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S3_2559 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int map[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += map[i];
		}
		int Ans = sum;
		for (int i = 1; i <= N-K; i++) {
			int temp = map[i+K-1] - map[i-1];
			sum +=temp;
			Ans = Math.max(Ans, sum);
		}
		
		
		System.out.println(Ans);
	
	}
	static String src = "10 5\r\n" + 
			"3 -2 -4 -9 0 3 7 13 8 -3";
}
