package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 나이트의이동 {

    static class Point {
        int m_nRow;
        int m_nCol;
        int m_nCount;

        public Point(int m_nRow, int m_nCol, int m_nCount) {
            super();
            this.m_nRow = m_nRow;
            this.m_nCol = m_nCol;
            this.m_nCount = m_nCount;
        }

    }
    static boolean[][] barrVisited;
    static int N, nStartRow, nStartCol, nEndRow, nEndCol, nResult;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bReader.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bReader.readLine());

            // 맵 크기 설정 하자
            barrVisited = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(bReader.readLine());
            nStartRow = Integer.parseInt(st.nextToken());
            nStartCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bReader.readLine());
            nEndRow = Integer.parseInt(st.nextToken());
            nEndCol = Integer.parseInt(st.nextToken());

            nResult = 0;
            BFS();
            bWriter.write(String.valueOf(nResult) + '\n');
            bWriter.flush();
        }


        bWriter.close();

    }

    private static void BFS() {
        Queue<Point> queueBFS = new LinkedList<>();

        queueBFS.add(new Point(nStartRow, nStartCol, 0));

        // 나이트 움직임 만큼 가자
        // 북동 부터 북서로 시계방향
        int[] dr = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

        while (!queueBFS.isEmpty()) {
            Point p = queueBFS.poll();

            if(p.m_nRow == nEndRow && p.m_nCol == nEndCol) {
                nResult = p.m_nCount;
                queueBFS.clear();
                break;
            }

            if(barrVisited[p.m_nRow][p.m_nCol])
                continue;

            barrVisited[p.m_nRow][p.m_nCol] = true;

            for(int i = 0; i < dr.length; i++) {
                int nSearchRow = p.m_nRow + dr[i];
                int nSearchCol = p.m_nCol + dc[i];

                // 범위 벗어나거나 방문했으면 나가버려
                if(nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= N
                        || barrVisited[nSearchRow][nSearchCol])
                    continue;

                queueBFS.add(new Point(nSearchRow, nSearchCol, p.m_nCount+1));
            }

        }
    }

}