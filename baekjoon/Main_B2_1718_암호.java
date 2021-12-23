package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main_B2_1718_최영진 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String text = br.readLine();
		char Ans[]=new char[text.length()];
		String key = br.readLine();
		int run = text.length()/key.length()+1;
		
		int temp=0;
		for (int i = 0; i < text.length(); i++) {
			
			if(text.charAt(i)==' ') {
				Ans[i]=' ';
				continue;
			}
			for (int j = 0; j < run; j++) {// 나누기로 해서 하면 간단하게 되는구나!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				if(i>= j*key.length()&& i<(j+1)*key.length()) {
					temp = text.charAt(i)-key.charAt(i-j*key.length());
				}
			}
			
			if(temp<=0) temp+=26;
			Ans[i]=(char) (temp+96);
		}
		for (char c : Ans) {
			System.out.print(c);
		}
	}
	static String src = "nice day\r\n" + 
			"love";

}
