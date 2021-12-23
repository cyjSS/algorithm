package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_B1_3985_최영진 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int L = Integer.parseInt(br.readLine());
		int cake[] = new int[L+1];
		int N = Integer.parseInt(br.readLine());
		int Ans1 = 0; int pre = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if((end-start+1)>pre) {
				Ans1 = i;
				pre = end-start+1;
			}
			
			for (int j = start; j <= end; j++) {
				if(cake[j]==0) cake[j] = i;
			}
		}
		int Ans2 = 0; int Ans3 = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= L; j++) {
				if(cake[j]==i) cnt++;
			}
			if(cnt>Ans2) {
				Ans2 = cnt;
				Ans3 = i;
			}
		}
		System.out.println(Ans1);
		System.out.println(Ans3);
	}
	static String src = "10\r\n" + 
			"5\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"7 8";
}
