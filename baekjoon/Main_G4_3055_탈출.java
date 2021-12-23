package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_3055_탈출 {
	static int R,C;
	static char map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C];
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='S') ans = bfs(i,j);
			}
		}
		if(ans==-1) System.out.println("KAKTUS");
		else System.out.println(ans);
	}
	private static int bfs(int i, int j) {
		int status = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j,0});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(status!=0 && (status&1<<cur[2])==0) map = water();
			status |= 1<<cur[2];
			if(map[cur[0]][cur[1]]=='D') return cur[2];
			for (int k = 0; k < 4; k++) {
				int nr = cur[0]+dr[k];
				int nc = cur[1]+dc[k];
				if(map[cur[0]][cur[1]]=='*') break;
				if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
					if(map[nr][nc]=='.' || map[nr][nc]=='D') {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr,nc,cur[2]+1});
					}
				}
			}
		}
		return -1;
	}
	private static char[][] water() {
		char change[][] = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='*') {
					change[i][j] = '*';
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]=='.') {
							change[nr][nc]='*';
							visited[nr][nc] = true;
						}
					}
				}else {
					if(change[i][j]!='*') change[i][j] = map[i][j];
				}
			}
		}
		return change;
	}
	static String src = "3 3\r\n" + 
			"D.*\r\n" + 
			"...\r\n" + 
			"..S";
}
