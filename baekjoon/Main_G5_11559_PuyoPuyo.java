package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_11559_PuyoPuyo {
	static char[][] map;
	static boolean[][] visited;
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		map = new char[12][];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		while(true) {
			int cnt = 0;
			visited = new boolean[12][6];
			for (int i = 11; i >=0; i--) {
				for (int j = 0; j < 6; j++) {
					if(!visited[i][j] && map[i][j]!='.') {
						list = new ArrayList<>();
						if(bfs(i,j,map[i][j])) cnt++;
					}
				}
			}
			
			if(cnt==0) break;
			answer++;
			
			move();
		}
		System.out.println(answer);

	}
	private static void move() {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i >= 0; i--) {
				int k = i;
				while(i>=0 && map[i][j]=='.') i--;
				if(k!=i && i!=-1) {
					map[k][j] = map[i][j];
					map[i][j] = '.';
					i = k;
				}
			}
		}
	}
	private static boolean bfs(int r, int c, char color) {
		Queue<int[]> queue = new LinkedList<int[]>();
		list.add(new int[] {r,c});
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr>=0 && nr<12 && nc>=0 && nc<6 && !visited[nr][nc] && map[nr][nc]==color) {
					list.add(new int[] {nr,nc});
					queue.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
		
		if(list.size()>=4) {
			for (int[] puyo : list) {
				map[puyo[0]][puyo[1]] = '.';
			}
			return true;
		}
		
		return false;
		
	}
	static String src = "Y...YR\r\n" + 
			"B.RGGY\r\n" + 
			"R.GGYY\r\n" + 
			"G.RYGR\r\n" + 
			"YGYGRR\r\n" + 
			"YBRYGY\r\n" + 
			"RRYYGY\r\n" + 
			"YYRBRB\r\n" + 
			"YRBGBB\r\n" + 
			"GBRBGR\r\n" + 
			"GBRBGR\r\n" + 
			"GBRBGR";
}
