package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_16935_최영진 {

	static int N,M,R;
	static int matrix[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < R; k++) {
			int num = Integer.parseInt(st.nextToken());
			switch(num) {
			case 1:
				function1();
				break;
			case 2:
				function2();
				break;
			case 3:
				function3();
				break;
			case 4:
				function4();
				break;
			case 5:
				function5();
				break;
			case 6:
				function6();
				break;
			}
		}
		for (int[] map : matrix) {
			for (int m : map) {
				System.out.print(m+" ");
			}
			System.out.println();
		}
	}
	private static void function6() {
		int temp[][]=new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j]=matrix[i][j];
				matrix[i][j]=matrix[i][j+M/2];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				matrix[i][j]=matrix[i+N/2][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				matrix[i][j]=matrix[i][j-M/2];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				matrix[i][j]=temp[i-N/2][j];
			}
		}
	}
	private static void function5() {
		int temp[][]=new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				temp[i][j]=matrix[i][j];
				matrix[i][j]=matrix[i+N/2][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				matrix[i][j]=matrix[i][j+M/2];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				matrix[i][j]=matrix[i-N/2][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				matrix[i][j]=temp[i][j-M/2];
			}
		}
	}
	private static void function4() {
		int change[][]=new int[M][N];
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				change[j][i]=matrix[i][M-1-j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		matrix=change;
//		System.out.println(Arrays.deepToString(change));
	}
	private static void function3() {
		int change[][]=new int[M][N];
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				change[j][i]=matrix[N-1-i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		matrix=change;
//		System.out.println(Arrays.deepToString(change));
	}
	private static void function2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][M-1-j];
				matrix[i][M-1-j] = temp;
			}
		}
	}
	private static void function1() {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N-1-i][j];
				matrix[N-1-i][j] = temp;
			}
		}
		
	}
	static String src = "6 8 6\r\n" + 
			"3 2 6 3 1 2 9 7\r\n" + 
			"9 7 8 2 1 4 5 3\r\n" + 
			"5 9 2 1 9 6 1 8\r\n" + 
			"2 1 3 8 6 3 9 2\r\n" + 
			"1 3 2 8 7 9 2 1\r\n" + 
			"4 5 1 9 8 2 1 3\r\n" + 
			"1 2 3 4 5 6";

}
