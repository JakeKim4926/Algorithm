package programmers;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : scoville)
            pq.add(num);

        int sum = 0;
        while(!pq.isEmpty()) {

            sum = pq.poll();
            if(sum >= K)
                return answer;
            if(pq.isEmpty())
                return -1;

            sum += pq.poll() * 2;

            pq.add(sum);

            answer++;
        }


        return -1;
    }
}
