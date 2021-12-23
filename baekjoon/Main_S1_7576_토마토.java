package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576_최영진 {
	static int N,M;
	static int map[][];
	static int dr[]={-1,1,0,0}, dc[]={0,0,-1,1};
	static boolean visited[][];
	static int Ans;
	static Queue<int []> queue = new LinkedList<int[]>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int zeroCnt=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) zeroCnt++;
			}
		}
		if(zeroCnt==0) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) queue.offer(new int[] {i,j,0});
			}
		}
		visited = new boolean[N][M];
		Ans = 0;
		bfs();
		int lastZero=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) lastZero++; 
			}
		}
		if(lastZero!=0) System.out.println(-1);
		else System.out.println(Ans);
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0]; int c = cur[1]; Ans = cur[2];
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					visited[nr][nc]=true;
					if(map[nr][nc]==0) {
						queue.offer(new int[] {nr,nc,Ans+1});
						map[nr][nc] = Ans+1;
					}
				}
			}
		}
	}
	static String src = "2 2\r\n" + 
			"1 -1\r\n" + 
			"-1 1";
}
