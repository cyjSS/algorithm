package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_test_5644_무선충전 {
	static int M,A;
	static int user[][];
	static class BC implements Comparable<BC>{
		int x, y, cov, per;
		public BC(int x, int y, int cov, int per) {
			this.x = x;
			this.y = y;
			this.cov = cov;
			this.per = per;
		}
		@Override
		public int compareTo(BC o) {
			return o.per-this.per;
		}
	}
	static BC bc[];
	static int dr[]= {0, -1, 0, 1, 0}, dc[] = {0, 0, 1, 0, -1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			user = new int[2][M+1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					user[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				bc[i] = new BC(Y, X, C, P);
			}
			
			Arrays.sort(bc);
			int rA = 1, cA = 1, rB= 10, cB = 10;
			int resultA[] = new int[M+1]; int resultB[] = new int[M+1];
			int resultAD[] = new int[M+1]; int resultBD[] = new int[M+1];
			for (int i = 0; i <= M; i++) {
				boolean cnt[] = new boolean[3];
				int count =0;
				rA += dr[user[0][i]];
				cA += dc[user[0][i]];
				rB += dr[user[1][i]];
				cB += dc[user[1][i]];
				for (int j = 0; j < A; j++) {
					if((cnt[0]&&cnt[2]) || (cnt[0]&&cnt[1]) || cnt[1]&&cnt[2] || count==2) break;
					if(locCheck(rA, cA, j) && locCheck(rB, cB, j)) {
						resultAD[i] += bc[j].per/2;
						resultBD[i] += bc[j].per/2;
						++count;
						cnt[0]=true;
					}else if(locCheck(rA, cA, j) && !locCheck(rB, cB, j)) {
						resultA[i] = Math.max(resultA[i], bc[j].per);
						cnt[1]=true;
					}else if(!locCheck(rA, cA, j) && locCheck(rB, cB, j)) {
						resultB[i] = Math.max(resultB[i], bc[j].per);
						cnt[2]=true;
					}
				}
			}
			int Ans = 0;
			for (int i = 0; i <= M; i++) {
				Ans += resultA[i]+resultB[i]+resultAD[i]+resultBD[i];
			}
			System.out.println("#"+test+" "+Ans);
		}
		
	}
	private static boolean locCheck(int i, int j, int a) {
		if(Math.abs(bc[a].x-i)+Math.abs(bc[a].y-j)<=bc[a].cov) return true;
		else return false;
	}
	
}
