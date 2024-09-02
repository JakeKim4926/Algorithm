package programmers;

import java.util.*;

public class 다단계칫솔판매 {
    HashMap<String, Integer> indexMap;
    int[] parents;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        indexMap = new HashMap<>();
        parents = new int[enroll.length];

        for(int i = 0; i < amount.length; i++)
            amount[i] *= 100;

        for(int i = 0; i < enroll.length; i++)
            indexMap.put(enroll[i], i);

        for(int i = 0; i < referral.length; i++) {
            int child = indexMap.get(enroll[i]);

            if(referral[i].equals("-")) {
                parents[child] = -1;
            } else {
                int parent = indexMap.get(referral[i]);
                parents[child] = parent;
            }
        }

        for(int i = 0; i < seller.length; i++) {
            int index = indexMap.get(seller[i]);
            int money = amount[i];

            dfs(index, money, answer);
        }

        return answer;
    }

    public void dfs(int index, int money, int[] answer) {
        answer[index] += money - money / 10;

        if(parents[index] == -1)
            return;

        int parent = parents[index];

        dfs(parent, money / 10, answer);
    }
}
