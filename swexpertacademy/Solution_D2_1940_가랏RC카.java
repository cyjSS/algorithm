package swexpertacademy;

import java.util.Scanner;

public class Solution_D2_1940_가랏RC카 {

	static int T, N, command;
	static int vel, acc;
	static int total;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = scan.nextInt();
			vel=0;
			acc=0;
			total=0;
			for (int i = 0; i < N; i++) {
				command = scan.nextInt();
				switch(command) {
				case 0 :
					
					break;
				case 1 :
					acc = scan.nextInt();
					vel = vel+acc;
					break;
				case 2 :
					acc = scan.nextInt();
					if((vel-acc)>=0) {
						vel = vel-acc;
					}else {
						vel = 0;
					}
					break;
				}
				total = total+vel;
			}
			System.out.println("#"+test_case+" "+total);
		}
	}

}
