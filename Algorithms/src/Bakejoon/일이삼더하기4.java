package Bakejoon;

import java.io.*;

public class 일이삼더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            if(N < 4) {
                bw.write(String.valueOf(N) + '\n');
                continue;
            }

            int[][] dp = new int[N+1][4];
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;

            for(int i = 4; i <= N; i++) {
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }
            int sum = 0;
            for(int i = 1; i <=3; i++)
                sum += dp[N][i];
            bw.write(String.valueOf(sum) + '\n');
        }

        bw.close();
    }
}
