package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G5_1461_도서관 {
	static int N,M;
	static class Loc implements Comparable<Loc>{
		int weight;
		public Loc(int weight) {
			this.weight = weight;
		}
		@Override
		public int compareTo(Loc o) {
			return this.weight-o.weight;
		}
	}
	static ArrayList<Loc> neg;
	static ArrayList<Loc> pos;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		neg = new ArrayList<>();
		pos = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp>0) pos.add(new Loc(temp));
			else neg.add(new Loc(temp));
		}
		Collections.sort(neg);
		Collections.sort(pos);
		
		result = 0;
		if(neg.size()==0) {
			calPos();
			result -= pos.get(pos.size()-1).weight;
		}else if(pos.size()==0) {
			calNeg();
			result -= (neg.get(0).weight)*-1;
		}else if(neg.get(0).weight*-1>pos.get(pos.size()-1).weight) {
			calPos();
			calNeg();
			result -= (neg.get(0).weight)*-1;
		}else if(neg.get(0).weight*-1<=pos.get(pos.size()-1).weight) {
			calNeg();
			calPos();
			result -= pos.get(pos.size()-1).weight;
		}
		System.out.println(result);
		
	}
	
	private static void calNeg() {
		for (int i = 0; i < neg.size(); i++) {
			result += (neg.get(i).weight*2)*-1;
			i += M-1;
		}
	}
	private static void calPos() {
		for (int i = pos.size()-1; i >= 0; i--) {
			result += pos.get(i).weight*2;
			i -= M-1;
		}
	}
	static String src = "2 2\r\n" + 
			"-2 2";
}
