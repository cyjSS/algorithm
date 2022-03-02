import java.lang.*;
import java.util.*;

class Lv2_문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<s.length(); i++){
            int each = i;
            int cnt = 0;
            String before = s.substring(0,i);
            for(int j=i; j<s.length(); j+=i){
                if(s.length()<j+i){
                    each += s.length()-j;
                    break;
                }
                String cur = s.substring(j,j+i);
                if(before.equals(cur)){
                    cnt++;
                }else {
                    before = cur;
                    each += i;
                    if(cnt!=0) each += Integer.toString(cnt+1).length();
                    cnt = 0;
                }
            }
            if(cnt!=0) each += Integer.toString(cnt+1).length();
            //System.out.println(i+" "+each);
            answer = Math.min(each, answer);
        }
        return answer;
    }
}