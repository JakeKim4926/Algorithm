package programmers;

import java.util.HashMap;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(String name : participant)
            map.put(name, map.getOrDefault(name, 0) + 1);

        for(String name : completion)
            map.put(name, map.getOrDefault(name, 0) -1);

        for(String name : participant) {
            if(map.get(name) > 0) {
                return name;
            }
        }

        return answer;
    }
}
