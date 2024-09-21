package programmers;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            return cities.length * 5;

        Queue<String> cash = new LinkedList<>();
        Queue<String> temp = new LinkedList<>();

        for(String city: cities) {
            city = city.toLowerCase();
            if(!cash.contains(city)) {
                if(cash.size() == cacheSize)
                    cash.poll();
                cash.add(city);
                answer += 5;
            } else {
                while(!cash.isEmpty()) {
                    if(cash.peek().equals(city))
                        cash.poll();
                    else
                        temp.add(cash.poll());
                }
                while(!temp.isEmpty()) {
                    cash.add(temp.poll());
                }
                cash.add(city);

                answer += 1;
            }
        }

        return answer;
    }
}
