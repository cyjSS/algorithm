package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G4_14267_회사문화1 {
	static int n,m;
	static List<Integer>[] map;
	static int answer[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken())+1;
		m = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[n];
		
		for (int i = 1; i < n; i++) {
			map[i] = new ArrayList<>();
		}
		
		answer = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp!=-1) map[temp].add(i);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			answer[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
		}
		
		dfs(1);
		
		for (int i = 1; i < n; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	private static void dfs(int start) {
		for (int i : map[start]) {
			answer[i] += answer[start];
			dfs(i);
		}
		
	}
	static String src = "5 4\r\n" + 
			"-1 1 2 3 4\r\n" + 
			"2 2\r\n" + 
			"3 4\r\n" + 
			"3 4\r\n" + 
			"5 6";
}
