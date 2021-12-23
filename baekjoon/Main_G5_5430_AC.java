package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G5_5430_AC {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		

		int T = Integer.parseInt(br.readLine());
		One:
		for (int test = 1; test <= T; test++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String temp = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
			int map[] = new int[N];
			StringTokenizer st = new StringTokenizer(temp);
			for (int i = 0; i < N; i++) {
				map[i]=Integer.parseInt(st.nextToken());
			}
			
			int fb = 1;
			int front = 0;
			int back = N-1;
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i)=='R') {
					fb *= -1;
					continue;
				}else cnt++;
				if(cnt>N) {
					sb.append("error");
					System.out.println(sb);
					continue One;
				}
				
				if(fb==-1) {
					map[back] = 0;
					 back--;
				}else {
					map[front] = 0;
					front++;
				}
				
			}
			
			int answer[] = new int[N];
			int count=0;
			if(fb==-1) {
				for (int i = N-1; i >= 0; i--) {
					if(map[i]!=0) answer[count++]=map[i];
				}
			}else {
				for (int i = 0; i < N; i++) {
					if(map[i]!=0) answer[count++]=map[i];
				}
			}
			
			sb.append("[");
			if(count!=0) {
				for (int i = 0; i < count-1; i++) {
					sb.append(answer[i]).append(",");
				}sb.append(answer[count-1]);
			}
			sb.append("]");
			System.out.println(sb);
		}
	}
	static String src = "1\r\n" + 
			"R\r\n" + 
			"1\r\n" + 
			"[1]";
}
