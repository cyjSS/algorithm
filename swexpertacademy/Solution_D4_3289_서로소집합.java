package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;


public class Solution_D4_3289_서로소집합 {

	
	private static void make() {
		map = new int[n+1];
		for (int i = 1; i <= n; i++) {
			map[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==map[a]) return a;
		return map[a] = find(map[a]);
	}
	
	private static void union(int a , int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		map[bRoot] = aRoot;
	}
	
	private static boolean check(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return true;
		else return false;
	}
	
	static int T,n,m;
	static int map[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			make();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int S = Integer.parseInt(st.nextToken());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(S==0) {
					union(start,end);
				}else {
					if(check(start,end)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}
	static String src = "1\r\n" + 
			"7 8\r\n" + 
			"0 1 3\r\n" + 
			"1 1 7\r\n" + 
			"0 7 6\r\n" + 
			"1 7 1\r\n" + 
			"0 3 7\r\n" + 
			"0 4 2\r\n" + 
			"0 1 1\r\n" + 
			"1 1 1";
}
