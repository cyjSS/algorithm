package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2636_최영진 {
	static int map[][];
	static int R,C;
	static boolean visited[][];
	static int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
	static int cheese[], idx;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cheese = new int[R>C? R:C];
		int Ans = 0; idx=0;
		while(check()) {
			for (int i = 0; i < R; i++) {
				Arrays.fill(visited[i], false);
			}
			bfs();
			Ans++;
		}
		System.out.println(Ans);
		System.out.println(cheese[Ans-1]);
		
	}
	private static boolean check() {
		int cnt = 0; 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		cheese[idx++]=cnt;
		if(cnt==0) return false;
		else return true;
		
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0]; int c = cur[1];

			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>-1 && nr<R && nc>-1 && nc<C && !visited[nr][nc]) {
					if(map[nr][nc]==1) {
						map[nr][nc] = 0;
					}else queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
				
			}			
			
		}
		
	}
	static String src = "13 12\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 0 1 1 0 0 0\r\n" + 
			"0 1 1 1 1 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 0 0 0 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}
