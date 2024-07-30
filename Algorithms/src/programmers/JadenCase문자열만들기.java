package programmers;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char first = (char)(s.charAt(0));
        if(first >= 'a' && first <= 'z')
            first -= 32;

        answer.append(first);

        for(int i = 1 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.charAt(i-1) == ' ' && (c >= 'a' && c <= 'z'))
                c -= 32;
            if(s.charAt(i-1) != ' ' && (c >= 'A' && c <= 'Z'))
                c += 32;

            answer.append(c);
        }

        return answer.toString();
    }
}
