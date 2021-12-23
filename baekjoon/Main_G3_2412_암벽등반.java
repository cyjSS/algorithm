package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_G31_2412_최영진 {

	static int n,T;
	static class rock implements Comparable<rock>{
		int x;
		int y;
		int cnt;
		public rock(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(rock o) {
			return this.x-o.x==0? this.y-o.y:this.x-o.x;
		}
	}
	static List<rock> rocks;
	static Queue<rock> queue = new LinkedList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		rocks = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			rocks.add(new rock(r,c,0));
		}
		Collections.sort(rocks);
		System.out.println(bfs());
	}
	private static int bfs() {
		queue.add(new rock(0,0,0));
		while(!queue.isEmpty()) {
			rock cur = queue.poll();
			System.out.println(cur.x+" "+cur.y+" "+cur.cnt);
			if(cur.y==T) return cur.cnt;
			if(rocks.get(0).x>cur.x+2 || rocks.get(n-1).x<cur.x-2) continue;
			int s = lowSearch(0,n,cur.x-2);
			int e = highSearch(0,n,cur.x+2);
			for (int i = s; i < e; i++) {
				if(rocks.get(i).y<cur.y-2 || rocks.get(i).y>cur.y+2) continue;
				rocks.get(i).cnt=cur.cnt+1;
				queue.add(rocks.get(i));
				rocks.remove(i);
				n--;
//				System.out.println(rocks.get(n-1).x+" "+rocks.get(n-1).y+" "+rocks.get(n-1).cnt);
			}
			
		}
		return -1;
	}
	private static int highSearch(int start, int end, int target) {
		int mid = (start+end)>>1;
		if(start>end) return highSearch(0, n, target-1);
		if(start==end) return mid;
		if(rocks.get(mid).x>target) {
			end = mid;
			return highSearch(start,end,target);
		}else {
			start = mid+1;
			return highSearch(start, end, target);
		}
		
	}
	private static int lowSearch(int start, int end, int target) {
		int mid = (start+end)>>1;
		if(start>end) return lowSearch(0, n, target+1);
		if(start==end) return mid;
		if(rocks.get(mid).x>=target) {
			end = mid;
			return lowSearch(start,end,target);
		}else {
			start = mid+1;
			return lowSearch(start, end, target);
		}
	}
	static String src = "5 3\r\n" + 
			"1 2\r\n" + 
			"6 3\r\n" + 
			"4 1\r\n" + 
			"3 2\r\n" + 
			"0 2";
}
