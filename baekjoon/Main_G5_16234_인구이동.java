package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_16234_인구이동 {
	static int N,L,R;
	static int map[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int Ans = 0;
		while(true) {
			visited = new boolean[N][N];
			int noMove=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						if(bfs(i,j)==0) noMove++;
					}
				}
			}
			if(noMove==N*N) break;
			Ans++;
		}
		
		System.out.println(Ans);
		
	}
	private static int bfs(int r, int c) {
		int cnt = 0; int sum =0;
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> qPlus = new LinkedList<int[]>();
		
		queue.offer(new int[] {r,c});
		qPlus.offer(new int[] {r,c});
		sum += map[r][c];
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
					if(Math.abs(map[cur[0]][cur[1]]-map[nr][nc])>=L && Math.abs(map[cur[0]][cur[1]]-map[nr][nc])<=R) {
						queue.offer(new int[] {nr,nc});
						qPlus.offer(new int[] {nr,nc});
						sum += map[nr][nc];
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		if(cnt==0) visited[r][c] = false;
		else {
			while(!qPlus.isEmpty()) {
				int plus[] = qPlus.poll();
				map[plus[0]][plus[1]] = sum/(cnt+1);
			}
		}
		return cnt;
	}
	static String src = "2 20 50\r\n" + 
			"50 30\r\n" + 
			"30 40";
}
