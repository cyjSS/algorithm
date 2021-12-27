package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N=Integer.parseInt(br.readLine());
	
			int [][]arr=new int [N][N];
			int cnt=1;
			int minus=0;//배열 안쪽으로 진입
			while(cnt<=N*N) {
				//위 오른쪽은 작->큰
				for (int i = minus; i <N-minus ; i++) {
					arr[minus][i]=cnt++;
				}//위
				for (int i = 1+minus; i < N-minus; i++) {
					arr[i][N-1-minus]=cnt++;
				}//오른쪽
				//아래 왼쪽은 큰->작
				for (int i = N-2-minus; i >= minus; i--) {
					arr[N-1-minus][i]=cnt++;
				}//아래
				for (int i = N-2-minus; i > minus; i--) {
					arr[i][minus]=cnt++;
				}//왼쪽
				minus=minus+1;
			}
			System.out.println("#"+test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}	
	}
}
