package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1074_Z {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken())+1;
		int c = Integer.parseInt(st.nextToken())+1;
		
		int map[][] = new int[3][3];
		map[0][0] = 0; map[1][1] = 1; map[1][2] = 2; map[2][1] = 3; map[2][2] = 4;
		
		int answer = 0;
		for (int i = N; i > 0; i--) {
			int no = (int) Math.pow(2, i);
			if(r<=no && c<=no) continue;
			if(c > no) {
				answer += no*no;
				c -= no;
			}
			if(r > no) {
				answer += 2*no*no;
				r -= no;
			}
		}
		
		answer += map[r][c];
		
		System.out.println(answer-1);
	}
}
