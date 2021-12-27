package swexpertacademy;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_1228_8일차암호문1 {

	static int L,N;
	static int index;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			LinkedList<Integer> link = new LinkedList<>();
			L = scan.nextInt();
			for (int i = 0; i < L; i++) {
				link.add(scan.nextInt());
			}
			N = scan.nextInt();
			for (int i = 0; i <N ; i++) {
				scan.next();
				LinkedList<Integer> addL = new LinkedList<>();
				index = scan.nextInt();
				cnt = scan.nextInt();
				for (int j = 0; j < cnt; j++) {
					addL.add(scan.nextInt());
				}
				link.addAll(index, addL);
			}
			System.out.print("#"+test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+link.get(i));
			}
			System.out.println();
			
			
		}
	}

}
