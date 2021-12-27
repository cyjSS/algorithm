package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_5일차Magnetic {

	static int N;
	static int matrix[][];
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/Magnetic.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test = 1; test <= 10; test++) {
			N = Integer.parseInt(br.readLine());
			
			matrix = new int [N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sum=0;
			for (int i = 0; i < N; i++) {
				int pre = matrix[0][i];
				int bottle =0;
				for (int j = 1; j < N; j++) {
					int cur = matrix[j][i];
					if(cur==0) {
						continue;
					}
					if(pre==1&&cur==2) {
						bottle++;
					}
					pre = cur;
				}
				sum+=bottle;
			}
			
			System.out.println("#"+test+" "+sum);
			
		}
		
	}

}
