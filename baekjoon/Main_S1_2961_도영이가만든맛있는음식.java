package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S1_2961_최영진 {
	static int N,Ans=Integer.MAX_VALUE;
	static int sin[], sseun[];
	static boolean isSelected[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		
		sin = new int[N];
		sseun = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			sseun[i] = Integer.parseInt(st.nextToken());
		}
		subSet(0);
		System.out.println(Ans);
	}

	private static void subSet(int cnt) {
		if(cnt==N) {
			int multi=1; int sum=0; int minus=0; int gong=0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					multi*=sin[i];
					sum+=sseun[i];
				}else {
					gong++;
				}
			}
			if(gong==N) return;
			minus = Math.abs(multi-sum);
			Ans = Math.min(Ans, minus);
			return;
		}
		isSelected[cnt]=true;
		subSet(cnt+1);
		isSelected[cnt]=false;
		subSet(cnt+1);
		
	}

	static String src = "4\r\n" + 
			"1 7\r\n" + 
			"2 6\r\n" + 
			"3 8\r\n" + 
			"4 9";
}
