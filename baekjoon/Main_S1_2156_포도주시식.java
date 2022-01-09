package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S1_2156 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		int joo[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			joo[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(joo[0]);
			return;
		}else if(N==2) {
			System.out.println(joo[0]+joo[1]);
			return;
		}
		int D[] = new int[N];
		D[0] = joo[0];
		D[1] = joo[0] + joo[1];
		D[2] = Math.max(D[1], joo[1] + joo[2]);
		D[2] = Math.max(D[2], joo[0] + joo[2]);
		if(N==3) {
			System.out.println(D[2]);
			return;
		}
		for (int i = 3; i < N; i++) {
			D[i] = Math.max(D[i-1], D[i-3]+joo[i]+joo[i-1]);
			D[i] = Math.max(D[i], D[i-2]+joo[i]);
		}
		System.out.println(D[N-1]);

	}
	static String src = "6\r\n" + 
			"6\r\n" + 
			"10\r\n" + 
			"13\r\n" + 
			"9\r\n" + 
			"8\r\n" + 
			"1";
}
