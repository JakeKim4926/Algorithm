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

class Point {
    int m_nRow;
    int m_nCol;
    int m_nDistance;

    public Point(int m_nRow, int m_nCol, int m_nDistance) {
        this.m_nRow = m_nRow;
        this.m_nCol = m_nCol;
        this.m_nDistance = m_nDistance;
    }

}

public class 캐슬디펜스 {
    static boolean[][] barrVisited;
    static boolean[][] barrAttacked;
    static boolean[][] barrMap;
    static int N, M, D, nResult, nMax, nArcherIndex;
    static int[] arrArcher;
    static boolean[] barrArcVisit;

    // 서, 북, 동
    static int[] dr = { 0, -1, 0 };
    static int[] dc = { -1, 0, 1 };
    static Point[] pAttack = new Point[3];

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken()); // Row
        M = Integer.parseInt(st.nextToken()); // Col
        D = Integer.parseInt(st.nextToken()); // Distance

        barrMap = new boolean[N][M];
        arrArcher = new int[3];
        barrArcVisit = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    barrMap[i][j] = true;
                }
            }
        }
        // 궁수 번호 뽑자
        // 조합
        nMax = 0;
        ArcherNum(0);

        bWriter.write(String.valueOf(nMax));
        bWriter.close();
    }

    // 궁수 배치의 경우의 수
    // 이놈의 경우의 수
    private static void ArcherNum(int nIndex) {
        // 기저 조건
        if (nIndex == 3) {
            // System.out.println(Arrays.toString(arrArcher));
            // 각 궁수의 위치를 표현
            barrVisited = new boolean[N][M];
            barrAttacked = new boolean[N][M];
            nResult = 0;
            // 탐색합시다
            int nRow = N - 1;
            while (nRow >= 0) {
                // 궁수는 가장 가까운 왼쪽만 무조건 공격인듯 ??
                // 각각의 궁수 Col 위치의
                // N-1~0까지 D거리안의 가장 가까운 왼쪽 적을 탐색
                for (int i = 0; i < 3; i++) {
                    pAttack[i] = new Point(-1,-1,0);
                    nArcherIndex = i;
                    BFS(new Point(nRow, arrArcher[i], 0));
                }
                nRow--;
                // 위의 한 턴 (궁수 3명의 공격)에서 공격한 좌표를 불러와서
                // 공격한 Row, Col 좌표를 저장
                for(int i =0; i < 3; i++) {
                    int nEnemyRow = pAttack[i].m_nRow;
                    int nEnemyCol = pAttack[i].m_nCol;

                    // 궁수가 적이 없었거나 이미 공격했다고 카운트했으면 넘어가자
                    if(nEnemyRow == -1 || barrAttacked[nEnemyRow][nEnemyCol])
                        continue;

                    barrAttacked[nEnemyRow][nEnemyCol] = true;
                    nResult++;
                }
            }

            if(nMax < nResult)
                nMax = nResult;
            return;
        }

        // 재귀 조건
        // 0, 1, 2나
        // 2, 1, 0이나
        // 0 2,1 이나 궁수가 0,1,2 세위치에 배치되있는건 똑같자나??
        // 첫 배열값 아니면 이전 배열값 부터 시작해
        // 그니까 중복제거!
        int nArrNum = nIndex;
        if (nIndex != 0)
            nArrNum--;

        // 돌립시다
        for (int i = arrArcher[nArrNum]; i < M; i++) {
            if (!barrArcVisit[i]) {
                arrArcher[nIndex] = i;
                barrArcVisit[i] = true;
                ArcherNum(nIndex + 1);
                barrArcVisit[i] = false;
            }
        }

    }

    private static void BFS(Point Archer) {
        Queue<Point> queueBFS = new LinkedList<>();

        queueBFS.add(Archer);

        while (!queueBFS.isEmpty()) {
            // 적이 있다면 공격해버리고 포인트 저장!
            Point p = queueBFS.poll();

            // 거리가 D가 넘거나
            // 공격을 이미 했거나
            // bfs 방문했으면 넘어가버려
            if(barrVisited[p.m_nRow][p.m_nCol] || p.m_nDistance >= D)
                continue;

            // 이전 턴들에서 공격한 포인트가 아닌데 적이 존재하면 해당 좌표 저장
            // 가장 가까운 공격 포인트 찾으면 되니까 리턴
            if(barrMap[p.m_nRow][p.m_nCol] && !barrAttacked[p.m_nRow][p.m_nCol]) {
                pAttack[nArcherIndex] = p;
                return;
            }

            // 무조건 왼쪽 먼저
            for(int i = 0; i < dr.length; i++) {
                int nSearchRow = p.m_nRow + dr[i];
                int nSearchCol = p.m_nCol + dc[i];

                if(nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= M)
                    continue;

                queueBFS.add(new Point(nSearchRow, nSearchCol, p.m_nDistance + 1));
            }
        }
    }

}