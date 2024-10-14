package Bakejoon;

import java.io.*;
import java.util.StringTokenizer;

public class 로봇조종하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][M];
        int[][] dpRight = new int[N][M];
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        dpRight[0][0] = map[0][0];
        for(int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j-1] + map[0][j];
            dpRight[0][j] = dpRight[0][j-1] + map[0][j];
        }

        for(int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][0] + map[i][0];
            for(int j = 1; j < M; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
            }

            dpRight[i][M-1] = dpRight[i-1][M-1] + map[i][M-1];
            for(int j = M-2; j >= 0; j--) {
                dpRight[i][j] = Math.max(dpRight[i-1][j], dpRight[i][j+1]) + map[i][j];
            }

            for(int j = 0; j < M; j++) {
                dp[i][j] = Math.max(dp[i][j], dpRight[i][j]);
                dpRight[i][j] = dp[i][j];
            }
        }

        bw.write(dp[N-1][M-1] + "\n");
        bw.close();
    }
}
