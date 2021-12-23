package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G2_3109_빵집 {

	static int R,C;
	static boolean fin;
	static int matrix[][];
	static int dr[]= {-1,0,1}, dc[]= {1,1,1};		// 순서가 중요. 
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		matrix = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if(str.charAt(j)=='x') {
					matrix[i][j]=1;
				}
			}
		}
		cnt=0;
		for (int i = 0; i < R; i++) {
			fin=false;
			dfs(i,0);
		}
		System.out.println(cnt);
		
	}

	private static void dfs(int r, int c) {		// 행마다 도착했으면 끝!!!!!!!!!!!!!
		
		matrix[r][c]=1;
		for (int i = 0; i < 3; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<R && nc>=0 && nc<C && matrix[nr][nc]!=1) {
				if(nc==C-1) {
					fin=true;
					cnt++;
					return;
				}
				if(fin) return;
				matrix[nr][nc]=1;
				dfs(nr,nc);
				
			}
		}
	}
	static String src = "6 10\r\n" + 
			"..x.......\r\n" + 
			".....x....\r\n" + 
			".x....x...\r\n" + 
			"...x...xx.\r\n" + 
			"..........\r\n" + 
			"....x.....";
}
