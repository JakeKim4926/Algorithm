package programmers;

import java.util.*;

public class 입국심사 {

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right = times[times.length-1] * (long)n;

        while(left <= right) {
            long mid = (left+right) / 2;
            long people = 0;
            for(int time : times) {
                people += mid / time;
                if(people > n)
                    break;
            }

            if(people >= n) {
                answer = mid;
                right = mid - 1;
            } else
                left = mid + 1;

        }

        return answer;
    }

//    public long solution(int n, int[] times) {
//        long answer = 0;
//
//        long left = 0L;
//        long right = 0L;
//        for(long time : times) {
//            right = Math.max(time, right);
//        }
//        right *= n;
//
//        while(left <= right) {
//            long mid = (left + right) / 2;
//            long people = 0L;
//
//            for(long time : times) {
//                people += mid / time;
//            }
//
//            if(people >= n) {
//                right = mid-1;
//                answer = mid;
//            } else
//                left = mid +1;
//        }
//
//        return answer;
//    }
}
