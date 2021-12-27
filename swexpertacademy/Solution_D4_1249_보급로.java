package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1249_보급로 {
	static class Info implements Comparable<Info>{
		int x,y,weight;

		public Info(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Info o) {
			return this.weight-o.weight;
		}
	}
	static int N;
	static int map[][], distance[][];
	static boolean visited[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			distance[0][0]=map[0][0];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().replace("", " "));
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+test+" "+bfs(0,0));
		}
	}
	private static int bfs(int r, int c) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(r,c,distance[r][c]));
		visited[r][c] = true;
		
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(info.x==N-1 && info.y==N-1) return info.weight;
			for (int i = 0; i < 4; i++) {
				int nr = info.x+dr[i];
				int nc = info.y+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
					if(distance[nr][nc]>info.weight+map[nr][nc]) {
						distance[nr][nc]= info.weight+map[nr][nc];
						pq.offer(new Info(nr, nc, distance[nr][nc]));
						visited[nr][nc] = true;
					}
				}
			}
		}
		return 0;
	}
	static String src = "2\r\n" + 
			"4\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1011\r\n" + 
			"1010\r\n" + 
			"6\r\n" + 
			"011001\r\n" + 
			"010100\r\n" + 
			"010011\r\n" + 
			"101001\r\n" + 
			"010101\r\n" + 
			"111010";
}
