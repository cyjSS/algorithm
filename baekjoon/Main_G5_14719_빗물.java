package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G5_14719_빗물 {
	static int H,W;
	static int input[];
	static boolean map[][];
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		input = new int[W+1];
		map = new boolean[H+1][W+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= W; i++) {
			int height = Integer.parseInt(st.nextToken());
			input[i] = height;
			for (int j = 1; j <= height; j++) {
				map[j][i] = true;
			}
		}
		
		for (int t = 1; t <= W; t++) {
			findLeft(t);
			findRight(t);
		}
		
		System.out.println(answer);
	}
	private static void findRight(int start) {
		for (int i = start+1; i <= W; i++) {
			if(input[i]>=input[start]) {
				check(start,i,input[start]);
				return;
			}
		}
	}
	private static void findLeft(int start) {
		for (int i = start-1; i >= 1; i--) {
			if(input[i]>=input[start]) {
				check(i,start,input[start]);
				return;
			}
		}
	}
	private static void check(int r, int c, int hei) {
		for (int i = r+1; i < c; i++) {
			for (int j = 1; j <= hei; j++) {
				if(!map[j][i]) {
					answer++;
					map[j][i] = true;
				}
			}
		}
	}
	static String src = "3 5\r\n" + 
			"0 0 0 2 0";
}
