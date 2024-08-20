package programmers;

import java.util.*;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        int index = 0;
        int current = 0;
        int totalWait = 0;
        int done = 0;

        while(done < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= current) {
                pq.offer(jobs[index++]);
            }

            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                current += job[1];
                totalWait += current - job[0];
                done++;
            } else {
                current = jobs[index][0];
            }
        }

        answer = totalWait / jobs.length;


        return answer;
    }
}
