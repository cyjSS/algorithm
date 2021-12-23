package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S2_2304_최영진 {

	static int N;
	static int LH[][];
	static int Ans, high, low;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		LH = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			LH[i][0] = l;
			LH[i][1] = h;
		}
		
		Arrays.sort(LH, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		Ans = 0; high = 0; low = 0;
		storeH(0);
		storeL(N-1);
		System.out.println(Ans);
	}
	private static void storeL(int end) {
		low = LH[end][1];
		for (int i = end-1; i >= 0; i--) {
			if(LH[i][1]>low) {
				Ans -= (high-low)*(LH[end][0]-LH[i][0]);
				storeL(i);
				return;
			}
		}
	}
	private static void storeH(int start) {
		Ans += (LH[start][1]-high)*(LH[N-1][0]-LH[start][0]+1);
		high = LH[start][1];
		for (int i = start+1; i < N; i++) {
			if(LH[i][1]>high) {
				storeH(i);
				return;
			}
		}
	}
	static String src = "7\r\n" + 
			"2 4\r\n" + 
			"11 4\r\n" + 
			"15 8\r\n" + 
			"4 6\r\n" + 
			"5 3\r\n" + 
			"8 10\r\n" + 
			"13 9";
}
