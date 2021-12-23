package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_11399_최영진 {

	static int N;
	static int matrix[];
	static int sum, Ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		sum=0;
		Arrays.sort(matrix);
		for (int i = 0; i < N; i++) {
			sum+=matrix[i]*(N-i);
		}
		
		System.out.println(sum);
	}
	
	static String src = "5\r\n" + 
			"3 1 4 3 2";
}
