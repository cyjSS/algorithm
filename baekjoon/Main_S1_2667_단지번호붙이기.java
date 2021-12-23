package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S1_2667_최영진 {

	static int N,dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	static int matrix[][];
	static boolean visited[][];
	static int apartNum=0;
	static int aparts[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		visited = new boolean[N][N];
		aparts = new int[N*N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				matrix[i][j]=str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j]==1 && !visited[i][j]) {
					apartNum++;
					bfs(i,j);
				}
			}
		}
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for (int i = 0; i < aparts.length; i++) {
			if(aparts[i]!=0) {
				System.out.println(aparts[i]);
			}
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<int []> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y});
		visited[x][y]=true;
		aparts[apartNum]++;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0];
			int c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr>-1 && nr<N && nc>-1 && nc<N) {
					if(matrix[nr][nc]==1 && !visited[nr][nc]) {
						queue.offer(new int[] {nr,nc});
						visited[nr][nc]=true;
						aparts[apartNum]++;
					}
				}
			}
		}
		
	}
	static String src = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";

}
