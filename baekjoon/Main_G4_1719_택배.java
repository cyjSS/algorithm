package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_1719_택배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][N];
		boolean visited[][] = new boolean[N][N];
		
		int answer[][] = new int[N][N];
		int distance[][] = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[y][x] = map[x][y] = Integer.parseInt(st.nextToken());
			answer[x][y] = y;
			answer[y][x] = x;
		}
		
		for (int i = 1; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		int min = 0, cur = 0;
		for (int start = 1; start < N; start++) {
			distance[start][start] = 0;
			
			for (int i = 1; i < N; i++) {
				min = Integer.MAX_VALUE;
				
				for (int j = 1; j < N; j++) {
					if(!visited[start][j] && min > distance[start][j]) {
						min = distance[start][j];
						cur = j;
					}
				}
				
				visited[start][cur] = true;
				
				for (int j = 1; j < N; j++) {
					if(!visited[start][j] && map[cur][j]!=0 && distance[start][j] > min +map[cur][j]) {
						distance[start][j] = min + map[cur][j];
						if(start != cur) answer[start][j] = answer[start][cur];
					}
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(i==j) System.out.print("-"+" ");
				else System.out.print(answer[i][j]+" ");
			}System.out.println();
		}
		
	}
	static String src = "6 10\r\n" + 
			"1 2 2\r\n" + 
			"1 3 1\r\n" + 
			"2 4 5\r\n" + 
			"2 5 3\r\n" + 
			"2 6 7\r\n" + 
			"3 4 4\r\n" + 
			"3 5 6\r\n" + 
			"3 6 7\r\n" + 
			"4 6 4\r\n" + 
			"5 6 2";
}
