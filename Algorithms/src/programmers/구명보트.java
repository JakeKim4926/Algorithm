package programmers;

import java.util.*;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length -1;

        while(left <= right) {
            if(people[left] + people[right] <= limit)
                left++;

            answer++;
            right--;
        }


        return answer;
    }

//    public int solution(int[] people, int limit) {
//        int answer = 0;
//
//        Arrays.sort(people);
//
//
//        int left = 0;
//        int right = people.length - 1;
//
//        while(left <= right) {
//            if(people[right] + people[left] <= limit)
//                left++;
//
//            right--;
//            answer++;
//        }
//
//
//        return answer;
//    }
}
