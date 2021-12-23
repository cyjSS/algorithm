package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_G4_9935_문자열폭발 {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String first = br.readLine();
		String second = br.readLine();
		
		char[] result = new char[first.length()];
		int idx=0;
		for (int i = 0; i < first.length(); i++) {
			result[idx] = first.charAt(i);
			if(idx>=second.length()-1) {
				int cnt =0;
				for (int j = 0; j < second.length(); j++) {
					if(second.charAt(j)==result[idx-second.length()+1+j]) cnt++;
				}
				if(cnt==second.length()) idx -= second.length();
			}
			idx++;
		}
		String answer = String.valueOf(result,0,idx);
		if(answer.equals("")) System.out.println("FRULA");
		else System.out.println(answer);
		
		
	}
	static String src = "12ab112ab2ab\r\n" + 
			"12ab";
}
