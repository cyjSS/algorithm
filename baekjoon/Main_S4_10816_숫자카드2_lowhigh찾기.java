package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_10816_lowhigh찾기 {

	static int N,M,cnt;
	static int arr[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(highFind(0,N,temp)-lowFind(0,N,temp)).append(" ");
//			sb.append(highFind(arr,temp)-lowFind(arr,temp)).append(" ");
			
		}
		System.out.println(sb);
		
	}
	
	private static int lowFind(int start, int end, int target) {	//이상의 값이 처음으로 ,왼쪽부터 볼때 찾고자하는 값이 같거나 큰 경우를 처음 만나는 위치
		int mid = (start+end)>>1;
		if(start>end) {	//이부분 없어도 된다
			return 0;
		}
		if(start==end) {
			return mid;
		}
		if(arr[mid]>=target) {
			end = mid;
			return lowFind(start,end,target);
		}else {
			start = mid+1;
			return lowFind(start,end,target);
		}
	}
	private static int highFind(int start, int end, int target) {	//초과한 값이 처음으로, 찾고자 하는 값이 더이상 넘어갈 수 없는 위치
		int mid = (start+end)>>1;
		if(start>end) {
			return 0;
		}
		if(start==end) {
			return mid;
		}
		if(arr[mid]>target) {
			end = mid;
			return highFind(start,end,target);
		}else {
			start = mid+1;
			return highFind(start,end,target);
		}
	}
	
	
	
	
	
	
	
//	private static int lowFind(int []arr, int target) {
//		int lo = 0;
//		int hi = arr.length;
//		while(lo < hi) {
//			int mid = (lo+hi)>>1;
//		if(target <= arr[mid]) {
//			hi = mid;
//		}else {
//			lo = mid+1;
//		}
//		}
//		return lo;
//	}
//	private static int highFind(int []arr, int target) {
//		int lo = 0;
//		int hi = arr.length;
//		while(lo < hi) {
//			int mid = (lo+hi)>>1;
//		if(target < arr[mid]) {
//			hi = mid;
//		}else {
//			lo = mid+1;
//		}
//		}
//		return lo;
//	}

	static String src = "10\r\n" + 
			"6 3 2 10 10 10 -10 -10 7 3\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
}
