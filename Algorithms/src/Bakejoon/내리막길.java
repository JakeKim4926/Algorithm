package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내리막길 {
    static int[][] narrMap;
    static int[][] narrDP;
    static int nCount;
    static int M, N;

    // 동서남북
    static int[] dr = { 0, 0, 1 , -1};
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        // Row, Col 입력 받아주고
        M = Integer.parseInt(st.nextToken()); // Rows
        N = Integer.parseInt(st.nextToken()); // Cols

        // 방문 배열 선언해주고
        narrDP = new int[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++)
                narrDP[i][j] = -1;
        }
        narrMap = new int[M][N];
        // 지도 값 입력 받고
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bReader.readLine());
            for(int j = 0 ; j < N; j++) {
                narrMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // DFS 탐색 시작
        nCount = DFS(0,0);

        bWriter.write(String.valueOf(nCount));

        bWriter.flush();
        bWriter.close();
    }

    public static int DFS(int nRow, int nCol) {
        // 기저 조건
        if(nRow == M-1 && nCol == N-1) {
            return 1;
        }

        if (narrDP[nRow][nCol] > -1)
            return narrDP[nRow][nCol];

        // 탐색 조건
        // 본인보다 작은 값만 찾아간다아
        narrDP[nRow][nCol] = 0;
        for (int k = 0; k < dr.length; k++) {
            int nRowSearch = nRow + dr[k];
            int nColSearch = nCol + dc[k];

            // 동, 서, 남, 북 중 높이가 낮은 곳만!
            if (nRowSearch >= 0 && nColSearch >= 0 && nRowSearch < M && nColSearch < N
                    && narrMap[nRow][nCol] > narrMap[nRowSearch][nColSearch]) {
                // 방문 배열 값에 넣어주기
                narrDP[nRow][nCol] += DFS(nRowSearch, nColSearch);
            }
        }
        // 방문 배열 값 return
        return narrDP[nRow][nCol];
    }
}