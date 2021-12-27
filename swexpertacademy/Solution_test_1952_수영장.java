package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_test_1952_수영장 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_Case = 1; test_Case <= T; test_Case++) {
			int pay[]=new int[4];
			int month[]= new int[13];
			int arr[]=new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				pay[i]=Integer.parseInt(st.nextToken());
			}
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i]=Integer.parseInt(st1.nextToken());
			}
			for (int i = 1; i <= 12; i++) {
				
				arr[i] = Math.min(pay[0]*month[i]+arr[i-1] , pay[1]+arr[i-1]);
				if(i>=3) {
					arr[i] = Math.min(arr[i], pay[2]+arr[i-3]);
				}
				if(i==12) {
					arr[i] = Math.min(arr[i], pay[3]);
				}
				
			}
			System.out.println("#"+test_Case+" "+arr[12]);
			
			
		}

	}

}
