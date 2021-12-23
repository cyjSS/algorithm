package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_17822_원판돌리기 {
	static class Rotation {
		int n; int dir; int cnt;
		public Rotation(int n, int dir, int cnt) {
			this.n = n;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	static ArrayList<Rotation> rotation;
	static int N,M,T;
	static int map[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation = new ArrayList<>(T);
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotation.add(new Rotation(x,d,k));
		}
		
		for (int i = 0; i < T; i++) {
			rotate(i);
			map = check();
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	private static int[][] check() {
		int change[][] = new int[N+1][M];
		int sum = 0;
		int count = 0;
		boolean totalSame = false;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
				if(map[i][j]!=0) {
					Boolean same = false;
					count++;
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = (j+dc[k])%M!=-1? (j+dc[k])%M:M-1;
						if(nr>0 && nr<=N && map[nr][nc]==map[i][j]) {
							totalSame = true;
							same = true;
						}
					}
					if(!same) change[i][j] = map[i][j];
				}
			}
		}
		
		if(!totalSame && count!=0) {
			double avg = (double)sum/(double)count;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0) {
						if(map[i][j]>avg) change[i][j]=map[i][j]-1;
						else if(map[i][j]<avg) change[i][j]=map[i][j]+1;
					}else change[i][j] = 0;
				}
			}
		}
		
		return change;
	}
	private static void rotate(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int j = 1; j <= N; j++) {
			if(j%rotation.get(i).n==0) {
				for (int f = 0; f < M; f++) 
					q.add(map[j][f]);
				int idx = 0;
				if(rotation.get(i).dir==0) idx = rotation.get(i).cnt;
				else idx = M-rotation.get(i).cnt;
				
				for (int k = 0; k < M; k++) {
					map[j][idx] = q.poll();
					idx = (idx+1)%M;
				}
			}
		}
		
	}
	static String src = "4 6 3\r\n" + 
			"1 2 3 4 5 6\r\n" + 
			"2 3 4 5 6 7\r\n" + 
			"3 4 5 6 7 8\r\n" + 
			"4 5 6 7 8 9\r\n" + 
			"2 1 4\r\n" + 
			"3 0 1\r\n" + 
			"2 1 2";
}
