import java.lang.*;
import java.util.*;

class Lv2_단체사진찍기 {
    static boolean visited[];
    static HashMap<String, Integer> each;
    static String kakao[] = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        each = new HashMap<String, Integer>();
        line(0,n,data);
        return answer;
    }
    private static void line(int cnt, int len, String[] data){
        if(cnt==8){
            for(int j=0; j<len; j++){
                int temp = Math.abs(each.get(data[j].substring(0,1))-each.get(data[j].substring(2,3)))
                    -1-Integer.parseInt(data[j].substring(4,5));
                if(temp==0){
                    if(!data[j].substring(3,4).equals("=")) return;
                }else if(temp<0){
                    if(!data[j].substring(3,4).equals("<")) return;
                }else {
                    if(!data[j].substring(3,4).equals(">")) return;
                }
            }
            answer++;
            return;
        }
        for(int i=0; i<8; i++){
            if(visited[i]) continue;
            each.put(kakao[i], cnt);
            visited[i] = true;
            line(cnt+1, len, data);
            visited[i] = false;
        }
    }
}