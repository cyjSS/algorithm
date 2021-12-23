package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_3190_뱀 {
	static class Tail{
		int x; int y;
		public Tail(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Tail> tail;
	static class Move{
		int time;
		String dir;
		public Move(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
	}
	static ArrayList<Move> move;
	static int N,K,L;
	static int map[][];
	static boolean visited[][];
	static int dr,dc,nr,nc;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine())+1;
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		move = new ArrayList<Move>(L);
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			move.add(new Move(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		
		tail = new ArrayList<Tail>(N*N);
		visited = new boolean[N][N];
		
		dr = 0; dc = 1; ans =0;
		go(1,1,0,1,1);
		System.out.println(ans+1);
	}
	private static void go(int r, int c, int game, int rtail, int ctail) {
		if(move.size()!=0 && game==move.get(0).time) {
			if(move.get(0).dir.equals("D")) {
				if(dr==0&&dc==1) {
					dr = 1; dc=0;
				}else if(dr==1&&dc==0) {
					dr = 0; dc=-1;
				}else if(dr==0&&dc==-1) {
					dr=-1; dc=0;
				}else if(dr==-1&&dc==0) {
					dr=0; dc=1;
				}
			}else {
				if(dr==0&&dc==1) {
					dr = -1; dc=0;
				}else if(dr==1&&dc==0) {
					dr = 0; dc=1;
				}else if(dr==0&&dc==-1) {
					dr=1; dc=0;
				}else if(dr==-1&&dc==0) {
					dr=0; dc=-1;
				}
			}
			move.remove(0);
		}
		ans = game;
		visited[r][c] = true;
		tail.add(new Tail(r,c));
		nr = r+dr;
		nc = c+dc;
		if(nr<1 || nr>=N || nc<1 || nc>=N) return;
		else if(visited[nr][nc]) return;
		else {
			if(map[nr][nc]==1) {
				map[nr][nc] =0;
				go(nr, nc, game+1, rtail, ctail);
			}else {
				visited[rtail][ctail] = false;
				tail.remove(0);
				if(tail.size()==0) go(nr, nc, game+1, nr,nc);
				else go(nr,nc,game+1,tail.get(0).x, tail.get(0).y);
			}
		}
		
	}
	static String src = "10\r\n" + 
			"5\r\n" + 
			"1 5\r\n" + 
			"1 3\r\n" + 
			"1 2\r\n" + 
			"1 6\r\n" + 
			"1 7\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
}
