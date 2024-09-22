package programmers;

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++)
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0) + 1);

        if(map.size() == 1)
            return map.get(clothes[0][1]);

        int mul = 1;
        for(String cloth : map.keySet()) {
            int value = map.get(cloth) + 1;
            mul *= value;
        }

        answer = mul - 1;

        return answer;
    }
}
