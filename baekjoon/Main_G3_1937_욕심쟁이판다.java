package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G3_1937_욕심쟁이판다 {
	static int N;
	static int map[][];
	static int memo[][];
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	static int answer;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}
		
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(answer, dfs(i,j));
			}
		}
		
		System.out.println(answer);
	}
	private static int dfs(int r, int c) {
		if(memo[r][c]!=0) return memo[r][c];
		int max = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]<map[r][c]) {
				max = Math.max(max, dfs(nr,nc)+1);
			}
		}
		
		memo[r][c] = max;
		return max;
	}
	static String src = "4\r\n" + 
			"14 9 12 10\r\n" + 
			"1 11 5 4\r\n" + 
			"7 15 2 13\r\n" + 
			"6 3 16 8";
}
