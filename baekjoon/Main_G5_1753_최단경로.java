package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1753 {
	static class Node{
		int start;
		Node end;
		int weight;
		public Node(int start, Node end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken())+1;
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		Node map[] = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[u] = new Node(v,map[u],w);
		}

		boolean []visited = new boolean[V];
		int distance[] = new int[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		int min = 0; int cur=0;
		for (int i = 1; i < V; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 1; j < V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					cur = j;
				}
			}
			visited[cur] = true;
			
			for (Node j = map[cur]; j!=null; j = j.end) {
				if(!visited[j.start] && distance[j.start]>min+j.weight) {
					distance[j.start] = min+j.weight;
				}
			}
		}
		for (int i = 1; i < V; i++) {
			if(distance[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	static String src = "5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
}
