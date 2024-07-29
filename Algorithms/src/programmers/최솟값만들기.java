package programmers;

import java.util.*;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index = B.length-1;

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[index--];
        }

        return answer;
    }
}
