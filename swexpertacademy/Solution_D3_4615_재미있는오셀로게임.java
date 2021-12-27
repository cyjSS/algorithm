package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 {

	static int T,N,M;
	static int matrix[][];
	static int black,white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			matrix = new int[N][N];
			matrix[N/2-1][N/2-1]=2;
			matrix[N/2-1][N/2]=1;
			matrix[N/2][N/2-1]=1;
			matrix[N/2][N/2]=2;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int col = Integer.parseInt(st.nextToken());
				matrix[x][y]=col;
				play(x,y,col);
			}
			black=0; white=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(matrix[i][j]==1) black++;
					else if(matrix[i][j]==2) white++;
				}
			}
			System.out.println("#"+test+" "+black+" "+white);
			
			
		}
	}
	private static void play(int r, int c,int color) {
		int dr[]= {-1,1,0,0,-1,-1,1,1};
		int dc[]= {0,0,-1,1,-1,1,-1,1};
		
		for (int i = 0; i < 8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			while(true) {
				if(nr<0 || nr>=N || nc<0 || nc>=N || matrix[nr][nc]==0) break;
				
				if(matrix[nr][nc]!=matrix[r][c]){
					nr = nr +dr[i];
					nc = nc +dc[i];
				}
				
				else break;
			}
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && matrix[nr][nc]==matrix[r][c]) {
				while( r!= nr || c!=nc ) {
					matrix[nr][nc] = matrix[r][c];
					nr = nr-dr[i];
					nc = nc-dc[i];
				}
			}
			
		}
		
	}
	static String src =  
			"1\r\n" + 
			"4 12\r\n" + 
			"1 2 1\r\n" + 
			"1 1 2\r\n" + 
			"4 3 1\r\n" + 
			"4 4 2\r\n" + 
			"2 1 1\r\n" + 
			"4 2 2\r\n" + 
			"3 4 1\r\n" + 
			"1 3 2\r\n" + 
			"2 4 1\r\n" + 
			"1 4 2\r\n" + 
			"4 1 2\r\n" + 
			"3 1 2";
}
