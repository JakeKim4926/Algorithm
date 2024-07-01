package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 구슬탈출2 {
    static class Point {
        int m_nRedRow;
        int m_nRedCol;
        int m_nBlueRow;
        int m_nBlueCol;
        int m_nCount;

        public Point() {
            // TODO Auto-generated constructor stub
        }

        public Point(int m_nRedRow, int m_nRedCol, int m_nBlueRow, int m_nBlueCol, int m_nCount) {
            super();
            this.m_nRedRow = m_nRedRow;
            this.m_nRedCol = m_nRedCol;
            this.m_nBlueRow = m_nBlueRow;
            this.m_nBlueCol = m_nBlueCol;
            this.m_nCount = m_nCount;
        }

        @Override
        public String toString() {
            return "Point [m_nRedRow=" + m_nRedRow + ", m_nRedCol=" + m_nRedCol + ", m_nBlueRow=" + m_nBlueRow
                    + ", m_nBlueCol=" + m_nBlueCol + ", m_nCount=" + m_nCount + "]";
        }
    }

    static int N, M;
    static boolean[][][][] barrVisit;
    static int[][] narrMap;

    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    static final int WALL = 0;
    static final int EMPTY = 1;
    static final int RED = 2;
    static final int BLUE = 3;
    static final int HOLE = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 방문 체크
        barrVisit = new boolean[N][M][N][M];
        // 보드값 입력받자
        // # : 0
        // . : 1
        // R : 2
        // B : 3
        // O : 4
        Point pMarble = new Point();
        narrMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            String strTemp = bReader.readLine();
            // 맵의 정보 입력
            for (int j = 0; j < M; j++) {
                if (strTemp.charAt(j) == '.') {
                    narrMap[i][j] = EMPTY;
                } else if (strTemp.charAt(j) == 'R') {
                    pMarble.m_nRedRow = i;
                    pMarble.m_nRedCol = j;
                    narrMap[i][j] = RED;
                } else if (strTemp.charAt(j) == 'B') {
                    pMarble.m_nBlueRow = i;
                    pMarble.m_nBlueCol = j;
                    narrMap[i][j] = BLUE;
                } else if (strTemp.charAt(j) == 'O') {
                    narrMap[i][j] = HOLE;
                }

            }
        }
        barrVisit[pMarble.m_nRedRow][pMarble.m_nRedCol][pMarble.m_nBlueRow][pMarble.m_nBlueCol] = true;
        int nResult = marble(pMarble);

        bWriter.write(String.valueOf(nResult));
        bWriter.close();
    }

    private static int marble(Point pStart) {
        Queue<Point> queueBFS = new LinkedList<>();
        queueBFS.add(pStart);

        while (!queueBFS.isEmpty()) {
            Point pBFS = queueBFS.poll();
            // 10회가 넘어가면 멈춰
            if (pBFS.m_nCount >= 10)
                break;
//			System.out.println(pBFS);
//			System.out.println("==============");
            for (int i = 0; i < dr.length; i++) {
                boolean bRedFirst = true;
                // blue랑 red 중 뭐가 먼저굴러갈까유
                if (i == 0 && pBFS.m_nRedCol < pBFS.m_nBlueCol)
                    bRedFirst = false;
                if (i == 1 && pBFS.m_nRedCol > pBFS.m_nBlueCol)
                    bRedFirst = false;
                if (i == 2 && pBFS.m_nRedRow < pBFS.m_nBlueRow)
                    bRedFirst = false;
                if (i == 3 && pBFS.m_nRedRow > pBFS.m_nBlueRow)
                    bRedFirst = false;

                // 구슬을 델타 방향으로 굴려보자
                Point pTemp = Rolling(pBFS, i, bRedFirst);

                // 파랑 구슬이 들어왔다??? 이 케이스는 넘어가자
                if(narrMap[pTemp.m_nBlueRow][pTemp.m_nBlueCol] == HOLE) {
                    continue;
                }
                // 빨강 구슬이 들어왔다 ??? 성공해부려따
                if(narrMap[pTemp.m_nRedRow][pTemp.m_nRedCol] == HOLE) {
                    return pTemp.m_nCount;
                }

                // 이미 방문했던 곳이면 돌아가자
                if(barrVisit[pTemp.m_nRedRow][pTemp.m_nRedCol][pTemp.m_nBlueRow][pTemp.m_nBlueCol])
                    continue;

                barrVisit[pTemp.m_nRedRow][pTemp.m_nRedCol][pTemp.m_nBlueRow][pTemp.m_nBlueCol] = true;

//				System.out.println(pTemp);
//				System.out.println("==============End");
                queueBFS.add(pTemp);
            }

        }

        // 경우의 수가 읎다
        return -1;
    }

    // 구슬을 굴려볼까유
    private static Point Rolling(Point pTemp, int nDirection, boolean bRedFirst) {
        //
        int[] narrMarble = new int[4];

        narrMarble[0] = pTemp.m_nRedRow;
        narrMarble[1] = pTemp.m_nRedCol;
        narrMarble[2] = pTemp.m_nBlueRow;
        narrMarble[3] = pTemp.m_nBlueCol;

        int nCount = pTemp.m_nCount;

        // 구슬을 굴리자

        for (int i = 0; i < 4; i += 2) {
            // 빨강 갯수만 필요
            // 인덱스 체크 범위 불필요~ 가장자리는 어차피 벽이다
            while (narrMap[narrMarble[i]][narrMarble[i + 1]] != HOLE
                    && narrMap[narrMarble[i] + dr[nDirection]][narrMarble[i + 1] + dc[nDirection]] != WALL) {
                narrMarble[i] += dr[nDirection];
                narrMarble[i + 1] += dc[nDirection];
            }
        }

        // 구슬의 위치기 같다면 ???
        // 둘다 홀이면 그냥 보내
        if (narrMarble[0] == narrMarble[2] && narrMarble[1] == narrMarble[3]
                && narrMap[narrMarble[0]][narrMarble[1]] != HOLE) {
            if (bRedFirst) {
                // 빨강 구슬부터 굴렸다
                // 파랑 구슬을 방향의 반대쪽으로 한칸 보내자
                narrMarble[2] -= dr[nDirection];
                narrMarble[3] -= dc[nDirection];

            } else {
                // 파랑 구슬부터 굴렸다
                // 빨강 구슬을 방향의 반대쪽으로 한칸 보내자
                narrMarble[0] -= dr[nDirection];
                narrMarble[1] -= dc[nDirection];
            }
        }

        return (new Point(narrMarble[0], narrMarble[1], narrMarble[2], narrMarble[3], pTemp.m_nCount+1 ));
    }
}