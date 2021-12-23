package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_1010_최영진 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int D[][] = new int[M+1][N+1];
			
			for (int i = 0; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(i==0 || i==j) D[j][i] = 1;
					else D[j][i] = D[j-1][i-1] + D[j-1][i];
				}
			}
//			System.out.println(Arrays.deepToString(D));
			System.out.println(D[M][N]);
		}
		
	}
	static String src = "3\r\n" + 
			"2 2\r\n" + 
			"1 5\r\n" + 
			"13 29";
}	
