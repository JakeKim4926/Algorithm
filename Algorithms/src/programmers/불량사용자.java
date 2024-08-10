package programmers;

import java.util.*;

public class 불량사용자 {
    boolean[] userId;
    int answer;
    HashMap<Integer, Integer> mapDuplication;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;

        mapDuplication = new HashMap<>();
        userId = new boolean[user_id.length];
        dfs(user_id, banned_id, 0);

        return answer;
    }

    public void dfs(String[] user_id, String[] banned_id, int index) {
        if(index == banned_id.length) {
            if(!isDuplicated())
                answer++;

            return;
        }

        for(int i = 0; i < user_id.length; i++) {
            if(banned_id[index].length() != user_id[i].length() || userId[i])
                continue;

            boolean bSearch = true;
            for(int j = 0; j < user_id[i].length(); j++) {
                if(banned_id[index].charAt(j) == '*')
                    continue;
                if(banned_id[index].charAt(j) == user_id[i].charAt(j))
                    continue;

                bSearch = false;
                break;
            }

            if(bSearch) {
                userId[i] = true;
                dfs(user_id, banned_id, index+1);
                userId[i] = false;
            }
        }
    }

    public boolean isDuplicated() {
        int temp = 0;
        int mul = 1;
        for(int i = 0; i < userId.length; i++) {
            if(userId[i]) {
                temp += (i+1) * mul;
                mul *= 10;
            }
        }

        if(mapDuplication.containsKey(temp))
            return true;

        mapDuplication.put(temp, 1);

        return false;
    }
}
