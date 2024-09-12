package programmers;

// 본래 제목은 2 x n 타일링
public class 타일링2xn {
    class Solution {
        public long solution(int n) {
            long[] dp = new long[n+1];

            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i <= n; i++)
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;

            return dp[n];
        }

    }
}
