package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_1263 {
	static class Time implements Comparable<Time>{
		int start,end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
			int temp = o.end - this.end;
			if(temp==0) temp = o.start - this.start;
			return temp;
		}
	}
	static int N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		Time time[] = new Time[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(time);
		
		int jin=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			jin = Math.min(jin, time[i].end);
			jin -= time[i].start;
		}
		if(jin>0) System.out.println(jin);
		else System.out.println(-1);
	}
	static String src = "4\r\n" + 
			"3 5\r\n" + 
			"8 14\r\n" + 
			"5 20\r\n" + 
			"1 16";
}
