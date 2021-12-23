package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1244 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int click;
	static int arr[];
	public static void main(String[] args) throws IOException {
		click = Integer.parseInt(br.readLine());
		arr=new int[click+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= click; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int N = Integer.parseInt(br.readLine());
		
		int gender=0,number=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			gender=Integer.parseInt(st1.nextToken());
			number=Integer.parseInt(st1.nextToken());
			switch(gender) {
			case 1:
				boy(number);
				break;
			case 2:
				girl(number);
				break;
			}
		}
		for (int i = 1; i < click+1; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}

	}
	public static void boy(int n) {
		int multi=0;
		for (int i = 1; i <= click; i++) {
			multi=n*i;
			if(multi>click) break;
			change(multi);
		}
	}
	public static void girl(int n) {
		int sym=0;
		for (int i = 1; i <= click/2; i++) {
			if(n+i>click || n-i<1) {
				sym=i-1;
				break;
			}
			if((arr[n+i]!=arr[n-i])) {
				sym=i-1;
				break;
			}
		}
		for (int i = n-sym; i <= n+sym; i++) {
			change(i);
		}
	}
	public static void change(int n) {
		if(arr[n]==1) arr[n]=0;
		else if(arr[n]==0) arr[n]=1;
	}
}
