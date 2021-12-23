package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**   1000개까지는 인접행렬 가능     */

public class Main_S2_1260_최영진 {

	static int N,M,V;
	static int matrix[][];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken())-1;
		
		matrix = new int [N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			matrix[x][y]=1;
			matrix[y][x]=1;
		}
		visited = new boolean[N];
		dfs(V);
		
		sb.append("\n");
		visited = new boolean[N];
		bfs(V);
		System.out.println(sb);
	}
	private static void bfs(int start) {
		Queue<Integer> queue  = new LinkedList<Integer>();
		
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start+1).append(" ");
			for (int i = 0; i < N; i++) {
				if(matrix[start][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start+1).append(" ");
		
		for (int i = 0; i < N; i++) {
			if(matrix[start][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	static String src = "5 5 3\r\n" + 
			"5 4\r\n" + 
			"5 2\r\n" + 
			"1 2\r\n" + 
			"3 4\r\n" + 
			"3 1";
}
