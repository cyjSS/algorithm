package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_1974_스도쿠검증 {

	static int T,count;
	static char matrix[][];
	static int ans,arr[],arr1[],arr2[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			ans=0;
			matrix = new char[9][];
			for (int i = 0; i < 9; i++) {
				matrix[i]=(br.readLine().replace(" ", "").toCharArray());
			}
			count=0; ans=0;
			for (int i = 0; i < 9; i++) {
				arr = new int[9];
				arr1 = new int[9];
				arr2 = new int[9];
				for (int j = 0; j < 9; j++) {
					if( matrix[i][j]>=49 && matrix[i][j]<=57 ) {
						arr[matrix[i][j]-49]=1;
					}
					if( matrix[j][i]>=49 && matrix[j][i]<=57 ) {
						arr1[matrix[j][i]-49]=1;
					}
					if( i%3==0 && j%3==0 ) {
						for (int k = 0; k < 3; k++) {
							if( matrix[i][j+k]>=49 && matrix[i][j+k]<=57 ) {
							arr2[matrix[i][j+k]-49]=1;
							}
							if( matrix[i+1][j+k]>=49 && matrix[i+1][j+k]<=57 ) {
							arr2[matrix[i+1][j+k]-49]=1;
							}
							if( matrix[i+2][j+k]>=49 && matrix[i+2][j+k]<=57 ) {
							arr2[matrix[i+2][j+k]-49]=1;
							}
						}
						for (int p = 0; p < 9; p++) {
							if( arr2[i]==1 ) ans++;
						}
					}
				}
				for (int i1 = 0; i1 < 9; i1++) {
					if( arr[i1]==1&& arr1[i1]==1 ) {
						count++;
					}
				}
			}
			System.out.print("#"+test_case+" ");
			if(count==81&& ans==81) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}
