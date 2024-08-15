package programmers;

import java.util.*;
public class 짝지어제거하기 {
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != alphabet) {
                stack.push(alphabet);
            } else {
                stack.pop();
            }
        }

        if(stack.isEmpty())
            answer = 1;

        return answer;
    }
}
