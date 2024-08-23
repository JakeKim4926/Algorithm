package programmers;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;

        long sum1 = 0;
        long sum2 = 0;

        long[] even = new long[sequence.length];
        long[] odd = new long[sequence.length];

        long[] dpEven = new long[sequence.length];
        long[] dpOdd = new long[sequence.length];

        for(int i = 0; i < sequence.length; i++) {
            if(i % 2 == 0) {
                even[i] = sequence[i];
                odd[i] = sequence[i] * -1;
            } else {
                even[i] = sequence[i] * -1;
                odd[i] = sequence[i];
            }
        }

        dpEven[0] = even[0];
        dpOdd[0] = odd[0];
        answer = Math.max(dpEven[0], dpOdd[0]);

        for(int i = 1; i < sequence.length; i++) {
            dpEven[i] = Math.max(dpEven[i-1] + even[i], even[i]);
            dpOdd[i] = Math.max(dpOdd[i-1] + odd[i], odd[i]);

            long max = Math.max(dpEven[i], dpOdd[i]);
            answer = Math.max(answer, max);
        }

        return answer;
    }
}
