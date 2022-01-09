package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S1_1992 {

	static int N;
	static int matrix[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				matrix[i][j] = str.charAt(j)-48;
			}
		}
		quadTree(matrix);
		System.out.println(sb);
	}
	private static boolean isAvailable(int[][] inputs) {
		int R = inputs.length;
		int temp = inputs[0][0];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < R; j++) {
				if(inputs[i][j]!=temp) return false;
			}
		}
		return true;
	}
	
	private static void quadTree(int[][] inputs) {
		if(isAvailable(inputs)) {
			sb.append(inputs[0][0]);
			return;
		}
		else {
			sb.append('(');
			int R = inputs.length/2;
			int recur[][]=new int[R][R];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					recur[i][j]=inputs[i][j];
				}
			}
			quadTree(recur);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					recur[i][j]=inputs[i][j+R];
				}
			}
			quadTree(recur);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					recur[i][j]=inputs[i+R][j];
				}
			}
			quadTree(recur);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					recur[i][j]=inputs[i+R][j+R];
				}
			}
			quadTree(recur);
			sb.append(')');
			
		}
	}

	static String src="8\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"00011100\r\n" + 
			"00011100\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"11110011\r\n" + 
			"11110011";

}
