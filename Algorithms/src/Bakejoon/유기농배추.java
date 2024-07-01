package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 유기농배추 {
    static boolean[][] barrVisited;
    static boolean[][] barrFarm;

    // 동서 남북
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        // 대박 대박 대박
        System.setIn(new FileInputStream(유기농배추.class.getResource("input.txt").getPath()));

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bReader.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());

            int M = Integer.parseInt(st.nextToken()); // cols
            int N = Integer.parseInt(st.nextToken()); // rows
            int K = Integer.parseInt(st.nextToken()); // cabbage count

            barrVisited = new boolean[N][M];
            barrFarm = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(bReader.readLine());
                int nCol = Integer.parseInt(st.nextToken());
                int nRow = Integer.parseInt(st.nextToken());

                barrFarm[nRow][nCol] = true;
            }

            int nWarm = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (barrFarm[i][j] && !barrVisited[i][j]) {
                        DFS(i, j);
                        nWarm++;
                    }
                }
            }

            bWriter.write(nWarm + "\n");
            bWriter.flush();
        }
        bWriter.close();
    }

    public static void DFS(int nRow, int nCol) {
        // 기저 조건
        if (barrVisited[nRow][nCol])
            return;

        // 탐색 조건
        barrVisited[nRow][nCol] = true;
        for (int k = 0; k < dr.length; k++) {
            int nRowSearch = nRow + dr[k];
            int nColSearch = nCol + dc[k];

            // 동, 서, 남, 북 중 배추가 있다
            if (nRowSearch >= 0 && nColSearch >= 0 && nRowSearch < barrFarm.length && nColSearch < barrFarm[0].length
                    && barrFarm[nRowSearch][nColSearch])
                DFS(nRowSearch, nColSearch);
        }
    }
}