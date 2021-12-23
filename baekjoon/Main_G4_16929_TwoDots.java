package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G4_16929_TwoDots {
	static int N,M;
	static char map[][];
	static int answer;
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				dfs(i,j,i,j,0,-1);
				if(answer>=4) break;
			}
			if(answer>=4) break;
		}
		if(answer>=4) System.out.println("Yes");
		else System.out.println("No");

	}
	private static void dfs(int firstR, int firstC, int r, int c, int cnt, int dir) {
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==map[firstR][firstC] && !visited[nr][nc]) {
				if(nr==firstR && nc==firstC) {
					answer = Math.max(answer, cnt+1);
					return;
				}
				visited[nr][nc] = true;
				dfs(firstR, firstC, nr, nc, cnt+1, i);
				visited[nr][nc] = false;
			}
		}
	}
	static String src = "7 6\r\n" + 
			"AAAAAB\r\n" + 
			"ABBBAB\r\n" + 
			"ABAAAB\r\n" + 
			"ABABBB\r\n" + 
			"ABAAAB\r\n" + 
			"ABBBAB\r\n" + 
			"AAAAAB";
}
