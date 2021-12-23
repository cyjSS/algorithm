package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G5_13908_비밀번호 {
	static int n,m;
	static int arr[];
	static int status;
	static int inputs[];
	static int Ans;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		status = 0;
		if(m!=0) st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			status |= 1<<Integer.parseInt(st.nextToken());
		}
		inputs = new int[n];
		Ans =0;
		perm(0);
		System.out.println(Ans);
	}
	private static void perm(int cnt) {
		if(cnt==n) {
			int answer =0;
			for (int i = 0; i < n; i++) {
				answer |= 1<<inputs[i];
			}
			if((answer & status)==status) Ans++;
			return;
		}
		for (int i = 0; i <= 9; i++) {
			inputs[cnt] = i;
			perm(cnt+1);
		}
	}
	static String src = "2 0";
}
