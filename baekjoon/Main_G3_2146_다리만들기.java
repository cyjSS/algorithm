package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_2146_다리만들기 {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		br = new BufferedReader(new StringReader(src));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					comb(i,j,idx);
					idx++;
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					visited = new boolean[N][N];
					answer = Math.min(answer, find(i,j,map[i][j]));
				}
			}
		}
		
		System.out.println(answer);
	}
	private static int find(int r, int c, int now) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r,c,0});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			if(map[cur[0]][cur[1]]!=0 && map[cur[0]][cur[1]]!=now) return cur[2]-1;
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]!=now && !visited[nr][nc]) {
					q.add(new int[] {nr,nc,cur[2]+1});
					visited[nr][nc] = true;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	private static void comb(int r, int c, int idx) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r,c});
		map[r][c] = idx;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==1) {
					q.add(new int[] {nr,nc});
					map[nr][nc] = idx;
				}
			}
		}
	}
	static String src = "5\r\n" + 
			"1 0 0 0 0\r\n" + 
			"1 0 0 0 1\r\n" + 
			"1 0 0 0 1\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 0 0 0 0";
}
