package programmers;

import java.util.*;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MAX_VALUE * -1;
        int min = Integer.MAX_VALUE;
        boolean bNegative = false;

        StringTokenizer st = new StringTokenizer(s);

        while(st.hasMoreTokens()) {
            int value = Integer.valueOf(st.nextToken());
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        answer = String.valueOf(min) + " " + String.valueOf(max);

        return answer;
    }
}
