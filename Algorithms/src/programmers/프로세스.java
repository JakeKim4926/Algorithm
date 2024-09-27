package programmers;

import java.util.*;

public class 프로세스 {
    class Process {
        int priority;
        int index;
        Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Process> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Process(priorities[i], i));
        }

        while(!queue.isEmpty()) {
            Process temp = queue.poll();

            int size = queue.size();
            boolean execute = true;
            for(int i = 0; i < size; i++) {
                Process p = queue.poll();
                if(temp.priority < p.priority)
                    execute = false;
                queue.add(p);
            }

            if(execute) {
                answer++;
                if(temp.index == location)
                    break;
            } else
                queue.add(temp);
        }

        return answer;
    }
}
