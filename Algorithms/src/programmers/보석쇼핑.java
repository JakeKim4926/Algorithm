package programmers;

import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int n = gems.length;
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        int kinds = set.size();

        HashMap<String, Integer> gemCount = new HashMap<>();
        int minLength = n + 1;
        int start = 0, end = 0;
        int[] answer = new int[2];

        while (end < n) {
            gemCount.put(gems[end], gemCount.getOrDefault(gems[end], 0) + 1);

            while (gemCount.size() == kinds) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }

                gemCount.put(gems[start], gemCount.get(gems[start]) - 1);
                if (gemCount.get(gems[start]) == 0) {
                    gemCount.remove(gems[start]);
                }
                start++;
            }

            end++;
        }

        return answer;
    }
}
