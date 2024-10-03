package programmers;

public class 등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        int MOD = 1000000007;

        for(int i = 0; i < puddles.length; i++)
            dp[puddles[i][1]][puddles[i][0]] = -1;

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(dp[i][j] == -1)
                    continue;

                if(dp[i][j-1] > 0)
                    dp[i][j] += dp[i][j-1] % MOD;
                if(dp[i-1][j] > 0)
                    dp[i][j] += dp[i-1][j] % MOD;
            }
        }

        return dp[n][m] % MOD;
    }

//    public int solution(int m, int n, int[][] puddles) {
//        int MOD = 1000000007;
//
//        int[][] map = new int[n + 1][m + 1];
//        for(int i = 0; i < puddles.length; i++) {
//            map[puddles[i][1]][puddles[i][0]] = -1;
//        }
//
//        map[1][1] = 1;
//        for(int i = 1; i < n + 1; i++) {
//            for(int j = 1; j < m + 1; j++) {
//                if(map[i][j] == -1) continue;
//                if(map[i - 1][j] > 0) map[i][j] += map[i - 1][j] % MOD;
//                if(map[i][j - 1] > 0) map[i][j] += map[i][j - 1] % MOD;
//            }
//        }
//        return map[n][m] % MOD;
//    }
}
