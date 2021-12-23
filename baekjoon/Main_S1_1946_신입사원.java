package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S1_1946_신입사원 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int map[][] = new int[N+1][3];
			
			HashMap<Integer, int[]> mapF = new HashMap<>();
			HashMap<Integer, int[]> mapE = new HashMap<>();
			
			
			int fVer = -1; 
			int eVer = -1;
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				mapF.put(first, new int[] {end,i});
				mapE.put(end, new int[] {first,i});
				map[i][1]=first; map[i][2]=end;
				if(first==1) fVer = end;
				if(end==1) eVer = first;
			}
			
			
			boolean check[][] = new boolean[N+1][3];
			for (int i = 1; i <= N; i++) {
				if(fVer>=mapF.get(i)[0]) {
					fVer = mapF.get(i)[0];
					check[mapF.get(i)[1]][2]=true;
				}
				if(eVer>=mapE.get(i)[0]) {
					eVer = mapE.get(i)[0];
					check[mapE.get(i)[1]][1]=true;
				}
			}
			
			int Ans = 0;
//			System.out.println(Arrays.deepToString(check));
			for (int i = 1; i <= N; i++) {
				if(check[i][1]&&check[i][2]) Ans++;
			}
			
			System.out.println(Ans);
			
		}
	}
	static String src = "2\r\n" + 
			"2\r\n" + 
			"2 1\r\n" + 
			"1 2\r\n" + 
			"7\r\n" + 
			"3 6\r\n" + 
			"7 3\r\n" + 
			"4 2\r\n" + 
			"1 4\r\n" + 
			"5 7\r\n" + 
			"2 5\r\n" + 
			"6 1";
}
