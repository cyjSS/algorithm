package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G3_1941_소문난칠공주 {
	static char map[][];
	static int check[][];
	static int number[];
	static int answer;
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br = new BufferedReader(new StringReader(src));
		
		map = new char[5][];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		number = new int[7];
		answer = 0;
		seven(0, 0, 0);
		
		System.out.println(answer);
	}
	
	private static void seven(int cnt, int ydo, int start) {
		
		if(ydo>=4) return;
		if(cnt==7) {
			check = new int[5][5];
			
			for (int i = 1; i < 7; i++) {
				check[number[i]/5][number[i]%5] = 1;
			}
			
			if(bfs(number[0]/5,number[0]%5)==0) {
				answer++;
			}
			return;
		}
		
		for (int i = start; i < 25; i++) {
			number[cnt] = i;
			if(map[i/5][i%5]=='Y') seven(cnt+1,ydo+1,i+1);
			else seven(cnt+1,ydo,i+1);
		}
	}
	private static int bfs(int r, int c) {
		int count = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		while(!queue.isEmpty()) {
			int cur[]=queue.poll();
			check[cur[0]][cur[1]] = 0;
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<5 && nc>=0 && nc<5 && check[nr][nc]==1) queue.add(new int[] {nr,nc});
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(check[i][j]==1) count++;
			}
		}
		return count;
	}
	static String src = "YYYYY\r\n" + 
			"SYSYS\r\n" + 
			"YYYYY\r\n" + 
			"YSYYS\r\n" + 
			"YYYYY";
}
