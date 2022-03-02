import java.util.*;
import java.lang.*;

class Lv2_오픈채팅방 {
    static class User {
        String action;
        String userId;
        public User(String action, String userId) {
            this.action = action;
            this.userId = userId;
        }
    }
    static ArrayList<User> user;
    public String[] solution(String[] record) {
        user = new ArrayList<User>();
        int n = record.length;
        HashMap<String, String> map = new HashMap<String, String>();
        for(int i=0; i<n; i++){
            String each[] = record[i].split(" ");
            if(each[0].equals("Change")){
                map.put(each[1], each[2]);
                continue;
            }
            user.add(new User(each[0], each[1]));
            if(each.length==2) continue;
            map.put(each[1], each[2]);
        }
        String[] answer = new String[user.size()];
        for(int i=0; i<user.size(); i++){
            answer[i] = map.get(user.get(i).userId)+"님이 ";
            answer[i] += user.get(i).action.equals("Enter") ? "들어왔습니다.":"나갔습니다.";
        }
        return answer;
    }
}