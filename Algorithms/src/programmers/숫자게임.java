package programmers;

import java.util.*;
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int bindex = B.length-1;
        for(int i = A.length-1; i >= 0; i--) {
            if(A[i] < B[bindex]) {
                answer++;
                bindex--;
            }
        }

        return answer;
    }
}
