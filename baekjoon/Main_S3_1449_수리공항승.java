package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S3_1449 {

	static int N,L,cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>(N);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		cnt=1;
		int tape = list.get(0);
		for (int i = 1; i < N; i++) {
			if(tape+L-1 < list.get(i)) {
				cnt++;
				tape = list.get(i);
			}
		}
		System.out.println(cnt);
		
	}
	static String src= "4 2\r\n" + 
			"1 2 100 101";
	

}
