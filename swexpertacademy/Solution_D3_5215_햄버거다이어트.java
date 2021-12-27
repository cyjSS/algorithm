package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {
	static int T;
	static int N;
	static int L;
	static int gradeAns[];
	static int grade[];
	static int limitAns[];
	static int limit[];
	static int max;
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T=scan.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = scan.nextInt();
			L = scan.nextInt();

			grade=new int[N];
			limit=new int[N];
			
			gradeAns=new int[N];
			limitAns=new int[N];
			
			for (int i = 0; i < N; i++) {
				grade[i]=scan.nextInt();
				limit[i]=scan.nextInt();
			}
			int Answer=0;
			for (int i = 1; i <= N; i++) {
				max=0;
				combination(0,i,0);
				Answer=Math.max(Answer, max);
			}
			System.out.println("#"+test_case+" "+Answer);


		}

	}
	private static void combination(int cnt, int num, int start) {
		if(cnt==num) {
			int sum=0;
			
			for (int i = 0; i < num; i++) {
				sum=sum+limitAns[i];
			}
			if(sum<=L) {
				int plus=0;
				for (int i = 0; i < num; i++) {
					plus=plus+gradeAns[i];
					
				}max=Math.max(max, plus);	
			}
			return;
		}

		for (int i = start; i < N ; i++) {
			
			gradeAns[cnt]=grade[i];
			limitAns[cnt]=limit[i];
			combination(cnt+1,num,i+1);
		}
		
	}

}
