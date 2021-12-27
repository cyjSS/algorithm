package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D3_1234_10일차비밀번호 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		for (int test = 1; test <= 10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			String matrix[] = {"00","11","22","33","44","55","66","77","88","99"};
			while(true) {
				int cnt = 0;
				for (int i = 0; i < 10; i++) {
					if(str.contains(matrix[i])) {
						str = str.replace(matrix[i], "");
					}
				}
				for (int i = 0; i < 10; i++) {
					if(!str.contains(matrix[i])) cnt++;
				}
				if(cnt==10) break;
			}
			
			System.out.println("#"+test+" "+str);
		}
	}
	static String src = "10 1238099084\r\n" + 
			"16 4100112380990844\r\n" + 
			"26 12380990844100112380990844\r\n" + 
			"42 123809908444100112380990844100112380990844\r\n" + 
			"55 1238099084441001123809908441001321238099084432180990844\r\n" + 
			"60 123809908444100145351123809908441001321238099084432180990844\r\n" + 
			"71 12380990844410013218099084441001123809908441001321238099084432180990844\r\n" + 
			"99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844\r\n" + 
			"82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844\r\n" + 
			"58 0899809812380990844100132123809908441238099084432180990844";
}
