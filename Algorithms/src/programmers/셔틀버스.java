package programmers;

import java.util.*;

public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) {
            String hour = time.split(":")[0];
            String minute = time.split(":")[1];

            pq.add(Integer.parseInt(hour) * 60 + Integer.parseInt(minute));
        }

        int startTime = 9 * 60;
        int lastTime = 0;
        int total = 0;

        for(int i =0 ; i < n; i++) {
            total = 0;
            while(!pq.isEmpty()) {
                int current = pq.peek();
                if(current <= startTime && total < m) {
                    pq.poll();
                    total++;
                } else
                    break;
                lastTime = current - 1;
            }
            startTime += t;
        }
        if(total < m)
            lastTime = startTime - t;

        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);

        answer = hour + ":" + minute;
        return answer;
    }
}
