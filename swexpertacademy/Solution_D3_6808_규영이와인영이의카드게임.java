package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {

	static int T,cnt,win,lose,ansWin,ansLose;
	static int gyu[], in[], numbers[];
	static boolean isSelected[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			gyu = new int[9];
			in = new int[9];
			numbers = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
			}
			int index=0;
			for (int i = 1; i <= 18; i++) {
				cnt=0;
				for (int j = 0; j < 9; j++) {
					if(i==gyu[j]) cnt++;
				}
				if(cnt==0) {
					in[index++]=i;
				}
			}
			isSelected = new boolean[9];
			ansWin=0; ansLose=0;
			permutation(0);
			System.out.println("#"+test_case+" "+ansWin+" "+ansLose);
		}
	}
	private static void permutation(int cnt) {
		if(cnt == 9) {
			win=0; lose=0;
			for (int i = 0; i < 9; i++) {
				if(gyu[i] > numbers[i]) {
					win+=gyu[i]+numbers[i];
				}
				else if(gyu[i] < numbers[i]) {
					lose+=gyu[i]+numbers[i];
				}
			}
			if(win>lose) {
				ansWin++;
			}else if(win<lose) {
				ansLose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = in[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}
	static String src = "4\r\n" + 
			"1 3 5 7 9 11 13 15 17\r\n" + 
			"18 16 14 12 10 8 6 4 2\r\n" + 
			"13 17 9 5 18 7 11 1 15\r\n" + 
			"1 6 7 9 12 13 15 17 18";

}
