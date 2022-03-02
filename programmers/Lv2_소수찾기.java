import java.lang.*;
import java.util.*;

class Lv2_소수찾기 {
    public int solution(String numbers) {
        int answer = 0;
        int sosu[] = new int[10000000];
        sosu[1] = 1;
        for(int i=2; i<10000000; i++){
            if(sosu[i]==0){
                if((int)Math.pow(i,2)>10000000) break;
                else {
                    for(int j=(int)Math.pow(i,2); j<10000000; j=j+i) sosu[j] = 1;
                }
            }
        }
        int total[] = new int[10];
        for(int i=0; i<numbers.length(); i++) total[numbers.charAt(i)-48]++;
        
        int check[] = new int[10];
        One:
        for(int i=1; i<10000000; i++){
            for(int j=0; j<10; j++) check[j] = total[j];
            if(sosu[i]==0){
                int temp = i;
                while(temp>=10){
                    if(check[temp%10]==0) continue One;
                    check[temp%10]--;
                    temp /= 10;
                }
                if(check[temp]==0) continue;
                answer++;
            }
        }
        return answer;
    }
}