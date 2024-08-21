package programmers;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 0L;
        long right = 0L;
        for(long time : times) {
            right = Math.max(time, right);
        }
        right *= n;

        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0L;

            for(long time : times) {
                people += mid / time;
            }

            if(people >= n) {
                right = mid-1;
                answer = mid;
            } else
                left = mid +1;
        }

        return answer;
    }
}
