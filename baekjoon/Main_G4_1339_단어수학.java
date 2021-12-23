package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Main_G4_1339_단어수학 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int n = Integer.parseInt(br.readLine());
		char num[][] = new char[n][];
		for (int i = 0; i < n; i++) {
			num[i] = br.readLine().toCharArray();
		}
		
		Map<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < num[i].length; j++) {
				hmap.put(num[i][j], hmap.getOrDefault(num[i][j],0) + (int)Math.pow(10, num[i].length-j-1));
			}
		}
		
		List<Map.Entry<Character, Integer>> list = new LinkedList<>(hmap.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
		});
		int result =0; int idx=9;
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i).getValue()*idx;
			idx--;
		}
		System.out.println(result);
	}
	static String src = "2\r\n" + 
			"AB\r\n" + 
			"BA";
}
