package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_10157 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Find = Integer.parseInt(br.readLine());
		if(Find>R*C) {
			System.out.println(0);
			return;
		}
		int map[][] = new int[R][C];
		int dr[] = {-1,0,1,0}, dc[] = {0,1,0,-1};
		int r = R-1; int c = 0;
		int cnt = 1; int idx = 0;
		int printR = R; int printC = C;
		while(cnt!=Find) {
			map[r][c] = cnt;
			int nr = r+dr[idx];
			int nc = c+dc[idx];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc]!=0) {
				idx++;
				if(idx==4) idx = 0;
				nr = r+dr[idx];
				nc = c+dc[idx];
			}
			r= nr;
			c = nc;
			cnt++;
		}
		System.out.println((c+1)+" "+(printR-r));
//		for (int[] i : map) {
//			for (int j : i) {
//				System.out.print(j+" ");
//			}System.out.println();
//		}
//		System.out.println(Arrays.deepToString(map));
//		for (int i = 0; i < printR; i++) {
//			for (int j = 0; j < printC; j++) {
//				if(map[i][j]==Find) System.out.println((j+1)+" "+(printR-i));
//			}
//		}

	}
	static String src = "100 100\r\n" + 
			"3000";
}
