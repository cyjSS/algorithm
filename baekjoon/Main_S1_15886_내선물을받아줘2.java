package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S1_15886_최영진 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int cnt = 0;
		if(str.charAt(0)=='W') cnt++;
		if(str.charAt(N-1)=='E') cnt++;
		while(true) {
			if(str.contains("EW")) {
				str = str.replaceFirst("EW", " ");
				cnt++;
			}
			if(!str.contains("EW")) break;
		}
		System.out.println(cnt);
	}
	static String src = "6\r\n" + 
			"EEWWEW";
}
