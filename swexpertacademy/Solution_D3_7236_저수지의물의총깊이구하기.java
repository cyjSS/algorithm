package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_7236_저수지의물의총깊이구하기 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			String map[][] = new String [N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken();
				}
			}
			int dr[] = {-1,1,0,0,-1,-1,1,1};
			int dc[] = {0,0,-1,1,-1,1,-1,1};
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					if(map[i][j].equals("W")) {
						for (int k = 0; k < 8; k++) {
							
							int nr = i + dr[k];
							int nc = j + dc[k];
							if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc].equals("W")) {
								cnt++;
							}
						}
						max = Math.max(max, cnt);
					}
				}
			}
			System.out.print("#"+test+" ");
			if(max==0) System.out.println(1);
			else System.out.println(max);
			
		}
	}
	static String src = "4\r\n" + 
			"6\r\n" + 
			"G W G G W W\r\n" + 
			"G W G G W G\r\n" + 
			"W W W W G W\r\n" + 
			"W G W W W G\r\n" + 
			"G W W W W G\r\n" + 
			"G W W G W G\r\n" + 
			"5\r\n" + 
			"G W G G W\r\n" + 
			"G W G G W\r\n" + 
			"W W W W G\r\n" + 
			"W G W W W\r\n" + 
			"G W W W W\r\n" + 
			"3\r\n" + 
			"G G W\r\n" + 
			"G W W\r\n" + 
			"W W W\r\n" + 
			"3\r\n" + 
			"G G G\r\n" + 
			"G W G\r\n" + 
			"G G G";
}
