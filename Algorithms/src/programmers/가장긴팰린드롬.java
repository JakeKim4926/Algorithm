package programmers;

public class 가장긴팰린드롬 {
    public int solution(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int maxLength = 1;

        for (int center = 0; center < n; center++) {
            maxLength = Math.max(maxLength, expandAroundCenter(s, center, center));
            maxLength = Math.max(maxLength, expandAroundCenter(s, center, center + 1));
        }

        return maxLength;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
