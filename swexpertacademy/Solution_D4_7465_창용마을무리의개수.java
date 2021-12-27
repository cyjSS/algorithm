package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	private static void make(int n) {
		map = new int[n+1];
		for (int i = 1; i <= n; i++) {
			map[i] = i;
		}
	}
	private static void union(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		
		map[jRoot] = iRoot;
		
	}
	private static int find(int x) {
		if(x == map[x]) return x;
		return map[x] = find(map[x]);
	}
	static int map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			make(N);
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				union(start,end);
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 1; i <= N; i++) {
				find(i);
				map.put(find(i), 0);
			}
			System.out.println("#"+test+" "+map.size());
			
		}

	}
	static String src = 
			"1\r\n" + 
			"7 3\r\n" + 
			"1 3\r\n" + 
			"3 4\r\n" + 
			"6 7";
}
