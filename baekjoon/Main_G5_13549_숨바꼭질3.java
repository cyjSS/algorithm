package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_13549_숨바꼭질3 {
	static int N,K;
	static int map[];
	static boolean visited[];
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[200001];
		map[N] = -1;
		map[K] = 1;
		
		visited = new boolean[200001];
		answer = 0;
		bfs(N);
		System.out.println(answer);
	}
	private static void bfs(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		queue.add(new int[] {start,0});
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			visited[cur[0]] = true;
			if(map[cur[0]]==1) {
				answer = cur[1];
				return;
			}
			if(cur[0]*2<200001 && !visited[cur[0]*2]) {
				queue.add(new int[] {cur[0]*2,cur[1]});
			}
			if(cur[0]+1<200001 && !visited[cur[0]+1]) {
				queue.add(new int[] {cur[0]+1,cur[1]+1});
			}
			if(cur[0]-1>-1 && !visited[cur[0]-1]) {
				queue.add(new int[] {cur[0]-1,cur[1]+1});
			}
		}
	}
	static String src = "3 30";
}
