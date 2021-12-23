package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_5557_1학년 {

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		Queue<Integer> q = new LinkedList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[Integer.parseInt(st.nextToken())] = 1;
		for (int i = 1; i < N-1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j <= 20; j++) {
				if(arr[j]!=0) {
					q.add(j);
				}
			}
			long change[] = new long[21];
			while(!q.isEmpty()) {
				int k = q.poll();
				if(k+temp>=0 && k+temp<=20) change[k+temp] += arr[k];
				if(k-temp>=0 && k-temp<=20) change[k-temp] += arr[k];
			}
			arr = change;
		}
		
		System.out.println(arr[Integer.parseInt(st.nextToken())]);
	}
	static String src = "80\r\n" + 
			"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1";
}
