package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 시간 2700ms => 이건 아닌거 같다
 *
 */
public class Main_G5_2866_문자열잘라내기 {
	static int R,C;
	static String map[];
	static String cal[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R];
		cal = new String[C];
		Arrays.fill(cal, "");
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine();
			for (int j = 0; j < C; j++) {
				cal[j] += map[i].charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cal[j] = cal[j].substring(1);
			}
			Arrays.sort(cal);
			if(!check(i+1)) {
				System.out.println(i);
				break;
			}
		}
	}
	private static boolean check(int start) {
		for (int i = 0; i < C; i++) {
			if(Arrays.binarySearch(cal, cal[i])!=i) {
				return false;
			}
		}
		return true;
	}
	static String src = "2 6\r\n" + 
			"dobarz\r\n" + 
			"adatak";
}
