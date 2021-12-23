package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2589_보물섬 {
	static int N,M;
	static char map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		br = new BufferedReader(new StringReader(src));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char [N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L') {
					visited = new boolean[N][M];
					bfs(i,j);
				}
			}
		}

		System.out.println(answer);
	}
	private static void bfs(int r, int c) {
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c,0});
		visited[r][c] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			cnt = cur[2];
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]=='L' && !visited[nr][nc]) {
					queue.offer(new int[] {nr,nc,cur[2]+1});
					visited[nr][nc] = true;
				}
			}
		}
		
		answer = Math.max(answer, cnt);
	}
	static String src = "5 7\r\n" + 
			"WLLWWWL\r\n" + 
			"LLLWLLL\r\n" + 
			"LWLWLWW\r\n" + 
			"LWLWLLL\r\n" + 
			"WLLWLWW";
}
