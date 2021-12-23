package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S2_4963 {
	static int R,C;
	static int map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0,-1,-1,1,1}, dc[]= {0,0,-1,1,-1,1,-1,1};
	static int Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(R==0 && C==0) break;
			
			map = new int[C][R];
			visited = new boolean[C][R];
			Ans = 0;
			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < R; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) Ans++;
				}
			}
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
					if(map[i][j]==1) dfs(i,j);
				}
			}
			System.out.println(Ans);
		}
		
		
		
	}
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>-1 && nr<C && nc>-1 && nc<R) {
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					dfs(nr,nc);
					Ans--;
				}
			}
		}
		
	}
	static String src = "1 1\r\n" + 
			"0\r\n" + 
			"2 2\r\n" + 
			"0 1\r\n" + 
			"1 0\r\n" + 
			"3 2\r\n" + 
			"1 1 1\r\n" + 
			"1 1 1\r\n" + 
			"5 4\r\n" + 
			"1 0 1 0 0\r\n" + 
			"1 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 0 1 0\r\n" + 
			"5 4\r\n" + 
			"1 1 1 0 1\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 1 0 1\r\n" + 
			"1 0 1 1 1\r\n" + 
			"5 5\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 0";
}
