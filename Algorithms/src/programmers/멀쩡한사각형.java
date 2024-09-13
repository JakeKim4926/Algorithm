package programmers;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 0;

        long num1 = Math.max(w,h);
        long num2 = Math.min(w,h);

        while(num2 != 0) {
            long temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        answer = ((long)w*(long)h) - (w+h-num1);

        return answer;
    }
}
