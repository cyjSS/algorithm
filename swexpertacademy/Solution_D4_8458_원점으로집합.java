package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D4_8458_원점으로집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T;test++) {
			int N = Integer.parseInt(br.readLine());
			int cntE =0; int cntO=0;
			int max =0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int temp = Math.abs(Integer.parseInt(st.nextToken()))+Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(max, temp);
				if(temp%2==0) cntE++;
				else cntO++;
			}
			
			sb.append("#"+test+" ");
			if(cntE * cntO==0) {
				if(max==0) {
					sb.append(0).append("\n");
					continue;
				}
				int n = 1;
				
				int sum = n;
				while(true) {
					if(max<=sum && Math.abs(max-sum)%2==0) break;
					
					n++;
					sum += n;
				}
				sb.append(n).append("\n");
			}else sb.append(-1).append("\n");
		}
		System.out.println(sb);
	}
	static String src = 
			"3\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"0 0\r\n" + 
			"2\r\n" + 
			"-6 0\r\n" + 
			"3 3\r\n" + 
			"2\r\n" + 
			"-5 0\r\n" + 
			"2 2";
}
