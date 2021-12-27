package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_test_1949_등산로 {

	static int N,K;
	static int map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static int Ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean check = false;
					visited = new boolean[N][N];
					Ans = 0;
					if(map[i][j]==max) result = Math.max(result, dfs(i,j,map[i][j],1,check));
				}
			}
			
			System.out.println("#"+test+" "+result);
		}
		
	}
	private static int dfs(int r, int c, int cur, int cnt, boolean booK) {
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N &&!visited[nr][nc]) {
				if(map[nr][nc]<cur) {
					visited[nr][nc] = true;
					dfs(nr, nc, map[nr][nc], cnt+1, booK);
					visited[nr][nc] = false;
				}
				else if(!booK && map[nr][nc]-K<cur) {
					visited[nr][nc] = true;
					booK = true;
					dfs(nr,nc, cur-1, cnt+1, booK);
					booK = false;
					visited[nr][nc] = false;
				}
			}
		}
		Ans = Math.max(Ans, cnt);
		return Ans;
	}
	static String src =
			"2\r\n" + 
			"5 1\r\n" + 
			"9 3 2 3 2\r\n" + 
			"6 3 1 7 5\r\n" + 
			"3 4 8 9 9\r\n" + 
			"2 3 7 7 7\r\n" + 
			"7 6 5 5 8\r\n" + 
			"3 2\r\n" + 
			"1 2 1\r\n" + 
			"2 1 2\r\n" + 
			"1 2 1";
}
