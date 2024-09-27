package programmers;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> comparelist = new ArrayList<>();
        for(int price : prices)
            stack.push(price);

        int index = prices.length - 1;
        while(!stack.isEmpty()) {
            int now = stack.pop();
            int size = comparelist.size();
            int count = 0;

            for(int i = size-1; i >= 0; i--) {
                count++;
                int num = comparelist.get(i);
                if(num < now)
                    break;
            }

            comparelist.add(now);
            answer[index--] = count;
        }

        return answer;
    }
}
