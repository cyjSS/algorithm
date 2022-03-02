import java.util.*;
import java.lang.*;

class Lv2_124나라의숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        boolean t = false;
        
        while(true){
            if(n<=3){
                if(n==3) sb.append(4);
                else sb.append(n);
                break;
            }
            if(n%3 == 0){
            n--;
            t = true;
            }
            if(t) sb.append(n%3 + 2);
            else sb.append(n%3);
            n /= 3;
            t = false;
        }
        answer = sb.reverse().toString();
        return answer;
    }
}