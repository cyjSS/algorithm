package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2573_빙산 {
	static int N,M;
	static int map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		br = new BufferedReader(new StringReader(src));

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
		
		int answer = 0;
		while(true) {
			int cnt = 0; int zeroCnt=0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
					if(map[i][j]==0) zeroCnt++;
				}
			}
			if(cnt>1) break;
			if(zeroCnt==N*M) {
				answer=0;
				break;
			}
			map = time();
			answer++;
		}
		
		System.out.println(answer);
	}
	private static int[][] time() {
		int change[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0) {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0) count++;
						change[i][j] = map[i][j]-count>0? map[i][j]-count:0;
					}
				}
			}
		}
		return change;
	}
	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]!=0) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	static String src= "5 7\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"0 2 4 5 3 0 0\r\n" + 
			"0 3 0 2 5 2 0\r\n" + 
			"0 7 6 2 4 0 0\r\n" + 
			"0 0 0 0 0 0 0";
}
