package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14500_테트로미노 {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visited[i][j] = false;
				pink(i,j);
			}
		}

		System.out.println(answer);
	}
	private static void pink(int y, int x) {
		if(x-1>=0 && y-1>=0 && x+1<M) {
            int first = map[y][x]+map[y][x-1]+map[y][x+1]+map[y-1][x];
            answer = Math.max(answer, first);
        }
        
        if(x-1>=0 && y+1<N && x+1<M) {
            int second = map[y][x]+map[y][x-1]+map[y][x+1]+map[y+1][x];
            answer = Math.max(second, answer);
        }
        
        if(x+1<M && y+1<N && y-1>=0) {
            int third = map[y][x+1]+map[y-1][x]+map[y+1][x]+map[y][x];
            answer = Math.max(third, answer);
        }
        
        if(x-1>=0 && y-1>=0 && y+1<N) {
            int forth = map[y][x-1]+map[y-1][x]+map[y+1][x]+map[y][x];
            answer = Math.max(forth, answer);
        }
	}
	private static void dfs(int r, int c, int cnt, int total) {
		if(cnt==4) {
			answer = Math.max(answer, total);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, cnt+1, total+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}

}
