package programmers;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        boolean[] bReserve = new boolean[n+1];
        boolean[] bLost = new boolean[n+1];

        for(int num : lost)
            bLost[num] = true;

        for(int num : reserve) {
            if(!bLost[num]) {
                bReserve[num] = true;
            } else
                bLost[num] = false;
        }

        for(int i = 1; i <= n; i++) {
            if(bReserve[i]) {
                if(bLost[i-1])
                    bLost[i-1] = false;
                else if(i != n && bLost[i+1])
                    bLost[i+1] = false;
            }
        }

        for(int i = 1; i <= n; i++) {
            if(bLost[i])
                answer--;
        }

        return answer;
    }
}
