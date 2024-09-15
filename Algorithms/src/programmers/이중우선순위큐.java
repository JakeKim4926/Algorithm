package programmers;

import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        boolean isMax = false;

        for(int i = 0; i < operations.length; i++) {

            String code = operations[i].split(" ")[0];
            String value = operations[i].split(" ")[1];

            if(code.charAt(0) == 'I') {
                int num = Integer.parseInt(value);

                queue.add(num);
                maxQueue.add(num);
            } else if(code.charAt(0) == 'D') {
                if(queue.isEmpty() && maxQueue.isEmpty())
                    continue;

                if(value.charAt(0) == '1') {
                    int temp = maxQueue.poll();
                    queue.remove(temp);
                } else {
                    int temp = queue.poll();
                    maxQueue.remove(temp);
                }
            }
        }

        if(queue.isEmpty() && maxQueue.isEmpty())
            return answer;

        answer[0] = maxQueue.poll();
        answer[1] = queue.poll();

        return answer;
    }
}
