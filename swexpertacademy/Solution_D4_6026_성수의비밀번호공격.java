package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D4_6026_성수의비밀번호공격 {

	static int N,M;
	static long P;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			long D[][] = new long[M+1][M+1];
			
			P = 1000000007;
			for (int i = 0; i <= M; i++) {
				for (int j = 1; j <= M; j++) {
					if(i==0 || i==j) D[j][i] = 1L;
					else D[j][i] = (D[j-1][i-1] + D[j-1][i])%P;
				}
			}
			
			long Ans = power(M,N);
			int K = M;
			while(true) {
//				System.out.println(Ans);
				if(K<=1) break;
				K--;
				Ans -= (D[M][K]*power(K,N))%P;
				if(Ans<0) Ans +=P;
				if(K<=1) break;
				K--;
				Ans += (D[M][K]*power(K,N))%P;
			}
			System.out.println("#"+test+" "+(Ans%P));
		}
	}
	
	static long power(long a, int b) {
		if(b==1) return a;
		long pow = power(a, b/2);
		long powr = (pow*pow)%P;
		if(b%2==1) powr = (powr*a)%P;
		return powr%P;
	}
	
	static String src =
			"10\r\n" + 
			"12 80\r\n" + 
			"47 99\r\n" + 
			"31 65\r\n" + 
			"1 99\r\n" + 
			"56 89\r\n" + 
			"12 78\r\n" + 
			"13 56\r\n" + 
			"12 88\r\n" + 
			"2 75\r\n" + 
			"6 99";
}
