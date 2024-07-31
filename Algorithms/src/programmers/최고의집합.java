package programmers;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer;
        if(n > s) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[n];
            for(int i = 0; i < n; i++) {
                answer[i] = s / n;
            }

            int index = n-1;
            for(int i = 0 ; i < s % n; i++) {
                answer[index--]++;
            }

        }

        return answer;
    }
}
