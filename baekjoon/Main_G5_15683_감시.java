package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_15683_감시 {
	static class Camera{
		int x,y,num,dir;
		public Camera(int x, int y, int num, int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
	}
	static ArrayList<Camera> camera;
	static int N,M;
	static int map[][];
	static boolean check[][];
	static int number[];
	static int d[][]= {	{0,0,0,0,0,0},
						{0,0b0001,0b0011,0b1001,0b1101,0},
						{0,0b0010,0b1100,0b1010,0b1011,0},
						{0,0b0100,0b0011,0b0110,0b1110,0},
						{0,0b1000,0b1100,0b0101,0b0111,0},
						{0,0,0,0,0,0b1111}
						};
	static int dr[]= {-1,1,0,0},dc[]= {0,0,-1,1};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int wallCnt =0;
		map = new int[N][M];
		camera = new ArrayList<>(8);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp>0 && temp<6) camera.add(new Camera(i,j,temp,0));
				else if(temp==6) wallCnt++;
			}
		}
		
		number = new int[camera.size()];
		answer = 0;
		perm(0);
		System.out.println(N*M-answer-wallCnt);
	}
	private static void perm(int cnt) {
		if(cnt==camera.size()) {
			for (int i = 0; i < cnt; i++) {
				if(camera.get(i).num==5) camera.get(i).dir = 5;
				else camera.get(i).dir = number[i];
			}
			monitor(cnt);
			return;
		}
		for (int i = 1; i <= 4; i++) {
			number[cnt] = i;
			perm(cnt+1);
		}
	}
	private static void monitor(int total) {
		check = new boolean[N][M];
		for (int i = 0; i < total; i++) {
			check[camera.get(i).x][camera.get(i).y] = true;
			for (int j = 0; j < 4; j++) {
				if((d[camera.get(i).dir][camera.get(i).num]&1<<j)==0) continue;
				int nr = camera.get(i).x + dr[j];
				int nc = camera.get(i).y + dc[j];
				while(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=6) {
					check[nr][nc] = true;
					nr += dr[j];
					nc += dc[j];
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check[i][j]) cnt++;
			}
		}
		answer = Math.max(answer, cnt);
	}
	static String src = "3 7\r\n" + 
			"4 0 0 0 0 0 0\r\n" + 
			"0 0 0 2 0 0 0\r\n" + 
			"0 0 0 0 0 0 4";
}
