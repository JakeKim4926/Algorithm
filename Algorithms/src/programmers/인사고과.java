package programmers;

import java.util.*;

public class 인사고과 {

    public int solution(int[][] scores) {
        int answer = 1;

        int wanHo = scores[0][0] + scores[0][1];

        // 완호보다 두 점수가 모두 높은 사원이 있으면 -1 반환
        for (int i = 1; i < scores.length; i++) {
            if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
                return -1;
            }
        }

        // 근무 태도 점수를 기준으로 내림차순 정렬, 동료 평가 점수가 같은 경우 오름차순
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 근무 태도 점수가 같을 때 동료 평가 점수를 오름차순
            }
            return b[0] - a[0]; // 근무 태도 점수 내림차순
        });

        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            // 동료 평가 점수가 현재까지의 최대 점수보다 작으면 해당 사원은 인센티브를 받지 못함
            if (scores[i][1] < max) {
                continue;
            }

            max = Math.max(max, scores[i][1]);

            // 완호보다 점수 합이 높은 사원의 경우 순위 증가
            if (scores[i][0] + scores[i][1] > wanHo) {
                answer++;
            }
        }

        return answer;
    }

}
