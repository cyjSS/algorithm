package swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_test_4014_활주로건설 {
	static int N, X;
	static int map[][], rmap[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			// 행과 열 확인 따로 안만들려고 역행렬 만들기
			map = new int[N][N]; rmap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rmap[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if(check(i,map)) ans++;
				if(check(i,rmap)) ans++;
			}
			
			System.out.println("#"+test+" "+ans);
		}
		
	}
	
	private static boolean check(int start, int[][] arr) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[start][i]);
		}
		for (int i = 0; i < N; i++) {
			if(arr[start][i]==max) {
				// 꼭대기에서 앞으로 활주로 만들 수 있는지 확인
				if(!isAvailable(start, 0, i-1, max, arr, "f")) return false;
				// 꼭대기에서 뒤로 활주로 만들 수 있는지 확인
				if(!isAvailable(start, i+1, N-1, max, arr, "b")) return false;
			}
		}
		// 모든 max 기준으로 앞 뒤 다 가능하면 true
		return true;
	}						
//								     확인하고 있는 행/열, 시작점, 	   끝점,    비교할 높이, 		     행렬, 	          앞/뒤 
	private static boolean isAvailable(int loc, int s, int e, int height, int[][] arr, String fb) {
		// 1차이 나는 경우 카운트
		int cnt =0;
		
		// 앞쪽 확인과 뒤쪽 확인이 시작점과 끝점이 달라서 따로 구현
		// 앞쪽을 확인할 경우 N-1에서 0방향으로 체크
		if(fb.equals("f")) {
			for (int i = e; i >= s; i--) {
				// 비교할 높이와 같은 경우 이전에 파인곳이 있고 그 수가 2*X보다 작으면 false, 아닌 경우 계속 진행
				if(arr[loc][i]==height) {
					if(cnt>0 && cnt<2*X) return false;
					continue;
				}
				// 비교할 높이와 1초과 차이날 경우 전까지의 cnt가 X보다 큰 경우 활주로를 만들었기 때문에 다시 isAvailable로 가능 여부 체크
				if(height-arr[loc][i]>1) {
					if(cnt<X) return false;
					else {
						if(!isAvailable(loc,s,i,height-1, arr,"f")) return false;
						else return true;
					}
				}
				if(height-arr[loc][i]==1) {
					cnt++;
				}
			}
		}
		// 뒤쪽 확인할 경우 0에서 N-1방향으로 체크
		else {
			for (int i = s; i <= e; i++) {
				if(arr[loc][i]==height) {
					if(cnt>0 && cnt<2*X) return false;
					continue;
				}
				if(height-arr[loc][i]>1) {
					if(cnt<X) return false;
					else {
						if(!isAvailable(loc,i,e,height-1,arr,"b")) return false;
						else return true;
					}
				}
				if(height-arr[loc][i]==1) {
					cnt++;
				}
			}
		}
		if(cnt!=0 && cnt<X) return false;
		
		return true;
	}
	static String src = 
			"1\r\n" + 
			"6 2\r\n" + 
			"3 3 3 3 3 3\r\n" + 
			"2 3 3 3 3 3\r\n" + 
			"2 2 2 3 2 3\r\n" + 
			"1 1 1 2 2 2\r\n" + 
			"1 1 1 3 3 1\r\n" + 
			"1 1 2 3 3 2";
}
