package programmers;

public class 다음큰숫자 {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        int answer = 0;
        while(count != answer) {
            n++;
            answer = Integer.bitCount(n);
        }
        return n;
    }
}
