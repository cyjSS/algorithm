package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;

public class Main_G3_19591_독특한계산기 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		String str = br.readLine();
		int n = str.length()-1;
		int idx = 1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('*', 1);
		map.put('/', 1);
		map.put('+', 0);
		map.put('-', 0);
		
		long frontF = 0;
		while(idx<=n && str.charAt(idx)>47) {
			frontF = frontF*10 + (str.charAt(idx)-48);
			idx++;
		}
		if(str.charAt(0)>47) frontF += (str.charAt(0)-48)*Math.pow(10, idx-1);
		else frontF *= -1;
		
		long backF = 0;
		while(n>=0 && str.charAt(n)>47) {
			backF += (str.charAt(n)-48)*Math.pow(10, str.length()-1-n);
			n--;
		}
		
		if(idx==str.length()) {
			System.out.println(frontF);
			return;
		}
		if(n<0) {
			System.out.println(backF);
			return;
		}
		
		while(true) {
			if(idx==n) break;
			char frontCal = str.charAt(idx);
			char backCal = str.charAt(n);
			
			if(map.get(frontCal)==map.get(backCal)) {
				idx++; n--;
				int f = idx;
				int b = n;
				long frontS = 0;
				while(str.charAt(idx)>47) {
					frontS = frontS*10 + (str.charAt(idx)-48);
					idx++;
				}
				long backS = 0;
				while(str.charAt(n)>47) {
					backS += (str.charAt(n)-48)*Math.pow(10, b-n);
					n--;
				}
				
				long frontResult=0; long backResult=0;
				frontResult = cal(frontF,frontS,frontCal);
				backResult = cal(backS,backF,backCal);
				
				if(frontResult>=backResult) {
					frontF = frontResult;
					n = b+1;
				}else if(frontResult<backResult) {
					backF = backResult;
					idx = f-1;
				}
			} else if(map.get(frontCal)>map.get(backCal)) {
				idx++;
				long frontS = 0;
				while(str.charAt(idx)>47) {
					frontS = frontS*10 + (str.charAt(idx)-48);
					idx++;
				}
				
				frontF = cal(frontF,frontS,frontCal);
			} else {
				n--;
				int b = n;
				long backS = 0;
				while(str.charAt(n)>47) {
					backS += (str.charAt(n)-48)*Math.pow(10, b-n);
					n--;
				}
				
				backF = cal(backS,backF,backCal);
			}
		}
		
		System.out.println(cal(frontF,backF,str.charAt(idx)));
		
	}	
	private static long cal(long x, long y, char cal) {
		if(cal=='*') return x*y;
		else if(cal=='/') return x/y;
		else if(cal=='+') return x+y;
		else return x-y;
	}
	static String src = "-1-1-1-1";
}
