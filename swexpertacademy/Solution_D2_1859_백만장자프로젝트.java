package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자프로젝트 {

	static int map[];
	static long Ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/milli.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			Ans=0;
			milli(0,N);
			System.out.println("#"+test+" "+(Ans*-1));
		}
		
	}
	private static void milli(int start, int end) {
		if(start==end) return;
		int max=0; int ver = -1;
		for (int i = start; i < end; i++) {
			if(map[i]>max) {
				max = map[i];
				ver = i;
			}
		}
		for (int i = start; i < ver; i++) {
			Ans += map[i];
		}
		Ans -= map[ver]*(ver-start);
		milli(ver+1, end);
		
	}
	static String src = "3\r\n" + 
			"3\r\n" + 
			"10 7 6\r\n" + 
			"3\r\n" + 
			"3 5 9\r\n" + 
			"5\r\n" + 
			"1 1 3 1 2";
}
