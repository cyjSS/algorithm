package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B2_13300_최영진 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int girl[] = new int[7];
		int boy[] = new int[7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			if(gen==1) {
				boy[grade]++;
			}else {
				girl[grade]++;
			}
		}
		int Ans = 0;
		for (int i = 1; i <= 6; i++) {
			if(boy[i]!=0) {
			if(boy[i]%K!=0) Ans += boy[i]/K+1;
			if(boy[i]%K==0) Ans += boy[i]/K;
			}
			if(girl[i]!=0) {
			if(girl[i]%K!=0) Ans += girl[i]/K+1;
			if(girl[i]%K==0) Ans += girl[i]/K;
			}
		}
		System.out.println(Ans);
		
	}
	static String src = "3 3\r\n" + 
			"0 3\r\n" + 
			"1 5\r\n" + 
			"0 6";
}
