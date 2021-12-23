package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_G5_3020_최영진 {
	static int N,H;
	static int arrUp[],arrDown[];
	static int mid;
	static int ans[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arrUp = new int[N/2];
		arrDown = new int[N/2];
		
		ans = new int[H];
		
		for (int i = 0; i < N/2; i++) {
			arrDown[i] = Integer.parseInt(br.readLine());
			arrUp[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arrDown);
		Arrays.sort(arrUp);
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 1; i <= H; i++) {
			int temp = obstacle(0,N/2-1,i,arrDown) + obstacle(0,N/2-1,H+1-i,arrUp);
			
			map.put(temp, map.getOrDefault(temp, 0)+1);
			
			ans[i-1] = temp;
		}
//		sb.append(map.firstKey()).append(" ");
//		sb.append(map.firstEntry().getValue());
		
		Arrays.sort(ans);
		sb.append(ans[0]).append(" ");
		int cnt=0;
		for (int i = 0; i < ans.length; i++) {
			if(ans[i]==ans[0]) cnt++;
		}
		sb.append(cnt);
		
		System.out.println(sb);
	}
	
	
	
	private static int obstacle(int start, int end, int target, int[] arr) {
		if(target>arr[N/2-1]) {
			return 0;
		}
		mid = (start+end)>>1;
		if(start>end) {
			return obstacle(0,N/2-1,target+1,arr);
		}
		if(start==end) {
			return N/2 - mid;
		}
		if(arr[mid]>=target) {
			end = mid;
			return obstacle(start,end,target,arr);
		}else {
			start = mid+1;
			return obstacle(start,end,target,arr);
		}
		
	}



	static String src = "6 7\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"3\r\n" + 
			"3\r\n" + 
			"5\r\n" + 
			"1";
}
