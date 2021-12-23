package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1107_리모컨 {
	static int answer[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		String str = br.readLine();
		int ans = Integer.parseInt(str);
		N = Integer.parseInt(br.readLine());
		int status = 0;
		
		if(N!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				status |= 1<<Integer.parseInt(st.nextToken());
			}
		}
		
		answer = new int[1000000];
		Arrays.fill(answer, Integer.MAX_VALUE);
		for (int i = 0; i < 1000000; i++) {
			int input = 0; int cnt =1;
			int temp = i;
			while(temp>9) {
				input |= 1<<temp%10;
				temp /= 10;
				cnt++;
			}
			input |= 1<<temp;
			if((status & input)==0) answer[i] = cnt;
		}
		
		answer[100] = 0;
		
		int result = answer[ans];
		for (int i = ans-1; i >= 0; i--) {
			if(answer[i]!=Integer.MAX_VALUE) {
				result = Math.min(result, answer[i]+ans-i);
			}
		}
		for (int i = ans+1; i < 1000000; i++) {
			if(answer[i]!=Integer.MAX_VALUE) {
				result = Math.min(result, answer[i]+i-ans);
			}
		}
		System.out.println(result);
		
	}
	
	static String src = "150\r\n" + 
			"0";
}
