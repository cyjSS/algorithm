package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_G5_1747_소수팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(br.readLine());
		int inf = 1111111;
		
		int arr[] = new int[inf];
		arr[1] = 1;
		
		for (int i = 2; i < inf; i++) {
			if(arr[i]==0) {
				if((int)Math.pow(i, 2)>inf) break;
				else {
					for (int j = (int)Math.pow(i, 2); j < inf; j=j+i) {
						arr[j] = 1;
					}
				}
			}
		}
		
		int answer = 0;
		for (int i = N; i < inf; i++) {
			if(arr[i]==1) continue;
			String str = String.valueOf(i);
			int n = str.length();
			int cnt = 0;
			for (int j = 0; j < n/2; j++) {
				if(str.charAt(j)==str.charAt(n-1-j)) cnt++;
			}
			if(cnt==n/2) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}
	static String src = "102";
}
