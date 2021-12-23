package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**  문제를 잘 파악안하면 이리저리 헤매다 못 푸는 문제!!!!!!!!!!!!!!!!!!!!!!! 나도 몰랐어!!!!!!!!!!!1*/
/**  규칙을 제대로 찾아..... 이상하다 싶은건 아닌거야!!!!!!!!!!!!!!!!!!!!!!!*/

public class Main_S5_2477_최영진 {
	static int map[][] = new int[500][500];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int map[] = new int[6];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[i] = value;
		}
		int Ans = 0;
		int maxD=0,maxC = 0; int verD=-1,verC = -1;
//		가장 긴(전체 사각형의 세로와 가로) 두 값은 언제나 붙어있다. 이걸 기준으로 빼야하는 사각형의 세로와 가로를 찾자.
		for (int i = 0; i < 6; i++) {
			if(i%2==0) {
				if(map[i]>maxD) {
					maxD = map[i];
					verD = i;
				}
			}else {
				if(map[i]>maxC) {
					maxC = map[i];
					verC = i;
				}
			}
		}
		
		int base = Math.max(verD, verC);
//		반례가 있다. 인덱스의 값이 전체를 넘어설때를 잘 생각하자. => 5와 0인 경우
		if(Math.abs(verC-verD)%5==0) base=0;
		
//		가장 긴 두 값을 기준으로 더 긴 쪽에서 봤을 때 +2인덱스와 +3인덱스가 빼야하는 사각형의 세로와 가로이다.
		Ans = maxD*maxC-map[(base+2)%6]*map[(base+3)%6];
		System.out.println(Ans*K);
	}
	
	static String src = "7\r\n" + 
			"4 50\r\n" + 
			"2 160\r\n" + 
			"3 30\r\n" + 
			"1 60\r\n" + 
			"3 20\r\n" + 
			"1 100";
}
