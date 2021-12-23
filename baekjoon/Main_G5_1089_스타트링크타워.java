package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1089_스타트링크타워 {
	static int N;
	static char map[][];
	static int all[][][]=	{
							{{1,1,1},{1,0,1},{1,0,1},{1,0,1},{1,1,1}},
							{{0,0,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}},
							{{1,1,1},{0,0,1},{1,1,1},{1,0,0},{1,1,1}},
							{{1,1,1},{0,0,1},{1,1,1},{0,0,1},{1,1,1}},
							{{1,0,1},{1,0,1},{1,1,1},{0,0,1},{0,0,1}},
							{{1,1,1},{1,0,0},{1,1,1},{0,0,1},{1,1,1}},
							{{1,1,1},{1,0,0},{1,1,1},{1,0,1},{1,1,1}},
							{{1,1,1},{0,0,1},{0,0,1},{0,0,1},{0,0,1}},
							{{1,1,1},{1,0,1},{1,1,1},{1,0,1},{1,1,1}},
							{{1,1,1},{1,0,1},{1,1,1},{0,0,1},{1,1,1}}
							};
	static boolean answer[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new char[5][];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		answer = new boolean[N][10];
		for (int i = 0; i < N; i++) {
			Arrays.fill(answer[i], true);
		}
		
		for (int i = 0; i < 5; i++) {
			int idx = 0;
			while(idx<4*N-1) {
				if(idx%4==3) idx++;
				for (int j = 0; j < 10; j++) {
					if(map[i][idx]=='#'&&all[j][i][idx%4]==0) {
						answer[idx/4][j] = false;
					}
				}
				idx++;
			}
		}
		
		double cnt[] = new double[N];
		double result[] = new double[N];
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < 10; i++) {
				if(answer[j][i]) {
					result[j] += i*Math.pow(10, N-1-j);
					cnt[j]++;
				}
			}
		}
		
		double otherCnt[] = new double[N];
		Arrays.fill(otherCnt, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				otherCnt[i] *= cnt[j];
			}
		}
		
		double total = 0;
		double totalCnt = 1;
		for (int i = 0; i < N; i++) {
			totalCnt *= cnt[i];
			total += result[i] * otherCnt[i];
		}
		
		if(totalCnt==0) System.out.println(-1);
		else System.out.println(total/totalCnt);
	}
	static String src = "3\r\n" + 
			"###.###.###\r\n" + 
			"#.#.#.#.#.#\r\n" + 
			"###.#.#.#.#\r\n" + 
			"#.#.#.#.#.#\r\n" + 
			"###.###.###";
}
