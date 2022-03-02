import java.util.*;
import java.lang.*;

class Lv2_멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 1;
        int large = Math.max(w,h);
        int small = Math.min(w,h);
        while(true){
            if(large % small == 0){
                answer *= (long)large;
                break;
            } else if (large - small == 1){
                long tem = (long)(small * 2);
                answer *= tem;
                break;
            } else {
                int gcd = getGCD(large, small);
                if(gcd == 1){
                    long temp = (long)((large-1) * 2) - (long)(large-small-1);
                    answer *= temp;
                    break;
                } else {
                    answer *= (long)gcd;
                    large /= gcd;
                    small /= gcd;
                }
            }
        }
        answer = (long)w*h - answer;
        return answer;
    }
    private static int getGCD(int num1, int num2){
        if(num1 % num2 == 0) return num2;
        return getGCD(num2, num1%num2);
    }
}