package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S5_2578_최영진 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int status[] = new int[12];
		
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				temp = Integer.parseInt(st.nextToken())-1;
				status[i] |= 1<<temp;
				status[j+5] |= 1<<temp;
				if(i==j) status[10] |= 1<<temp;
				if(i+j==4) status[11] |= 1<<temp;
			}
		}
		
		int person = 0;
		int Ans = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int tp = Integer.parseInt(st.nextToken())-1;
				person |= 1<<tp;
				int cnt = 0;
				Ans++;
				for (int k = 0; k < 12; k++) {
					if((status[k] & person)==status[k]) cnt++;
				}
				if(cnt>=3) {
					System.out.println(Ans);
					return;
				}
			}
		}
	}
	static String src = "11 12 2 24 10\r\n" + 
			"16 1 13 3 25\r\n" + 
			"6 20 5 21 17\r\n" + 
			"19 4 8 14 9\r\n" + 
			"22 15 7 23 18\r\n" + 
			"5 10 7 16 2\r\n" + 
			"4 22 8 17 13\r\n" + 
			"3 18 1 6 25\r\n" + 
			"12 19 23 14 21\r\n" + 
			"11 24 9 20 15";
}
