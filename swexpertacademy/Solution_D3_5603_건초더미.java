package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_D3_5603_건초더미 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			
			int matrix[] = new int[N];
			int sum=0;
			for (int i = 0; i < N; i++) {
				matrix[i] = Integer.parseInt(br.readLine());
				sum += matrix[i];
			}
			int Ans =0;
			for (int i = 0; i < N; i++) {
				if(matrix[i]>sum/N) {
					Ans += matrix[i]-sum/N;
				}
			}
			System.out.println("#"+test+" "+Ans);
		}
		
	}
	static String src = 
			"1\r\n" + 
			"4\r\n" + 
			"2\r\n" + 
			"10\r\n" + 
			"7\r\n" + 
			"1";
}
