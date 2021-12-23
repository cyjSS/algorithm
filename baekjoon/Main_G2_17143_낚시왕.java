package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G2_17143_낚시왕 {
	static int R,C,M;
	static class Shark{
		int r,c,speed,dir,size;
		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	static Shark shark[];
	static int map[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		shark = new Shark[M+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			shark[i] = new Shark(x, y, Integer.parseInt(st.nextToken()),
											Integer.parseInt(st.nextToken()),
											Integer.parseInt(st.nextToken()));
			map[x][y] = i;
		}
		
		int ans = 0;
		for (int i = 1; i < C+1; i++) {
			for (int j = 1; j < R+1; j++) {
				// 처음 만나는 상어 잡아먹기
				if(map[j][i]!=0) {
					ans += shark[map[j][i]].size;
					// 잡아먹은 상어 체크하기 => size를 0으로!!!
					shark[map[j][i]].size = shark[map[j][i]].speed = 0;
					// map에도 체크해주기
					map[j][i] = 0;
					break;
				}
			}
			sharkMove();
			map = mapMove();
		}
		System.out.println(ans);
		
	}
	private static int[][] mapMove() {
		int change[][] = new int[R+1][C+1];
		for (int i = 1; i <= M; i++) {
			// 이미 잡아먹은 상어는 넘기고
			if(shark[i].size==0) continue;
			// 0이면 바로 넣고
			if(change[shark[i].r][shark[i].c]==0) {
				change[shark[i].r][shark[i].c] = i;
			}
			else {
				// 기존에 있는거보다 사이즈크면
				if(shark[change[shark[i].r][shark[i].c]].size < shark[i].size) {
					// 기존 상어 죽이기!!!
					shark[change[shark[i].r][shark[i].c]].size = shark[change[shark[i].r][shark[i].c]].speed = 0;
					change[shark[i].r][shark[i].c] = i;
				// 기존꺼가 더 크면 현재 상어 죽이기!!!	
				}else {
					shark[i].size = shark[i].speed = 0;
				}
			}
		}
		return change;
	}
	private static void sharkMove() {
		int dr[]= {0,-1,1,0,0}; int dc[]= {0,0,0,1,-1};
		for (int i = 1; i <= M; i++) {
			int cnt = 0;
			if(shark[i].dir<3) cnt = shark[i].speed%(2*(R-1));
			else cnt = shark[i].speed%(2*(C-1));
			
			int nr = shark[i].r;
			int nc = shark[i].c;
			for (int j = 1; j <= cnt; j++) {
				nr = nr+dr[shark[i].dir];
				nc = nc+dc[shark[i].dir];
				if(nr>0 && nr<=R && nc>0 && nc<=C) {
					continue;
				}else {
					nr -= dr[shark[i].dir];
					nc -= dc[shark[i].dir];
					shark[i].dir = shark[i].dir%2==0? shark[i].dir-1:shark[i].dir+1;
					nr += dr[shark[i].dir];
					nc += dc[shark[i].dir];
				}
			}
			shark[i].r = nr;
			shark[i].c = nc;
		}
		
	}
	static String src = "100 100 0";
}
