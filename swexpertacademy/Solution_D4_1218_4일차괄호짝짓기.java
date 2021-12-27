package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_4일차괄호짝짓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int test_case = 1; test_case <= 10; test_case++) {
			Stack<Character> stack = new Stack<>();
			result=0;
			N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			for (int i = 0; i < N; i++) {
				char m = s.charAt(i);
				if( m=='(' || m=='[' || m=='{' || m=='<' ) {
					stack.push(m);
				}
				
				if( m==')') {
					if( !stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
					}else break;
				}

				if( m==']' || m=='}' || m=='>' ) {
					if( !stack.isEmpty() && stack.peek()==m-2) {
						stack.pop();
					}else break;
				}
			}
			if(stack.isEmpty()) result=1;
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}
