package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Main_S3_17413_최영진 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		String str = br.readLine();
		int i=0;
		while(i<str.length()) {
			if((str.charAt(i)>=97 && str.charAt(i)<123)||(str.charAt(i)-48>=0 && str.charAt(i)-48<10)) {
				Stack<Character> stack = new Stack<>();
				stack.push(str.charAt(i));
				while(true) {
					if(i+1==str.length() || str.charAt(i+1)==' '||str.charAt(i+1)=='<') break;
					i++;
					stack.push(str.charAt(i));
				}
				while(!stack.isEmpty()) System.out.print(stack.pop());
			}else if(str.charAt(i)=='<') {
				while(true) {
					if(str.charAt(i)=='>') {
						i--;
						break;
					}
					System.out.print(str.charAt(i));
					i++;
				}
			}else System.out.print(str.charAt(i));
			i++;
		}
		
		

	}
	static String src = "<   space   >space space space<    spa   c e>";
}
