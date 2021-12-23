package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_최영진 {
	static int N,M;
	static char map[][];
	static boolean visited[][][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean [N][M][(int)Math.pow(2, 6)+1];
		int Ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='0') {
					Ans = bfs(i,j);
				}
			}
		}
		System.out.println(Ans);
		
	}
	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c,0,0});
		visited[r][c][0] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int x = cur[0]; int y = cur[1]; int check = cur[2]; int cnt = cur[3];
			
			for (int i = 0; i < 4; i++) {
				int nr = x+dr[i];
				int nc = y+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					
					if(visited[nr][nc][check]) continue;
					
					if(map[nr][nc]>=97 && map[nr][nc]<=102) {
						queue.offer(new int[] {nr, nc, check|1<<(map[nr][nc]-97), cnt+1});
						visited[nr][nc][check|1<<(map[nr][nc]-97)] = true;
					}else if(map[nr][nc]>=65 && map[nr][nc]<=70) {
						if((check&1<<(map[nr][nc]-65))!=0) {
							queue.offer(new int[] {nr,nc,check,cnt+1});
							visited[nr][nc][check] = true;
						}
					}else if(map[nr][nc]=='.'||map[nr][nc]=='0') {
						queue.offer(new int[] {nr,nc,check,cnt+1});
						visited[nr][nc][check] = true;
					}
					else if(map[nr][nc]=='1') return cnt+1;
				}
			}
		}
		return -1;
	}
	static String src = "7 8\r\n" + 
			"a#c#eF.1\r\n" + 
			".#.#.#..\r\n" + 
			".#B#D###\r\n" + 
			"0....F.1\r\n" + 
			"C#E#A###\r\n" + 
			".#.#.#..\r\n" + 
			"d#f#bF.1";
}
