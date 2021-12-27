package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_6일차계산기2 {
	public static int getPriorty(char ch, boolean isInstack) {
		switch (ch) {
		case '+': case '-':
			return 1;
		case '*': case '/':
			return 2;
		default:
			return isInstack? 0 :3;   // (면  0을 리턴   면 3을 리턴
		}
	}
	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new FileReader("res/PostfixNotation.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		int N;
		Stack<Character> stack =new Stack<>();
		StringBuilder expression;
		char temp, top;
		char[] line;
		for (int testcase = 1; testcase <=T; testcase++) {
			N = Integer.parseInt(in.readLine().trim());
			expression = new StringBuilder(N);
			line = in.readLine().toCharArray();
			//step1. 후위 표기식 만들기 
			for (int i = 0; i <N; i++) {
				temp = line[i];
				if(temp == ' ') {				//공백인 경우 처리 안함
					continue;
				}
				if(Character.isDigit(temp)) {	//피연산자인 경우 
					expression.append(temp);
				}else if(temp == ')') {			//')' 라면 '('나올 때까지 pop
					while ( !stack.isEmpty() && (top= stack.pop()) !='(') {
						expression.append(top);
					}
				}else {							//+,-   *,/  (
					while( !stack.isEmpty()) {//우선 순위가 같거나 높은 연산자 먼저 처리 하기 
						if(getPriorty(stack.peek(), true) < getPriorty(temp, false)) break;
						expression.append(stack.pop());
					}	
					stack.push(temp);
				}
			}
			//스택에  남은 연산자를 출력 
			while(!stack.isEmpty()) {
				expression.append(stack.pop());
			}
			Stack<Integer> stack2 = new Stack<>();
			line = expression.toString().toCharArray();
			int size = line.length;
			int num1, num2;
			for (int i = 0; i < size; i++) {
				temp = line[i];
				if(Character.isDigit(temp)) {	//피연산자
					stack2.push(temp-'0');
				}else {							//연산자
					num1 = stack2.pop();
					num2 = stack2.pop();
					switch(temp) {
					case '+': stack2.push(num2+num1); break;
					case '-': stack2.push(num2-num1); break;
					case '*': stack2.push(num2*num1); break;
					case '/': stack2.push(num2/num1); break;
					}
				}
			}
			System.out.println("#"+testcase+" "+stack2.pop());
		}
	}
}
