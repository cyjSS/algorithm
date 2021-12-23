package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_2606_최영진 {

	static int N;
	static boolean matrix[][];
	static boolean visited[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new boolean[N][N];
		visited = new boolean[N];
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i <T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			matrix[x][y]=true;
			matrix[y][x]=true;
		}
		bfs(0);
		
		
	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		visited[cur]=true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			for (int adj = 0; adj < N; adj++) {
				if(matrix[cur][adj] && !visited[adj]) {
					queue.offer(adj);
					visited[adj]=true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
	static String src = "7\r\n" + 
			"6\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"1 5\r\n" + 
			"5 2\r\n" + 
			"5 6\r\n" + 
			"4 7";

}
