package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_14442_최영진 {
	static int N,M,K;
	static int map[][];
	static int dr[]= {-1,1,0,0}, dc[] = {0,0,-1,1};
	static boolean visited[][][];
	static int cnt;
	static int Ans[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		visited = new boolean [N][M][K+1];
		Ans = new int[N][M];
		bfs();
//		System.out.println(Arrays.deepToString(Ans));
		for (int[] i : Ans) {
		for(int j: i) System.out.print(j+" ");
		System.out.println();
		}
		if(Ans[N-1][M-1]!=0) System.out.println(Ans[N-1][M-1]);
		else System.out.println(-1);
//		System.out.println(src);
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{0,0,0});
		visited[0][0][0] = true;
		Ans[0][0] = 1;
		cnt = 0;
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int wall = cur[2];
			int cnt = Ans[r][c];
			if(r==N-1 && c==M-1) return;
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr>-1 && nr<N && nc>-1 && nc<M) {
					
					if(map[nr][nc]==0&&!visited[nr][nc][wall]) {
						queue.offer(new int[] {nr,nc,wall});
						visited[nr][nc][wall] = true;
						Ans[nr][nc] = cnt+1;
					}
					else if(map[nr][nc]==1&&wall<K&&!visited[nr][nc][wall+1]) {
						queue.offer(new int[] {nr,nc,wall+1});
						visited[nr][nc][wall+1] = true;
						Ans[nr][nc] = cnt+1;
					}
					
				}
			}
		}
	}
	static String src = "4 7 4\r\n" + 
			"0110100\r\n" + 
			"1111110\r\n" + 
			"1111111\r\n" + 
			"1111010";
}
