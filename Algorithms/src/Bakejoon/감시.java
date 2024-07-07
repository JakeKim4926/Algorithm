package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 감시 {

    static class Point {
        int m_nRow;
        int m_nCol;
        int m_nNum;

        public Point(int m_nRow, int m_nCol, int m_nNum) {
            super();
            this.m_nRow = m_nRow;
            this.m_nCol = m_nCol;
            this.m_nNum = m_nNum;
        }
    }
    static int N, M, nMin, nResult;
    static int[][] narrMap;


    static ArrayList<Point> pCCTV;
    // 동, 서, 남, 북
    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        narrMap = new int[N][M];
        pCCTV = new ArrayList<>();

        // 맵 값 입력 받고
        // CCTV 값들을 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                narrMap[i][j] = Integer.parseInt(st.nextToken());
                if (narrMap[i][j] > 0 && narrMap[i][j] < 6)
                    pCCTV.add(new Point(i, j, narrMap[i][j]));
            }
        }

        nMin = Integer.MAX_VALUE;
        if(!pCCTV.isEmpty()) {
            DFS(0);
        }
        else {
            // cctv가 1도 없다.
            nMin = getZeroCount();
        }

        if(nMin == Integer.MAX_VALUE)
            nMin = 0;


        bWriter.write(String.valueOf(nMin));
        bWriter.close();
    }

    // N과 M 형태로 풀어볼까,,,?
    private static void DFS(int nCount) {
        // 탐색 종료 조건
        if (nCount == pCCTV.size()) {
            // 제로가 몇개인지 세구
            // 비교하자

            int nZero = getZeroCount();
            if (nMin > nZero) {
                nMin = nZero;
            }
            return;
        }
        Point pPoint = pCCTV.get(nCount);
        int[][] narrSave = new int[N][M];
        // 탐색 전 상태의 Map을 저장해놓구
        // 탐색 후에 해당 탐색의 직전 상태로 돌려놓자
        copy(narrSave, narrMap);

        // 1번, 동,서,남,북 네 방향
        if (pPoint.m_nNum == 1) {
            for (int i = 0; i < dr.length; i++) {
                checkCCTV(pPoint.m_nRow, pPoint.m_nCol, i);
                DFS(nCount + 1);
                copy(narrMap, narrSave);
            }
        } else if (pPoint.m_nNum == 2) {
            // 2번, 동서, 남북 두방향
            for (int i = 0; i < dr.length; i += 2) {
                checkCCTV(pPoint.m_nRow, pPoint.m_nCol, i);
                checkCCTV(pPoint.m_nRow, pPoint.m_nCol, i + 1);
                DFS(nCount + 1);
                copy(narrMap, narrSave);
            }
        } else if (pPoint.m_nNum == 3) {
            // 3번, 북동, 동남, 남서, 서북 4방향
            for (int i = 2; i < dr.length; i++) {
                for (int j = 0; j < 2; j++) {
                    checkCCTV(pPoint.m_nRow, pPoint.m_nCol, i);
                    checkCCTV(pPoint.m_nRow, pPoint.m_nCol, j);
                    DFS(nCount + 1);
                    copy(narrMap, narrSave);
                }
            }
        } else if (pPoint.m_nNum == 4) {
            // 4번, 4방향 전부 탐색에서 하나씩 뺀거
            for (int i = 0; i < dr.length; i++) {
                for(int j = i; j < i+3; j++) {
                    int nDirect = j;
                    if(nDirect > 3)
                        nDirect -= 4;
                    checkCCTV(pPoint.m_nRow, pPoint.m_nCol, nDirect);
                }
                DFS(nCount + 1);
                copy(narrMap, narrSave);
            }
        } else if (pPoint.m_nNum == 5) {
            // 모든 방향
            for (int i = 0; i < dr.length; i++) {
                checkCCTV(pPoint.m_nRow, pPoint.m_nCol, i);
            }
            DFS(nCount + 1);
            copy(narrMap, narrSave);
        }

    }

    // 사각지대 갯수 뽑자
    private static int getZeroCount() {
        int nCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (narrMap[i][j] == 0)
                    nCount++;
            }
        }
        return nCount;
    }

    // CCTV가 보는 방향을 체크해두자
    private static void checkCCTV(int nRow, int nCol, int nDirect) {
        int nSearchRow = nRow + dr[nDirect];
        int nSearchCol = nCol + dc[nDirect];
        while (nSearchRow >= 0 && nSearchCol >= 0 && nSearchRow < N && nSearchCol < M) {
            if (narrMap[nSearchRow][nSearchCol] == 0)
                narrMap[nSearchRow][nSearchCol] = 7;
            else if (narrMap[nSearchRow][nSearchCol] == 6) // 오직 벽만 break
                break;
            nSearchRow += dr[nDirect];
            nSearchCol += dc[nDirect];
        }
    }

    private static void copy(int[][] narrTo, int[][] narrFrom) {
        // 임시 템플릿 배열에 복사해놓자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                narrTo[i][j] = narrFrom[i][j];
            }
        }
    }

}