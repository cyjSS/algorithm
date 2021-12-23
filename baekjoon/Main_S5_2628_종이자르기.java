package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_2628 {

	static boolean C[]; 
	static boolean R[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		C = new boolean [c];
		R = new boolean [r];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(check==0) R[value] = true;
			else C[value] = true;
		}
		int cnt = 0;
		int maxR = 0;
		int maxC = 0;
		for (int i = 0; i < r; i++) {
			if(R[i]) cnt=0;
			cnt++;
			maxR = Math.max(maxR, cnt);
		}
		cnt = 0;
		for (int i = 0; i < c; i++) {
			if(C[i]) cnt=0;
			cnt++;
			maxC = Math.max(maxC, cnt);
		}
		System.out.println(maxR*maxC);
	}
	static String src = "10 8\r\n" + 
			"3\r\n" + 
			"0 3\r\n" + 
			"1 4\r\n" + 
			"0 2";
}
