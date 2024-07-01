package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {
    static boolean[][] barrVisited;
    static boolean[][] barrMap;
    static int nCount;

    // 동서 남북
    static int[] dr = {0 , 0, 1, -1};
    static int[] dc = {1 , -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bReader.readLine());

        barrVisited = new boolean[N][N];
        barrMap = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String strLine = bReader.readLine();
            for(int j = 0 ; j < N; j++) {
                if(strLine.charAt(j) == '1') {
                    barrMap[i][j] = true;
                }
            }
        }

        ArrayList<Integer> listCounts = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!barrVisited[i][j] && barrMap[i][j]) {
                    nCount = 0;
                    DFS(i,j);
                    listCounts.add(nCount);
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(listCounts);
        // 출력
        bWriter.write(listCounts.size() + "\n");
        for(int i = 0; i < listCounts.size(); i++) {
            bWriter.write(listCounts.get(i) + "\n");
        }

        bWriter.flush();
        bWriter.close();
    }

    public static void DFS(int nRow, int nCol) {
        // 기저 조건
        if(barrVisited[nRow][nCol])
            return;

        // 탐색 조건
        nCount++; // 탐색 횟수 카운트 == 집의 갯수
        barrVisited[nRow][nCol] = true;
        for(int k = 0; k < dr.length; k++) {
            int nRowSearch = nRow+dr[k];
            int nColSearch = nCol+dc[k];

            // 동, 서, 남, 북 중 집이 있으면!
            if(nRowSearch >= 0 && nColSearch >= 0
                    && nRowSearch < barrMap[0].length && nColSearch < barrMap[0].length
                    && barrMap[nRowSearch][nColSearch])
                DFS(nRowSearch, nColSearch);
        }
    }
}