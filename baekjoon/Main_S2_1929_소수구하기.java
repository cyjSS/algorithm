package baekjoon;
/**이거 아니야~~~~~~~~~~~~~~~~~~~~~~~*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_1929_최영진 {

	static int N,M;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		
		for (int i = N; i <= M; i++) {
			int cnt=0;
			for (int j = 2; j < i; j++) {
				if(i%j==0) cnt++;
			}
			if(cnt==0) {
				System.out.println(i);
			}
			
		}
		
	}
	static String src = "3 16";

}
