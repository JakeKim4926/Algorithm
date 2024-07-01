package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 벽부수고이동하기 {

    static class Point {
        int nRow;
        int nCol;
        int nCount;
        boolean bBreak;

        public Point(int nRow, int nCol, int nCount, boolean bBreak) {
            this.nRow = nRow;
            this.nCol = nCol;
            this.nCount = nCount;
            this.bBreak = bBreak;
        }
    }

    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][][] barrVisited;
    static boolean[][] barrMap;
    static int nDay = 0;
    static int N, M;
    static int nMin = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        // 대박 대박 대박
        System.setIn(new FileInputStream(벽부수고이동하기.class.getResource("input.txt").getPath()));

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken()); // rows
        M = Integer.parseInt(st.nextToken()); // cols

        barrMap = new boolean[N][M];
        barrVisited = new boolean[N][M][2];

        // 맵 정보 입력
        for (int i = 0; i < N; i++) {
            String strLine = bReader.readLine();
            for (int j = 0; j < M; j++) {
                if (strLine.charAt(j) == '1') {
                    barrMap[i][j] = true;
                }
            }
        }

        // 탐색합시당
        BFS();

        if (nMin == 1000 * 1000)
            nMin = -1;

        bWriter.write(String.valueOf(nMin));

        bWriter.flush();
        bWriter.close();
    }

    public static void BFS() throws IOException {
        // 동서남북 탐색
        int dr[] = { 0, 0, 1, -1 };
        int dc[] = { 1, -1, 0, 0 };

        // 1을 0으로 하나씩 바꿔가면서 탐색해보자
        // 1== 벽

        // 만약 벽이 없다면 한 번만 BFS돌려라

        Queue<Point> queueBfs = new LinkedList<>();
        queueBfs.add(new Point(0, 0, 0, false));
        // BFS 돌려보자~
        while (!queueBfs.isEmpty()) {
            Point p = queueBfs.poll();
            p.nCount++;

            // 도착하여 어떤 것이 제일 최소 경로인지 봅시당
            if (p.nRow == N - 1 && p.nCol == M - 1) {
                if (nMin > p.nCount)
                    nMin = p.nCount;
                return;
            }


            // 동서남북 탐색
            for (int k = 0; k < dr.length; k++) {
                int nSearchRow = p.nRow + dr[k];
                int nSearchCol = p.nCol + dc[k];

                int nBroken = 0;

                // 2차원 visited를 벽을 부신 후와 부시지 않은 후로 나눈다아. == 3차원이 된다.
                if (p.bBreak)
                    nBroken = 1;
                // 방문한 적이 있는감
                if (nSearchRow >= 0 && nSearchCol >= 0 && nSearchRow < N && nSearchCol < M
                        && !barrVisited[nSearchRow][nSearchCol][nBroken]) {
                    // 다음이 0이다 (벽이 읎다)
                    if (!barrMap[nSearchRow][nSearchCol]) {
                        barrVisited[nSearchRow][nSearchCol][nBroken] = true;
                        queueBfs.add(new Point(nSearchRow, nSearchCol, p.nCount, p.bBreak));
                    } else if (barrMap[nSearchRow][nSearchCol] && !p.bBreak) {
                        // 다음이 1인데 아직 벽을 한 번도 안부수었도다.
                        barrVisited[nSearchRow][nSearchCol][nBroken] = true;
                        queueBfs.add(new Point(nSearchRow, nSearchCol, p.nCount, true));
                    }
                }
            }
        }

    }
}