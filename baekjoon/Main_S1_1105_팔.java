package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S1_1105_팔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();
		
		int answer = 0;
		if(L.length()==R.length()) {
			int n = L.length();
			for (int i = 0; i < n; i++) {
				if(L.charAt(i)==R.charAt(i)) {
					if(L.charAt(i)=='8') {
						answer++;
					}
				} else break;
			}
		}
		
		System.out.println(answer);
	}
	static String src = "1 10";
}
