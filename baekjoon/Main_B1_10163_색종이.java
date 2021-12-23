package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B1_10163_최영진 {

	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		int matrix[][] = new int[1001][1001];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = x; j < x+r; j++) {
				for (int k = y; k < y+c; k++) {
					matrix[j][k]=i+1;
				}
			}
		}
		int Ans[] = new int[N];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				for (int k = 1; k <= N; k++) {
					if(matrix[i][j]==k) {
						Ans[k-1]++;
					}
				}
			}
		}
		
		for (int i : Ans) {
			System.out.println(i);
		}
		
	}
	static String src = "4\r\n" + 
			"0 2 10 10\r\n" + 
			"7 9 8 4\r\n" + 
			"8 4 10 6\r\n" + 
			"6 0 12 10";
}
