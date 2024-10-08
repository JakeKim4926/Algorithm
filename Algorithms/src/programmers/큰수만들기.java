package programmers;

public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int length = number.length() - k;

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < current && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(current);
        }

        return sb.substring(0, length);
    }
}
