package programmers;

public class 거스름돈 {
    public long solution(int n, int[] money) {
        long[] dp = new long[n+1];
        dp[0] = 1;

        for(int i = 0; i < money.length; i++) {
            for(int j = money[i] ; j <= n; j++) {
                dp[j] += dp[j - money[i]];
            }
        }

        return dp[n] % 1000000007;
    }
}
