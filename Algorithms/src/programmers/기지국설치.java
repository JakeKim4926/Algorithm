package programmers;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int apartIndex = 1;
        int area = 1 + 2 * w;

        for(int i = 0; i < stations.length; i++) {
            int startOfEnableArea = stations[i] - w;

            int emptyArea = startOfEnableArea - apartIndex;

            if(emptyArea > 0) {
                int calculate = emptyArea / area;
                if(emptyArea % area != 0)
                    calculate++;
                answer += calculate;
            }

            apartIndex = stations[i] + w + 1;
        }

        if(apartIndex <= n) {
            int newArea = n - apartIndex;
            if(newArea == 0)
                answer++;
            else {
                int calculate = newArea / area;
                if(newArea % area != 0)
                    calculate++;

                answer += calculate;
            }
        }

        return answer;
    }
}
