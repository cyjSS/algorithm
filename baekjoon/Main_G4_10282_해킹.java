package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_10282_해킹 {
	static class Computer implements Comparable<Computer>{
		int a; int b; int weight;

		public Computer(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		@Override
		public int compareTo(Computer o) {
			return this.weight-o.weight;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Computer [a=").append(a).append(", b=").append(b).append(", weight=").append(weight)
					.append("]");
			return builder.toString();
		}
		
	}
	static int n,d,c;
	static int min[];
	static ArrayList<Computer> computer[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			min = new int[n+1];
			Arrays.fill(min, Integer.MAX_VALUE);
			
			computer = new ArrayList[n+1];
			for (int i = 1; i < n+1; i++) {
				computer[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				computer[e].add(new Computer(s, e, w));
			}
			
			
			PriorityQueue<Computer> queue = new PriorityQueue<Computer>();
			boolean check[] = new boolean[n+1];
			queue.add(new Computer(c, 0, 0));
			min[c] = 0;
			while(!queue.isEmpty()) {
				Computer start = queue.poll();
//				System.out.println(start);
//				if(check[start.a]) {
//					continue;
//				}
				check[start.a] = true;
				for (int j = 0; j <computer[start.a].size() ; j++) {
					int f = computer[start.a].get(j).a;
					int k = computer[start.a].get(j).b;
					int t = computer[start.a].get(j).weight;
					if(min[f] > min[k]+t) {
						min[f] = min[k]+t;
						queue.add(computer[start.a].get(j));
					}
//					System.out.println(Arrays.toString(min));
					
				}
			}
			int cnt = 0; int time = 0;
			for (int i = 1; i < n+1; i++) {
				if(min[i]!=Integer.MAX_VALUE) {
					cnt++;
					time = Math.max(time, min[i]);
				}
			}
			sb.append(cnt+" "+time).append("\n");
		}
		System.out.println(sb);
	}

}
