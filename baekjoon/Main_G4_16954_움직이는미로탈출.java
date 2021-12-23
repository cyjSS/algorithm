package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G4_16954_움직이는미로탈출 {
	static int dr[]= {0,-1,1,0,0,-1,-1,1,1}, dc[]= {0,0,0,-1,1,-1,1,-1,1};
	static char map[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		map = new char[8][];
		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[8][8];
		System.out.println(bfs(7,0));
	}
	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y,0});
		visited[x][y] = true;
		int status =0;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			
			if(cur[0]==0 && cur[1]==7) return 1;
			if(cur[2]==8) return 1;
			if(cur[2]!=0 && (1<<cur[2]&status)==0) {
				move();
				status |= 1<<cur[2];
			}
			
			for (int i = 0; i < 9; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(i==0) {
					if(nr>0 && map[nr-1][nc]=='#') continue;
					queue.offer(new int[] {nr,nc,cur[2]+1});
					visited[nr][nc] = true;
				}else {
					if(nr>=0 && nr<8 && nc>=0 && nc<8 && map[nr][nc]=='.' && !visited[nr][nc]) {
						if(nr>0 && map[nr-1][nc]=='#') continue;
						queue.offer(new int[] {nr,nc,cur[2]+1});
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return 0;
	}
	private static void move() {
		for (int i = 7; i > 0; i--) {
			for (int j = 7; j >= 0; j--) {
				if(map[i-1][j]=='#') map[i][j]='#';
				else map[i][j]='.';
			}
		}
		return;
	}
	static String src = "........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"#.......\r\n" + 
			".#######\r\n" + 
			"#.......\r\n" + 
			"........";
}
