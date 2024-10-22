package programmers;

import java.util.*;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int num: tangerine)
            map.put(num, map.getOrDefault(num,0) + 1);

        for(int key: map.keySet())
            list.add(map.get(key));

        Collections.sort(list);

        for(int i = list.size() - 1; i >= 0; i--) {
            k -= list.get(i);
            answer++;

            if(k <= 0)
                break;
        }

        return answer;
    }
}
