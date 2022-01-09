package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
/** 그냥 짝수일때는 CY 홀수면 SK이면 끝인 코드였어.....*/

public class Main_S5_9655 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		while(n>0) {
			if(n<3) n-=1;
			else n-=3;
			cnt++;
		}
		if(cnt%2==0) System.out.println("CY");
		else System.out.println("SK");
	}
	static String src = "1000";
}
