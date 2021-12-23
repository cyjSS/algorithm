package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_15686 {
	static int N,M,sum;
	static int matrix[][],comb[],numbers[];
	static ArrayList<XY> city1;
	static ArrayList<XY> city2;
	static int Answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][N];
		comb = new int[N*N];
		
		int index=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j]==2) M--;
				comb[index++]=matrix[i][j];
			}
		}
		M*=-1;
		numbers = new int[M];
		combination(0,0);
		System.out.println(Answer);
	}

	private static void combination(int cnt, int start) {
		if(M==0) {
			distance();
			return;
		}
		if(cnt==M) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(matrix[i][j]==9) {
						matrix[i][j]=2;
					}
				}
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(numbers[i]>N*j-1 && numbers[i]<(j+1)*N) {
					matrix[j][numbers[i]-N*j]=9;
					}
				}
			}
			distance();
			return;
		}
		for (int i = start; i < N*N; i++) {
			if(comb[i]!=2) continue;
			numbers[cnt] = i;
			combination(cnt+1,i+1);
		}
	}

	private static void distance() {
		city1 = new ArrayList<>();
		city2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j]==1) {
					city1.add(new XY(i,j));
				}if(matrix[i][j]==2) {
					city2.add(new XY(i,j));
				}
			}
		}
		sum = 0;
		for (XY go : city1) {
			int ans = Integer.MAX_VALUE;
			for (XY back : city2) {
				int dist = Math.abs(go.x-back.x)+Math.abs(go.y-back.y);
				ans = Math.min(ans, dist);
			}
			sum = sum+ans;
			if(sum>Answer) {
				return;
			}
		}
		Answer = Math.min(sum,Answer);
		
	}

	static class XY{
		int x;
		int y;
		public XY(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static String src = "5 3\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 2 0 1\r\n" + 
			"0 1 2 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";
}
