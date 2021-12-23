package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char map[] = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		stack.add(map[0]);
		int idx = 1; int cnt = 0;
		while(N-->=0) {
			if(idx==map.length) {
				for (int i = cnt; i < M; i++) {
					stack.pop();
				}
				break;
			}
			if(cnt==M) {
				for (int i = idx; i < map.length; i++) {
					stack.add(map[i]);
				}
				break;
			}
			while(!stack.isEmpty() && map[idx]>stack.peek()) {
				if(cnt==M) break;
				stack.pop();
				cnt++;
			}
			stack.add(map[idx]);
			idx++;
		}
		
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb.reverse());
	}
	static String src= "10 9\r\n" + 
			"9876543211";
}
