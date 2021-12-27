package swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1209_2일차Sum {

	static int test;
	static int matrix[][];
	static int AnsV[], AnsH[], AnsD[], Ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/Sum.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			test = Integer.parseInt(br.readLine());
			matrix = new int[100][100];
			
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int k = 0; k < 100; k++) {
					matrix[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			AnsV = new int [100]; AnsH = new int [100]; AnsD = new int [2]; 
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					AnsH[r] += matrix[r][c];
					AnsV[c] += matrix[r][c];
					if(r==c) AnsD[0]+=matrix[r][c];
					if(r+c==99) AnsD[1]+=matrix[r][c];
				}
			}
			Arrays.sort(AnsH);
			Arrays.sort(AnsV);
			Arrays.sort(AnsD);
			
			Ans = Math.max(AnsH[99], AnsV[99]);
			Ans = Math.max(Ans, AnsD[1]);
			
			
			System.out.println("#"+test+" "+Ans);
		}

	}
}
