package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2468_최영진 {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int ans, cnt;
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = 0; int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				max = Math.max(max, temp);
				min = Math.min(min, temp);
			}
		}
		
		ans =0;
		for (int height = min-1; height < max; height++) {
			visited = new boolean[N][N]; cnt =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]>height && !visited[i][j]) bfs(i,j,height);
				}
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
	private static void bfs(int r, int c, int h) {
		cnt++;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]>h) {
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	static String src = "7\r\n" + 
			"9 9 9 9 9 9 9\r\n" + 
			"9 2 1 2 1 2 9\r\n" + 
			"9 1 8 7 8 1 9\r\n" + 
			"9 2 7 9 7 2 9\r\n" + 
			"9 1 8 7 8 1 9\r\n" + 
			"9 2 1 2 1 2 9\r\n" + 
			"9 9 9 9 9 9 9";
}
