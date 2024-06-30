package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class GameMap {
    int[][] m_narrTemp;
    int m_nCount;

    public GameMap() {
        // TODO Auto-generated constructor stub
    }

    public GameMap(int[][] m_narrTemp, int m_nCount) {
        this.m_narrTemp = m_narrTemp;
        this.m_nCount = m_nCount;
    }
}

public class Game2048 {

    static int N;
    static int[][] narrMap;
    static boolean[][] barrVisit;
    static int nMax;

    // 델타 탐색
    static int dr[] = { 0, 0, 1, -1 };
    static int dc[] = { 1, -1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bReader.readLine());

        narrMap = new int[N][N];

        // 맵 정보 입력 받자
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < N; j++) {
                narrMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nMax = 2;
        // BFS 탐색을 통해 게임에서 가능한 모든 경우의 수를 돌려보자
        BFS_2048();

        bWriter.write(String.valueOf(nMax));
        bWriter.close();
    }

    private static void BFS_2048() {
        Queue<GameMap> queueBFS = new LinkedList<>();

        queueBFS.add(new GameMap(narrMap, 0));

        // 탐색 돌리자아
        while (!queueBFS.isEmpty()) {
            GameMap temp = queueBFS.poll();

            // 5번에 도달했으니 sum을 갖고 와서 max와 비교
            if (temp.m_nCount == 5) {
                int nSum = getVal(temp.m_narrTemp);
                if (nMax < nSum) {
                    nMax = nSum;
                }

                continue;
            }

            int[][] narrCopy = new int[N][N];
            // 깊은 복사 해야해 아마두,,?
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    narrCopy[i][j] = temp.m_narrTemp[i][j];
            }

            // 블록을 움직이자
            for (int k = 0; k < dr.length; k++) {
                // 맵의 결과가 똑같으면 더 이상 탐색을 진행 하지 않는다.
                // System.out.println(temp.m_nCount + " <<<<< 카운트 ");
                int[][] narrResult = new int[N][N];

                // 깊은 복사 해야해 델타 돌때마다,, 극혐,,
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++)
                        narrResult[i][j] = narrCopy[i][j];
                }
                // 무빙 또 보고싶다
                if (Moving(narrResult, k)) {
                    queueBFS.add(new GameMap(narrResult, temp.m_nCount + 1));
                } else {
                    // 더 이상 이 블록은 탐색하지 않으니 Max값을 저장해두자
                    int nSum = getVal(temp.m_narrTemp);

                    if (nMax < nSum) {
                        nMax = nSum;
                    }
                }
            }

        }
    }

    private static boolean Moving(int[][] narrCopy, int nDirection) {
        // 북쪽이면 0~N-1
        // 남쪽이면 N-1~0
        // 서쪽이면 0~N-1
        // 동쪽이면 N-1~0
        barrVisit = new boolean[N][N];
        boolean bFind = false;
        // 동쪽 방향
        if (nDirection == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    // 블록을 찾으면 ?
                    if (narrCopy[i][j] > 0) {
                        boolean bResult = Doing(i, j, nDirection, narrCopy);
                        // 블록이 움직였으므로 true로 바꿔준다
                        if (!bFind && bResult)
                            bFind = true;
                    }
                }
            }
        }
        // 서쪽 방향
        if (nDirection == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 블록을 찾으면 ?
                    if (narrCopy[i][j] > 0) {
                        boolean bResult = Doing(i, j, nDirection, narrCopy);
                        // 블록이 움직였으므로 true로 바꿔준다
                        if (!bFind && bResult)
                            bFind = true;
                    }
                }
            }
        }
        // 남쪽 방향
        if (nDirection == 2) {

            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < N; j++) {
                    // 블록을 찾으면 ?

                    if (narrCopy[i][j] > 0) {
                        boolean bResult = Doing(i, j, nDirection, narrCopy);
                        // 블록이 움직였으므로 true로 바꿔준다
                        if (!bFind && bResult)
                            bFind = true;
                    }
                }
            }
        }
        // 북쪽 방향
        if (nDirection == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 블록을 찾으면 ?
                    if (narrCopy[i][j] > 0) {
                        boolean bResult = Doing(i, j, nDirection, narrCopy);
                        // 블록이 움직였으므로 true로 바꿔준다
                        if (!bFind && bResult)
                            bFind = true;
                    }
                }
            }
        }

        return bFind;
    }

    // 배열 안의 최댓값을 리턴하자
    public static int getVal(int[][] narrTemp) {
        int nMaxTemp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                nMaxTemp = Math.max(nMaxTemp, narrTemp[i][j]);
        }

        return nMaxTemp;
    }

    // 블록을 움직이자
    public static boolean Doing(int i, int j, int nDirection, int[][] narrCopy) {
        int nSearchRow = i;
        int nSearchCol = j;
        // 한번 합쳐졌는지 체크 해볼 배열
        // 다른 블럭 or 배열 외곽에 도달할 때 까지
        boolean bFind = false;
        while (nSearchRow >= 0) {

            nSearchRow += dr[nDirection];
            nSearchCol += dc[nDirection];

            // 범위 체크
            if (nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= N) {

                nSearchRow -= dr[nDirection];
                nSearchCol -= dc[nDirection];

                // 맵 정보 변경
                int nTemp = narrCopy[i][j];
                narrCopy[i][j] = 0;
                narrCopy[nSearchRow][nSearchCol] = nTemp;

                break;
            }

            // 앞에 블록이 있는데
            if (narrCopy[nSearchRow][nSearchCol] > 0) {

                int nNowRow = nSearchRow - dr[nDirection];
                int nNowCol = nSearchCol - dc[nDirection];
                // 숫자가 같다 ???
                if (narrCopy[i][j] == narrCopy[nSearchRow][nSearchCol]
                        && !barrVisit[nSearchRow][nSearchCol]) {
                    barrVisit[nSearchRow][nSearchCol] = true;

                    // 맵정보 변경 -> 블록 합치기
                    narrCopy[nSearchRow][nSearchCol] *= 2;
                    narrCopy[i][j] = 0;

                    if(!bFind)
                        bFind = true;
                } else {
                    // 이미 방문했거나 숫자가 같지 않다
                    int nTemp = narrCopy[i][j];
                    narrCopy[i][j] = 0;
                    narrCopy[nNowRow][nNowCol] = nTemp;
                }
                break;
            }
            if(!bFind)
                bFind = true;
        }

        return bFind;
    }

}