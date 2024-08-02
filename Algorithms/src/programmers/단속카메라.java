package programmers;

import java.util.*;

public class 단속카메라 {
    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int camera = (-1) * (30001);
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if(start > camera){
                camera = end;
                answer++;
            }
        }

        return answer;
    }
}
