package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17135 {
	static int N, M, D;
	static boolean visited[][];
	static int gung[];
	static int map[][], distance[][];
	static int dr[]= {0,-1,0}, dc[]= {-1,0,1};
	static int total, kill, Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		total = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) total++;
			}
		}
		
		gung = new int [M];
		int cnt = 0;
		while(++cnt<=3) gung[M-cnt] = 1;
		Ans = 0;
		do {
			kill = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==-1) map[i][j]=1;
				}
			}
			distance = new int[N][M];
			for (int i = N; i > 0; i--) {
				defence(i);
			}
//			System.out.println(Arrays.toString(gung)+" "+kill);
			Ans = Math.max(Ans, kill);
			if(Ans>=total) break;
		} while (np(gung));
		
		System.out.println(Ans);
	}
	
	private static void defence(int loc) {
		for (int j = 0; j < M; j++) {
			if(gung[j]==1) {
				visited = new boolean [N+1][M];
				bfs(loc,j);
			}
		}
		for (int i = 0; i < loc; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1 && distance[i][j]!=0) {
					map[i][j]=-1;
					kill++;
				}
			}
		}
	}
	
	private static int cal(int xE, int yE, int xG, int yG) {
		return Math.abs(xE-xG) + Math.abs(yE-yG);
	}

	private static void bfs(int turn,int gungLoc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {turn, gungLoc});
		visited[turn][gungLoc] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for (int i = 0; i < 3; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<turn && nc>=0 && nc<M && !visited[nr][nc]) {
					if(map[nr][nc]==1 && cal(nr,nc,turn, gungLoc)<=D) {
						distance[nr][nc]=turn;
						return;
					}
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static boolean np(int[] numbers) {
		int N = numbers.length;
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		swap(numbers, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] numbers,int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	static String src = "6 5 2\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 1 0 1 0\r\n" + 
			"1 1 0 0 0\r\n" + 
			"0 0 0 1 1\r\n" + 
			"1 1 0 1 1\r\n" + 
			"0 0 1 0 0";
}
