package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_7562_최영진 {

	static int T;
	static int N;
	static int sr,sc,er,ec,cnt;
	static int matrix[][];
	static boolean visited[];
	static int dr[]= {-2,-1,1,2,2,1,-1,-2}, dc[]= {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int [N][N];
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			if(sr==er&&sc==ec) {
				System.out.println(0);
				continue;
			}
			bfs();
			
		}
		
	}
	private static void bfs() {
		Queue<int []> queue = new LinkedList<int []>();
		queue.offer(new int[] {sr,sc});
		matrix[sr][sc]=1;
		cnt=0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = matrix[r][c];
			for (int i = 0; i < 8; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>-1 && nr<N && nc>-1 && nc<N && matrix[nr][nc]==0) {
					if(nr==er && nc==ec) {
						System.out.println(cnt);
						return;
					}else {
						matrix[nr][nc]=cnt+1;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
			
		}
	}
	static String src = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1";

}
