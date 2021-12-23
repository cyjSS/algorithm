package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S1_2527_직사각형 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		br = new BufferedReader(new StringReader(src));

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			if((x2==x3 && y2==y3) || (x1==x4 && y2==y3) || (x2==x3 && y1==y4) ||(x1==x4 && y1==y4)) {
				System.out.println("c");
			} else if((x2==x3 && y2!=y3) || (x1==x4 && y2!=y3) || (x2!=x3 && y1==y4) || (x1!=x4 && y1==y4)) {
				System.out.println("b");
			} else if(x2<x3 || x4<x1 || y2<y3 || y4<y1) {
				System.out.println("d");
			} else {
				System.out.println("a");
			}
		}
	}
	static String src = "3 3 50 50 3 3 50 50\r\n" + 
			"45 50 600 600 400 450 500 543\r\n" + 
			"11 120 120 230 50 40 60 440\r\n" + 
			"35 56 67 90 67 80 500 600";
}
