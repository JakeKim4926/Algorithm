package softeer;

import java.io.*;
import java.util.*;

public class 나무수확 {

    static int N;
    static int[][] farm;
    static int[][][] dp;
    static int[] dr = {0, 1}; // 오른쪽, 아래로 이동
    static int[] dc = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        farm = new int[N][N];
        dp = new int[N][N][2]; // 2배 사용 여부에 따라 dp 테이블을 2개로 나눔

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열을 최소값으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        // 시작점에서 초기화
        dp[0][0][0] = farm[0][0];
        dp[0][0][1] = farm[0][0] * 2;

        // DP 배열 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 2; d++) { // 두 방향 탐색 (오른쪽, 아래)
                    int nextRow = i + dr[d];
                    int nextCol = j + dc[d];

                    if (nextCol >= N || nextRow >= N) continue; // 경계를 넘으면 무시

                    // 2배를 사용하지 않고 값을 더하는 경우
                    dp[nextRow][nextCol][0] = Math.max(dp[nextRow][nextCol][0], dp[i][j][0] + farm[nextRow][nextCol]);

                    // 2배를 한 번 사용한 상태에서 값을 더하는 경우
                    dp[nextRow][nextCol][1] = Math.max(dp[nextRow][nextCol][1], dp[i][j][1] + farm[nextRow][nextCol]);

                    // 2배를 사용하지 않은 경로에서, 현재 좌표의 값을 2배로 만들어서 진행
                    dp[nextRow][nextCol][1] = Math.max(dp[nextRow][nextCol][1], dp[i][j][0] + farm[nextRow][nextCol] * 2);
                }
            }
        }

        // 최종 결과 출력 (우하단 값)
        int result = Math.max(dp[N - 1][N - 1][0], dp[N - 1][N - 1][1]);
        bw.write(result + "\n");
        bw.close();
    }

}
