package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {

	static int T,N;
	static int input[];
	static int sum, count;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			count=0;
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				input[i] = temp;
			}
			Arrays.sort(input);
			do {
				subset(0,0,0);
			}while(np(input));
			
			System.out.println("#"+test+" "+count);
		}
		
	}
	private static void subset(int cnt, int left, int right) {
		if(cnt==N) {
			count++;
			return;
		}
		
		subset(cnt+1,left+input[cnt],right);
		
		if(left>=right+input[cnt]) {
			subset(cnt+1,left,right+input[cnt]);
		}
		
	}
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		
		swap(numbers, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}

	private static void swap(int[] numbers,int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	static String src = 
			"3\r\n" + 
			"3\r\n" + 
			"1 2 4\r\n" + 
			"3\r\n" + 
			"1 2 3\r\n" + 
			"9\r\n" + 
			"1 2 3 5 6 4 7 8 9";
}
