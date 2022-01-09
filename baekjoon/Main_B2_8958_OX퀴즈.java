package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_B2_8958_OX퀴즈 {

	static int T;
	static int cnt,sum;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			cnt=0; sum=0;
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)=='O') {
					cnt++;
				}else {
					cnt=0;
				}
				sum+=cnt;
			}
			System.out.println(sum);
		}
		
		
	}
	static String src = "5\r\n" + 
			"OOXXOXXOOO\r\n" + 
			"OOXXOOXXOO\r\n" + 
			"OXOXOXOXOXOXOX\r\n" + 
			"OOOOOOOOOO\r\n" + 
			"OOOOXOOOOXOOOOX";
}
