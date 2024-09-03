package programmers;

public class 순위 {
    // floyd Algorithm
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] floyd = new int[n+1][n+1];

        for(int i = 0 ; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            floyd[winner][loser] = 1;
            floyd[loser][winner] = -1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(floyd[i][k] == floyd[k][j]) {
                        if(floyd[i][k] == 1) {
                            floyd[i][j] = 1;
                            floyd[j][i] = -1;
                        } else if(floyd[i][k] == -1){
                            floyd[i][j] = -1;
                            floyd[j][i] = 1;
                        }
                    }
                }
            }
        }

        for(int i = 1 ;i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(floyd[i][j] == 0)
                    count++;
                if(count > 2)
                    break;
            }
            if(count == 1)
                answer++;
        }

        return answer;
    }
}
