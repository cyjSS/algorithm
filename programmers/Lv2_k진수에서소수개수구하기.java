import java.util.*;
import java.lang.*;

class Lv2_k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String change = "";
        while(n>0){
            if(n<k) change += Integer.toString(n);
            else change += Integer.toString(n%k);
            n /= k;
        }
        StringBuffer sb = new StringBuffer(change);
        String list[] = sb.reverse().toString().split("0");
        
        for(int i=0; i<list.length; i++){
            if(list[i].equals("")) continue;
            if(kal(Long.parseLong(list[i]))) {
                answer++;
                
                }
        }

        return answer;
    }
    private static boolean kal(long q){
        if(q == 1) {
            return false;
        } else if(q == 2) {
            return true;
        }

        int limit = (int) Math.sqrt(q);
        for(int i=2; i<=limit; ++i) {
            if(q % i == 0) {
                return false;
            }
        }
        return true;
    }
}