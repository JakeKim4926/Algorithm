package programmers;

public class n2배열자르기 {
    public long[] solution(int n, long left, long right) {
        int size = (int)right - (int)left + 1;
        long[] answer = new long[size];

        int index = 0;
        for(long i = left + 1; i <= right + 1; i++) {
            long section = i / n + 1;
            long pos = i % n;

            if(pos == 0)
                answer[index++] = n;
            else if(pos < section)
                answer[index++] = section;
            else
                answer[index++] = pos;
        }

        return answer;
    }
}
