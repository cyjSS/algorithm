package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2563_최영진 {

	static int matrix[][];
	static int N,cnt,x,y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		matrix = new int[100][100];
		x=0;y=0;cnt=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(matrix[j][k]==1) continue;
					matrix[j][k]=1;
					++cnt;
				}	
			}
		}
		System.out.print(cnt);
	}
}
