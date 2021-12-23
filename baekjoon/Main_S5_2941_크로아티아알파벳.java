package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_S5_2941_최영진 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int cnt=0;
		String str = br.readLine();
		String map[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		for (int i = 0; i < 8; i++) {
			while(str.contains(map[i])) {
			if(str.contains(map[i])) {
				cnt++;
				str = str.replaceFirst(map[i]," ");
			}
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)!=' ') cnt++; 
		}
		System.out.println(cnt);

	}
	static String src = "ljes=njak";
}
