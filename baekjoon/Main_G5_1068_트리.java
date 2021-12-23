package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G5_1068_트리 {
	static int N;
	static int map[][];
	static boolean answer[];
	static int die;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp!=-1) map[i][temp] = 1; 
		}
		
		die = Integer.parseInt(br.readLine());
		answer = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[j][i]==1 && j!=die) answer[i]=true;
			}
		}
		dfs(die);
		int ans =0;
		for (int i = 0; i < N; i++) {
			if(!answer[i]) ans++;
		}
		System.out.println(ans);
	}
	private static void dfs(int kill) {
		answer[kill] = true;
		for (int i = 0; i < N; i++) {
			if(map[i][kill]==1) dfs(i);
		}
	}
	static String src = "16\r\n" + 
			"-1 0 0 0 1 3 3 9 4 5 5 6 6 7 7 8\r\n" + 
			"8";
}
