package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_6593_상범빌딩 {
	static int L,R,C;
	static char map[][][];
	static boolean visited[][][];
	static int dz[]= {0,0,0,0,1,-1},dx[]= {0,0,-1,1,0,0},dy[]= {1,-1,0,0,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		br = new BufferedReader(new StringReader(src));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0) break;
			
			map = new char[L][R][C];
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					map[i][j] = br.readLine().toCharArray();
				}
				br.readLine();
			}
			
			int ans = 0;
			visited = new boolean [L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {
						if(map[i][j][k]=='S') {
							ans = bfs(i,j,k);
							break;
						}
					}
				}
			}
			if(ans==-1) System.out.println("Trapped!");
			else System.out.println("Escaped in "+ans+" minute(s).");
			
		}
	}
	private static int bfs(int z, int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {z,x,y,0});
		visited[z][x][y] = true;
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(map[cur[0]][cur[1]][cur[2]]=='E') return cur[3];
			for (int i = 0; i < 6; i++) {
				int nz = cur[0] + dz[i];
				int nx = cur[1] + dx[i];
				int ny = cur[2] + dy[i];
				if(nz>=0 && nz<L && nx>=0 && nx<R && ny>=0 && ny<C && !visited[nz][nx][ny]) {
					if(map[nz][nx][ny]=='.' || map[nz][nx][ny]=='E') {
						queue.add(new int[] {nz,nx,ny,cur[3]+1});
						visited[nz][nx][ny] = true;
					}
				}
			}
		}
		return -1;
	}
	static String src = "3 4 5\r\n" + 
			"S....\r\n" + 
			".###.\r\n" + 
			".##..\r\n" + 
			"###.#\r\n" + 
			"\r\n" + 
			"#####\r\n" + 
			"#####\r\n" + 
			"##.##\r\n" + 
			"##...\r\n" + 
			"\r\n" + 
			"#####\r\n" + 
			"#####\r\n" + 
			"#.###\r\n" + 
			"####E\r\n" + 
			"\r\n" + 
			"1 3 3\r\n" + 
			"S##\r\n" + 
			"#E#\r\n" + 
			"###\r\n" + 
			"\r\n" + 
			"0 0 0";
}
