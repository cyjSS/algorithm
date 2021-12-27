package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_D2_2005_파스칼의삼각형 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if(i-1>=0 && j-1>=0) {
						map[i][j] = map[i-1][j-1]+map[i-1][j];
					}else map[i][j] = 1;
				}
			}
			System.out.println("#"+test);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==0) continue;
					System.out.print(map[i][j]+" ");
				}System.out.println();
			}
		}
		
	}
	static String src = "10\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"6\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"9\r\n" + 
			"10";
}
