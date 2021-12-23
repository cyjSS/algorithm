package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16236_최영진 {
	static class Loc implements Comparable<Loc>{
		int r,c,cnt,size,eat,total;
		public Loc(int r, int c, int cnt, int size, int eat, int total) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.size = size;
			this.eat = eat;
			this.total = total;
		}
		@Override
		public int compareTo(Loc o) {
			int gap = this.cnt-o.cnt;
			if(gap==0) {
				gap = this.r-o.r;
				if(gap==0) gap = this.c-o.c;
			}
			return gap;
		}
	}
	static int N;
	static int map[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==9) ans = bfs(i,j);
			}
		}
		
		System.out.println(ans);
	}
	private static int bfs(int x, int y) {
		int dis =0;
		PriorityQueue<Loc> pq = new PriorityQueue<>();
		pq.offer(new Loc(x,y,0,2,0,0));
		while(!pq.isEmpty()) {
			// 우선순위 1등 잡아먹기
			Loc cur = pq.poll();
			if(cur.eat==cur.size) {
				cur.size++;
				cur.eat=0;
			}
			map[cur.r][cur.c] = 0;
			dis = cur.total;
			// 다른 물고기 놓아주기
			pq.clear();
			
			// 물고기 찾기 
			visited = new boolean[N][N];
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {cur.r, cur.c, 0});
			visited[cur.r][cur.c] = true;
			while(!queue.isEmpty()) {
				int fish[] = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = fish[0]+dr[i];
					int nc = fish[1]+dc[i];
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]<=cur.size) {
						if(map[nr][nc]!=0 && map[nr][nc]<cur.size) {
							pq.offer(new Loc(nr,nc, fish[2]+1,cur.size,cur.eat+1, cur.total+fish[2]+1));
						}
						queue.offer(new int[] {nr,nc,fish[2]+1});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return dis;
	}
	static String src = "6\r\n" + 
			"1 1 1 1 1 1\r\n" + 
			"2 2 6 2 2 3\r\n" + 
			"2 2 5 2 2 3\r\n" + 
			"2 2 2 4 6 3\r\n" + 
			"0 0 0 0 0 6\r\n" + 
			"0 0 0 0 0 9";
}
