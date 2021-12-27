package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int T,N;
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		Stack<String> stack3 = new Stack<>();
		T=Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 1; i <= N/2; i++) {
				stack1.push(st.nextToken());
			}
			for (int i = N/2+1; i <=N ; i++) {
				stack2.push(st.nextToken());
			}
			for (int i = 0; i <= N/2+1; i++) {
				if(stack2.isEmpty()) break;
				stack3.push(stack2.pop());
				if(stack1.isEmpty()) break;
				stack3.push(stack1.pop());
			}
			System.out.print("#"+test_case);
			if(N%2==1) {
				str=stack3.pop();
				for (int i = 0; i < N-1; i++) {
					System.out.print(" "+stack3.pop());
				}System.out.print(" "+str);
			}
			else {
			for (int i = 0; i < N; i++) {
				System.out.print(" "+stack3.pop());
			}
			}
			System.out.println();
		}
	}
}
