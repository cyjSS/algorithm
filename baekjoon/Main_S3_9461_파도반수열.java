package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S3_9461_최영진 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			long D[] = new long[101];
			D[1] = 1; 
			D[2] = 1; 
			D[3] = 2; 
			D[4] = 2; 
			D[5] = 3; 
			for (int i = 1; i < N; i++) {
				if(i>=6) D[i] = D[i-5]+D[i-1];
			}
			if(N==1) System.out.println(1);
			else System.out.println(D[N-1]);
		}
		
	}
	static String src = "2\r\n" + 
			"6\r\n" + 
			"12";
}
