import java.lang.*;
import java.util.*;

class Lv1_실패율 {
    static class Stage implements Comparable<Stage>{
        int num; double fail;
        public Stage(int num, double fail){
            this.num = num;
            this.fail = fail;
        }
        public int compareTo(Stage o){
            if(o.fail>this.fail) return 1;
            else if(o.fail==this.fail){
                if(o.num<this.num) return 1;
                else return -1;
            }
            else return -1;
        }
        public String toString(){
            return num+" "+fail;
        }
    }
    static ArrayList<Stage> stage;
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        stage = new ArrayList<Stage>();
        ArrayList<Integer> people = new ArrayList<Integer>();
        for(int i=0; i<stages.length; i++) people.add(stages[i]);

        for(int i=1; i<=N; i++){
            int total = people.size();
            if(total==0) {
                for(int j=i; j<=N ; j++) stage.add(new Stage(j,0.0));
                break;
            }
            for(int j=people.size()-1; j>=0; j--){
                if(people.get(j)==i) people.remove(j);
            }
            int out = people.size();
            int in = total - out;
            stage.add(new Stage(i,(double)in/(double)total));
        }
        
        Collections.sort(stage);
        for(int i=0; i<N; i++) answer[i]=stage.get(i).num;
        return answer;
    }
}