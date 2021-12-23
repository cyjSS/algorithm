package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Main_G4_16916_부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		char first[] = br.readLine().toCharArray();
		char second[] = br.readLine().toCharArray();
		
		int lenF = first.length;
		int lenS = second.length;
		
		int fail[] = new int[lenS];
		for (int i = 1, j = 0; i < lenS; i++) {
			while(j>0 && second[i]!=second[j]) j = fail[j-1];
			
			if(second[i]==second[j]) fail[i] =++j;
		}
		System.out.println(Arrays.toString(fail));
		for (int i = 0, j = 0; i < lenF; i++) {
			while(j>0 && first[i] !=second[j]) j = fail[j-1];
			
			if(first[i]==second[j]) {
				if(j==lenS-1) {
					System.out.println(1);
					return;
				}else {
					j++;
				}
			}
		}
		
		System.out.println(0);
	}
	static String src = "baaaaaaekjoon\r\n" + 
			"aaaeaaa";
}
