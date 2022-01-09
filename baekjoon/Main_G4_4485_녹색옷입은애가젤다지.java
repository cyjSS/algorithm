package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_4485 {
	static class Vertex implements Comparable<Vertex>{
		int start;
		int end;
		int weight;
		public Vertex(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int cnt =1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int distance[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			distance[0][0] = map[0][0];
			
			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
	        queue.offer(new Vertex(0, 0, distance[0][0]));
	        
	        while(!queue.isEmpty()) {
	        	Vertex cur = queue.poll();
	        	
	        	for (int i = 0; i < 4; i++) {
					int nr = cur.start+dr[i];
					int nc = cur.end+dc[i];
					if(nr>=0 && nr<N &&nc>=0 &&nc<N) {
						if(distance[nr][nc]>distance[cur.start][cur.end]+map[nr][nc]) {
							distance[nr][nc] = distance[cur.start][cur.end]+map[nr][nc];
							queue.offer(new Vertex(nr,nc, distance[nr][nc]));
						}
					}
				}
	        }
	        
	        System.out.println("Problem"+" "+(cnt++)+":"+" "+distance[N-1][N-1]);
		}
	}
	static String src = "3\r\n" + 
			"5 5 4\r\n" + 
			"3 9 1\r\n" + 
			"3 2 7\r\n" + 
			"5\r\n" + 
			"3 7 2 0 1\r\n" + 
			"2 8 0 9 1\r\n" + 
			"1 2 1 8 1\r\n" + 
			"9 8 9 2 0\r\n" + 
			"3 6 5 1 5\r\n" + 
			"7\r\n" + 
			"9 0 5 1 1 5 3\r\n" + 
			"4 1 2 1 6 5 3\r\n" + 
			"0 7 6 1 6 8 5\r\n" + 
			"1 1 7 8 3 2 3\r\n" + 
			"9 4 0 7 6 4 1\r\n" + 
			"5 8 3 2 4 8 3\r\n" + 
			"7 4 8 4 8 3 4\r\n" + 
			"0";
}
