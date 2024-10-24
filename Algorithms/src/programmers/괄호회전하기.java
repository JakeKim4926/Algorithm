package programmers;

import java.util.Stack;

public class 괄호회전하기 {

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            // 스택을 사용하여 올바른 괄호 문자열인지 체크
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char c : rotated.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == ']' && top != '[') ||
                            (c == '}' && top != '{')) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
