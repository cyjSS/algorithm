package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S3_2491_최영진 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int n = Integer.parseInt(br.readLine());
		int map[] = new int[n];
		if(n==1) {
			System.out.println(1);
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			map[i] = temp;
		}
		int cnt = 1; int Ans = 0;
		for (int i = 0; i < n-1; i++) {
			if(map[i+1]>=map[i]) cnt++;
			else cnt=1;
			Ans = Math.max(Ans, cnt);
		}
		cnt = 1;
		for (int i = 0; i < n-1; i++) {
			if(map[i+1]<=map[i]) cnt++;
			else cnt = 1;
			Ans = Math.max(Ans, cnt);
		}
		
		System.out.println(Ans);
	}
	static String src = "1\r\n" + 
			"1";
}
