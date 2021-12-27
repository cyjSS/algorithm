package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_7일차암호생성기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T,num,count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> queue = new LinkedList<>();
		for (int test_case = 1; test_case <= 10; test_case++) {
			num=0;
			queue.clear();
			T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			One:
			while(true) {
				for (int i = 1; i <= 5; i++) {
					num = queue.poll();
					if(num-i<=0) {
						queue.offer(0);
						break One;
					}else queue.offer(num-i);
				}
			}
			System.out.print("#"+T);
			for (int i = 0; i < 8; i++) {//queue.size는 변동이니까 while로 하자
				System.out.print(" "+queue.poll());
			}
			System.out.println();
			
		}

	}

}
