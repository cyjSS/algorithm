package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {
	static int T;
	static int N;
	static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			size=Integer.parseInt(st.nextToken());
			int [][]matrix = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					matrix[i][j]=Integer.parseInt(st1.nextToken());
				}
			}
			
			int ans=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(isAvailable(i,j,size)) {
						int sum=0;
						for (int k = 0; k < size; k++) {
							for (int l = 0; l < size; l++) {
								sum+=matrix[i+k][j+l];
							}
						}
						ans=Math.max(ans, sum);
					}
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static boolean isAvailable(int i, int j, int size) {
		return i+size<=N && j+size<=N;
	}
	

}
