package programmers;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> processes = new LinkedList<>();
        for(int num : progresses) {
            processes.add(num);
        }

        int index = 0;
        int count = 0;
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!processes.isEmpty()) {
            int process = processes.peek() + (count * speeds[index]);

            if(process >= 100) {
                index++;
                result++;
                processes.poll();
            } else {
                if(result > 0) {
                    list.add(result);
                    result = 0;
                }
                count++;
            }
        }

        if(result > 0)
            list.add(result);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
