package Bakejoon;

import java.io.*;
import java.util.*;

public class 파도반수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            if(N <= 3) {
                bw.write("1\n");
                continue;
            }

            long[] dp = new long[N + 1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for(int i = 4; i <= N; i++)
                dp[i] = dp[i-2] + dp[i-3];

            bw.write(dp[N] + "\n");
        }
        bw.close();
    }
}