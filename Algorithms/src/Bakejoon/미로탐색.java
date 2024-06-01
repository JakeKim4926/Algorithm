package Bakejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static class MazeInform {
        int nRow;
        int nCol;
        int nCount;

        public MazeInform(int nRow, int nCol, int nCount) {
            this.nRow = nRow;
            this.nCol = nCol;
            this.nCount = nCount;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int nMin = 9999999;

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        int nRows = Integer.parseInt(st.nextToken());
        int nCols = Integer.parseInt(st.nextToken());

        // 미로 값 저장 배열, 탐색 여부 저장 배열.
        boolean[][] barrMaze = new boolean[nRows][nCols];
        boolean[][] bIsSearched = new boolean[nRows][nCols];

        // 미로 값 저장.
        for(int i = 0; i < nRows; i++) {
            String strTemp = bReader.readLine();
            for(int j = 0; j < nCols; j++) {
                if(strTemp.charAt(j) == '1')
                    barrMaze[i][j] = true;
                else
                    barrMaze[i][j] = false;
            }
        }

        // 북, 동, 남, 서
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        // BFS를 위한 큐 + (0,0)은 반드시 1 (문제에서의 (1,1))
        Queue<MazeInform> qBuffer = new LinkedList<>();
        bIsSearched[0][0] = true;
        qBuffer.add(new MazeInform(0, 0, 1));

        // BFS
        while(!qBuffer.isEmpty()) {
            MazeInform mazeTemp = qBuffer.poll();
            for(int k = 0; k < dr.length; k++) {
                // 방향 탐색.
                int nRowPoint = mazeTemp.nRow + dr[k];
                int nColPoint = mazeTemp.nCol + dc[k];
                int nCount = mazeTemp.nCount;

                if(nRowPoint < 0 || nRowPoint >= nRows || nColPoint < 0 || nColPoint >= nCols ||
                        bIsSearched[nRowPoint][nColPoint])
                    continue;

                bIsSearched[nRowPoint][nColPoint] = true;

                // 다음 방향이 1이면 이동, qBuffer에 저장.
                if(barrMaze[nRowPoint][nColPoint]) {
                    nCount++;
                    qBuffer.add(new MazeInform(nRowPoint, nColPoint, nCount));
                }

                // 도착 했을 경우, 최소값 비교 ( 최소 경로 )
                if(nRowPoint == nRows-1 && nColPoint == nCols-1 && nMin > nCount)
                    nMin = nCount;

            }
        }
        System.out.println(nMin);
    }
}