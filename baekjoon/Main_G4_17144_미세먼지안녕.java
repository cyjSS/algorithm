package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17144_최영진 {
	static int R,C,T;
	static int map[][], plusMap[][];
	static int dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1};
	static int upDownr[], upDownc[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			plusMap = new int[R][C];
			move();
			for (int x = 0; x < R; x++) {
				for (int y = 0; y < C; y++) {
					map[x][y] += plusMap[x][y];
				}
			}

			air();

		}
		int Ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>0) Ans+=map[i][j];
			}
		}
		System.out.println(Ans);
	}
	private static void air() {
		int dir = 1;
		for (int i = 0; i < R; i++) {
			if(map[i][0]==-1) wind(dir++,i);
		}
		
	}
	private static void wind(int d, int limit) {
		if(d==1) {
			upDownr= new int[] {-1,0,1,0}; upDownc= new int[] {0,1,0,-1};
			int idx = 0;
			int nr = limit+upDownr[idx];
			int nc = upDownc[idx];
			while(nr>0) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}idx++;
			while(nc<C-1) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}idx++;
			while(nr<limit) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}idx++;
			while(nc>1) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}map[nr][nc]=0;
		}
		else {
			upDownr= new int[] {1,0,-1,0}; upDownc= new int[] {0,1,0,-1};
			int idx = 0;
			int nr = limit+upDownr[idx];
			int nc = upDownc[idx];
			while(nr<R-1) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}idx++;
			while(nc<C-1) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}idx++;
			while(nr>limit) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}idx++;
			while(nc>1) {
				map[nr][nc] = map[nr+upDownr[idx]][nc+upDownc[idx]];
				nr += upDownr[idx];
				nc += upDownc[idx];
			}map[nr][nc]=0;
		}
		
				
	}
	private static void move() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>0) {
					int minus = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]>=0) {
							plusMap[nr][nc] += map[i][j]/5;
							minus += map[i][j]/5;
						}
					}
					map[i][j] -= minus;
 				}
			}
		}
	}
	static String src = "7 8 2\r\n" + 
			"0 0 0 0 0 0 0 9\r\n" + 
			"0 0 0 0 3 0 0 8\r\n" + 
			"-1 0 5 0 0 0 22 0\r\n" + 
			"-1 8 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 10 43 0\r\n" + 
			"0 0 5 0 15 0 0 0\r\n" + 
			"0 0 40 0 0 0 20 0";
}
