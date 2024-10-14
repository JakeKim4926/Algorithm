package programmers;

import java.util.Arrays;

public class 징검다리 {
    public long solution(int distance, int[] rocks, int n) {
        long answer = 0;

        long left = 1;
        long right = (long)distance;

        Arrays.sort(rocks);

        while(left <= right) {
            long mid = (left + right) / 2;

            int count = 0;
            int stand = 0;
            for(int rock : rocks) {
                if(rock - stand < mid)
                    count++;
                else {
                    stand = rock;
                }
            }
            if(distance - stand < mid)
                count++;

            if(count > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}
