package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산 {

	static int T,ans;
	static int x1,x2,y1,y2,x3,y3;
	static int matrix[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		matrix = new int[300][300];
		
		int cnt=0;
		for (int i = 300-1;i >=0; i--) {
			int r=i;
			int c=0;
			while(true) {
				matrix[r][c]=++cnt;
				int nr = r+1;
				int nc = c+1;
				if(nr<0 || nr>=300 || nc<0 || nc>=300) break;
				r = nr;
				c = nc;
			}
		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = 0; x1=0; y1=0; x2=0; y2=0; x3=0; y3=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 300; j++) {
					if(matrix[i][j]==p) {
						x1 = 300-i;
						y1 = j+1;
					}
					if(matrix[i][j]==q) {
						x2 = 300-i;
						y2 = j+1;
					}
				}
			}
			x3 = x1+x2;
			y3 = y1+y2;
			ans = matrix[300-x3][y3-1];
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	static String src="2\r\n" + 
			"1 5\r\n" + 
			"3 9";
}
