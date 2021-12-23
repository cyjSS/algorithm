package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_B1_2999_비밀이메일 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		String str = br.readLine();
		int n = str.length();
		int r = (int) Math.sqrt(n);
		int m = 0;
	
		for (int i = r; i >= 0; i--) {
			if(n%i==0) {
				m = i;
				break;
			}
		}
		int cnt = 0;
		int run = n/m;
		while(run-->0) {
			for (int i = 0; i < n; i++) {
				if((i%m)==cnt) System.out.print(str.charAt(i));
			}
			cnt++;
		}
	}
	static String src = "boudonuimilcbsai";
}
