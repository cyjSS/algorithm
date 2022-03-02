import java.util.*;
import java.lang.*;

class Lv1_모의고사 {
    public int[] solution(int[] answers) {
        int one[] ={1,2,3,4,5};
        int two[] ={2,1,2,3,2,4,2,5};
        int three[] ={3,3,1,1,2,2,4,4,5,5};
        int one1 = 0;
        int two2 = 0;
        int three3 = 0;
        int max = 0;
        for(int i=0; i<answers.length; i++){
            if(one[i%one.length]==answers[i]) one1++;
            if(two[i%two.length]==answers[i]) two2++;
            if(three[i%three.length]==answers[i]) three3++;
        }
        max = Math.max(Math.max(one1,two2),three3);
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if(one1==max) answer.add(1);
        if(two2==max) answer.add(2);
        if(three3==max) answer.add(3);
        int ans[] = new int[answer.size()];
        for(int i=0; i<answer.size();i++) ans[i] = answer.get(i);
        return ans;
    }
}