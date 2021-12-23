package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_S1_16953_AB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int ans =1;
		while(true) {
			if(B%2==1) {
				if(B%10==1) B /= 10;
				else {
					ans =-1;
					break;
				}
			}
			else B /= 2;
			ans++;
			if(B==A) break;
			if(B<A) {
				ans =-1;
				break;
			}
		}
		System.out.println(ans);
	}
	static String src = "2 162";
}
