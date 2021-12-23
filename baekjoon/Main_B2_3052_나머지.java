package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_B2_3052_최영진 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		long status  =  0;
		for (int i = 0; i < 10; i++) {
			long temp = Long.parseLong(br.readLine());
			status |= (long)1<<(temp%42);
		}
		System.out.println(Long.bitCount(status));
	}
	static String src = "1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"6\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"9\r\n" + 
			"10";
}
