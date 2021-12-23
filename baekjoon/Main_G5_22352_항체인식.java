package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_22352_항체인식 {
	static int N,M;
	static int before[][];
	static int after[][];
	static boolean visited[][];
	static int cnt;
	static boolean no;
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		before = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		after = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				after[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0; no = false;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(before[i][j]!=after[i][j] && !visited[i][j]) {
					bfs(i,j,before[i][j],after[i][j]);
				}
			}
		}
		if(cnt<2 && !no) System.out.println("YES");
		else System.out.println("NO");
	}
	private static void bfs(int r, int c, int b, int a) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c] = true;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && before[nr][nc]==b) {
					if(after[nr][nc]!=a) no = true;
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
		cnt++;
	}
	static String src = "4 4\r\n" + 
			"2 2 2 3\r\n" + 
			"2 2 1 3\r\n" + 
			"2 1 3 3\r\n" + 
			"1 3 3 3\r\n" + 
			"2 2 2 2\r\n" + 
			"2 2 1 2\r\n" + 
			"2 1 3 3\r\n" + 
			"1 3 3 3";
}
