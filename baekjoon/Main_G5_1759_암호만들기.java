package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1759_최영진 {

	static int L,C;
	static char matrix[];
	static char numbers[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		String str1 = str.replaceAll(" ","");
		matrix = str1.toCharArray();
		Arrays.sort(matrix);
		
		numbers = new char[L];
		combination(0,0);
	}
	private static void combination(int cnt, int start) {
		if(cnt==L) {
			int count=0;
			for (int i = 0; i < L; i++) {
				if(numbers[i]=='a' || numbers[i]=='e' || numbers[i]=='i' || numbers[i]=='o' || numbers[i]=='u') count++;
			}
			if(count!=0 && count<=L-2) {
				for (char c : numbers) {
					System.out.print(c);
				}System.out.println();
			}
			return;
		}
		for (int i = start; i < C; i++) {
			numbers[cnt] = matrix[i];
			combination(cnt+1, i+1);
		}
	}
	static String src = "4 6\r\n" + 
			"a t c i s w";
}
