package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S1_1052_최영진 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
//		String str = Integer.toBinaryString(N);
		int Ans = 0;
		while(true) {
			int cnt = Integer.bitCount(N);
			if(cnt<=K) break;
			N++;
			Ans++;
		}
		System.out.println(Ans);
	}
	static String src = "31 1";
}
