package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1446_최영진 {
	static class Car implements Comparable<Car>{
		int start, end, weight;

		public Car(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Car o) {
			int gap = this.end - o.end;
			if(gap==0) gap = this.start - o.start;
			return gap;
		}
	}
	static int N,D;
	static Car car[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		car = new Car[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			car[i] = new Car(start,end,weight);
		}
		
		Arrays.sort(car);
//		for (int i = 0; i < N; i++) {
//			System.out.println(car[i].start+" "+car[i].end+" "+car[i].weight);
//		}
		
		int distance[] = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[0] = car[0].start + car[0].weight;
		
		int min = 0, cur = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if(min>distance[j]) {
					if(car[j].weight>car[j].end-car[j].start) continue;
					min = distance[j];
					cur = j;
				}
			}
			for (int j = 0; j < N; j++) {
				if(car[j].start>=car[cur].end) {
					if(car[j].end-car[j].start>car[j].weight) {
						distance[j] = Math.min(car[j].start+car[j].weight ,min+car[j].start-car[cur].end+car[j].weight);
					}
				}else {
					distance[j] = Math.min(min-car[cur].weight+car[j].start-car[cur].start+car[j].weight, min+car[j].end-car[cur].start);
					
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
		int Ans = Integer.MAX_VALUE;
		for (int j = 0; j < N; j++) {
			if(distance[j]!=Integer.MAX_VALUE && car[j].end<=D) {
				Ans = Math.min(Ans, distance[j]+D-car[j].end);
//				System.out.println(j+" "+Ans);
			}
		}
		System.out.println(Ans);
		
	}
	static String src = "5 150\r\n" + 
			"0 50 10\r\n" + 
			"0 50 20\r\n" + 
			"30 90 5\r\n" + 
			"100 151 10\r\n" + 
			"110 140 90";
}
