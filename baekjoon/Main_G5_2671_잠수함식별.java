package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_G5_2671_잠수함식별 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		String str = br.readLine();

		String result = "";
		boolean out = false;
		while(true) {
			if(out) {
				result = "NOISE";
				break;
			}
			if(str.length()==0) {
				result = "SUBMARINE";
				break;
			}
			
			int i = 0;
			if(str.charAt(i)=='1') {
				if(str.length()<4) out = true;
				else {
					if(str.charAt(i+1)=='0' && str.charAt(i+2)=='0') {
						int j = i+2;
						while(str.charAt(j)=='0') {
							if(j==str.length()-1) {
								out = true;
								break;
							}
							j++;
						}
						if(!out) {
							int k = j;
							while(str.charAt(k)=='1') {
								if(k==str.length()-1) break;
								k++;
							}
							if(k==str.length()-1)	str = str.substring(k+1);
							else {
								if(k+1==str.length()) out = true;
								else {
									if(str.charAt(k+1)=='0') {
										if(str.charAt(k-2)=='1') str = str.substring(k-1);
										else out = true;
									}
									else str = str.substring(k);
								}
							}
						}
					}else {
						out = true;
					}
				}
			}else {
				if(str.charAt(i+1)=='1') {
					str = str.substring(2);
				}else {
					out = true;
				}
			}
		}
		
		System.out.println(result);
	}
	static String src = "10000001000111111111111111111111111111111111111111111100101";
}
