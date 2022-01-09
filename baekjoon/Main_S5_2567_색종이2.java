package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_2567 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int map[][] =  new int[100][100];
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken())-1;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[r+j][c+k] = 1;
				}
			}
		}
		
		int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1) {
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr<100 && nc>=0 && nc<100 && map[nr][nc]==0) cnt++;
						else if(nr<0 || nr>=100 || nc<0 || nc>=100) cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	static String src = "4\r\n" + 
			"3 7\r\n" + 
			"5 2\r\n" + 
			"15 7\r\n" + 
			"13 14";
}
