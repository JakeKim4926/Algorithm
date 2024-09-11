package programmers;

import java.util.*;

public class 타겟넘버 {
    int answer;
    class Target{
        int index;
        int sum;
        Target(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
    public int solution(int[] numbers, int target) {
        answer = 0;

        Queue<Target> bfs = new LinkedList<>();

        bfs.add(new Target(0, 0));

        while(!bfs.isEmpty()) {
            Target temp = bfs.poll();

            if(temp.index == numbers.length) {
                if(temp.sum == target)
                    answer++;

                continue;
            }

            bfs.add(new Target(temp.index+1, temp.sum + numbers[temp.index]));
            bfs.add(new Target(temp.index+1, temp.sum - numbers[temp.index]));
        }


        return answer;
    }
}
