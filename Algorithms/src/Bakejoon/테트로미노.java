package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int N, M, nMax;
    static int[][] narrMap;
    static boolean[][] barrVisit;

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

        // map 값 입력 받자
        narrMap = new int[N][M];
        barrVisit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                narrMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nMax = 0;
        // 첫번째 칸 부터 완전 탐색 돌리자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //barrVisit = new boolean[N][M];
                // ㅜ 모양을 제외한 나머지는 DFS로 4칸만 탐색하면 된다 (feat.릴라좌 땅큐)
                barrVisit[i][j] = true;
                DFS(i, j, narrMap[i][j], 0);
                barrVisit[i][j] = false;
                // ㅜ 모양을 대칭 or 회전했을 때 max값과 비교하자
                for(int k = 1; k <= 4; k++)
                    FuShape(i, j, k);
            }
        }

        bWriter.write(String.valueOf(nMax));
        bWriter.close();
    }

    // 4칸 탐색 고고하자
    private static void DFS(int nRow, int nCol, int nSum, int nDepth) {
        // 기저 조건
        // ㅗ모양을 제외한 나머지는 4번 탐색을 진행
        if (nDepth == 3) {
            nMax = Math.max(nMax, nSum);
            return;
        }

        // 재귀 조건
        for (int i = 0; i < 4; i++) {
            int nSearchRow = nRow + dr[i];
            int nSearchCol = nCol + dc[i];

            // 방문했거나 범위 밖이면 패쓰
            if (nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= M
                    || barrVisit[nSearchRow][nSearchCol])
                continue;


            // Depth가 4인 모든 곳을 탐색하기 위해
            // 해당 칸에 이어진 Depth 탐색 시 방문처리에 true값 넣어주고
            // 해당 칸에 이어진 탐색 종료 시 false로 변경
            barrVisit[nSearchRow][nSearchCol] = true;
            DFS(nSearchRow, nSearchCol, nSum + narrMap[nSearchRow][nSearchCol], nDepth + 1);
            barrVisit[nSearchRow][nSearchCol] = false;
        }
    }

    // ㅗ모양 탐색하자
    private static void FuShape(int nRow, int nCol, int nNum) {
        // 현재 점을 중심으로 ㅗ모양을 대칭 및 방향전환 했을 때 가능한 탐색 구간 고고
        int nSum = narrMap[nRow][nCol];
        // ㅗ 모양
        if (nNum == 1) {
            // 배열의 범위 체크는 필수~
            if (nRow + 1 >= N || nCol - 1 < 0 || nCol + 1 >= M)
                return;
            nSum += narrMap[nRow][nCol - 1];
            nSum += narrMap[nRow + 1][nCol];
            nSum += narrMap[nRow][nCol + 1];
        }
        // ㅏ 모양
        if (nNum == 2) {
            // 배열의 범위 체크는 필수~
            if (nRow + 1 >= N || nRow - 1 < 0 || nCol + 1 >= M)
                return;
            nSum += narrMap[nRow + 1][nCol];
            nSum += narrMap[nRow][nCol + 1];
            nSum += narrMap[nRow - 1][nCol];
        }
        // ㅜ 모양
        if (nNum == 3) {
            // 배열의 범위 체크는 필수~
            if (nRow - 1 < 0 || nCol - 1 < 0 || nCol + 1 >= M)
                return;
            nSum += narrMap[nRow][nCol - 1];
            nSum += narrMap[nRow - 1][nCol];
            nSum += narrMap[nRow][nCol + 1];
        }
        // ㅓ 모양
        if (nNum == 4) {
            // 배열의 범위 체크는 필수~
            if (nRow + 1 >= N || nRow - 1 < 0 || nCol - 1 < 0)
                return;
            nSum += narrMap[nRow + 1][nCol];
            nSum += narrMap[nRow][nCol - 1];
            nSum += narrMap[nRow - 1][nCol];
        }
        // max와 비교해보자
        nMax = Math.max(nSum, nMax);
    }
}