package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14502_연구소 {
	static class Blank{
		int x, y;

		public Blank(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static Blank blank[];
	static int N, M;
	static int map[][];
	static int idx;
	static int numbers[];
	static int Ans;
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		blank = new Blank[N*M];
		
		idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) blank[idx++] = new Blank(i,j);
			}
		}
		
		numbers = new int[3];
		Ans = 0;
		comb(0,0);
		System.out.println(Ans);
	}
	private static void comb(int cnt, int start) {
		if(cnt==3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==-1) map[i][j]=0;
				}
			}
			for (int i = 0; i < 3; i++) {
				map[blank[numbers[i]].x][blank[numbers[i]].y]=-1;
			}
			
//			System.out.println(Arrays.deepToString(map));
			Ans = Math.max(Ans, bfs());
			return;
		}
		for (int i = start; i < idx; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	private static int bfs() {
		int check[][] = new int[N][M];
		visited = new boolean[N][M];
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==2) {
					queue.offer(new int[] {i,j});
					visited[i][j]=true;
				}
			}
		}
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					if(map[nr][nc]==0) {
						queue.offer(new int[] {nr,nc});
						check[nr][nc] = map[cur[0]][cur[1]]+1;
						visited[nr][nc] = true;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check[i][j]==0 && map[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
	static String src = "8 8\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0";
}
