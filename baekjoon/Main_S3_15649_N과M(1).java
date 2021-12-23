package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S3_15649_최영진 {

	static int N,M;
	static int[] input;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[M];
		visited = new boolean[N+1];
		
		permutation(0);
	}
	private static void permutation(int cnt) {
		if(cnt==M) {
			for(int j:input) {
				System.out.print(j+" ");
			}System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			input[cnt] = i;
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
		
	}
	static String src = "4 4";
}
