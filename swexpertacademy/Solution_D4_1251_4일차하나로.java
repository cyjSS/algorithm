package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1251_4일차하나로 {
	static class Is {
		int X, Y;
		public Is(int x, int y) {
			super();
			X = x;
			Y = y;
		}
	}
	static Is[] isList;
	static int T,N;
	static double minIs[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/one.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			isList = new Is[N];
			minIs = new double[N];
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				isList[i] = new Is(Integer.parseInt(st.nextToken()),0);
				minIs[i] = Double.MAX_VALUE;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				isList[i].Y = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			double result = 0;
			minIs[0] = 0.0;
			for (int i = 0; i < N; i++) {
				Double min = Double.MAX_VALUE;				// 위치 중요하다
				int minVertex = -1;
				for (int j = 0; j < N; j++) {
					if(!visited[j] && min>minIs[j]) {
						min = minIs[j];
						minVertex = j;
					}
				}
				visited[minVertex] = true;
				result += min*E;
				for (int j = 0; j < N; j++) {
					if(!visited[j] && minIs[j]>cal(minVertex,j)) {
						minIs[j] = cal(minVertex,j);
					}
				}
			}
			sb.append("#").append(test).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}
	private static double cal(int i, int j) {
		return (double) (Math.pow(isList[i].X-isList[j].X, 2)+Math.pow(isList[i].Y-isList[j].Y, 2));
	}
}
