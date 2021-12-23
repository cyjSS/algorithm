package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_G2_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(br.readLine());
		
		int map[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int LIS[] = new int[N];
		int idxM[] = new int[N];
		
		int idx = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {	// j : i의 앞쪽 원소
				if(map[j] < map[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j] + 1;
					idxM[i] = j;
				}
			}
			if(max<LIS[i]) {
				max = LIS[i];
				idx = i;
			}
		}
		
		int answer[] = new int[max];
		for (int i = max-1; i >= 0; i--) {
			answer[i] = map[idx];
			idx = idxM[idx];
		}
//		System.out.println(Arrays.toString(map));
//		System.out.println(Arrays.toString(LIS));
//		System.out.println(Arrays.toString(idxM));
		System.out.println(max);
//		System.out.println(Arrays.toString(answer));
		for (int i : answer) {
			System.out.print(i+" ");
		}
	}
	static String src = "6\r\n" + 
			"10 20 10 30 30 40";
}
