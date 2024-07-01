package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 다리만들기2 {
    static class Point {
        int m_nRow;
        int m_nCol;
        int m_nDistance;

        public Point(int m_nRow, int m_nCol, int m_nDistance) {
            this.m_nRow = m_nRow;
            this.m_nCol = m_nCol;
            this.m_nDistance = m_nDistance;
        }
    }

    static class Node {
        int m_nEnd;
        int m_nDistance;

        public Node(int m_nEnd, int m_nDistance) {
            this.m_nEnd = m_nEnd;
            this.m_nDistance = m_nDistance;
        }

        @Override
        public String toString() {
            return "Node [m_nEnd=" + m_nEnd + ", m_nDistance=" + m_nDistance + "]";
        }


    }

    static int N, M, nIsland;
    static boolean[][] barrMap, barrVisit;
    static int[][] narrIsland;
    static boolean[] barrPrim;

    static ArrayList<Node>[] listIsland;

    static int dr[] = { 0, 0, 1, -1 };
    static int dc[] = { 1, -1, 0, 0 };

    static int[] narrPrim;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드 입력 받고
        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barrMap = new boolean[N][M];
        barrVisit = new boolean[N][M];
        narrIsland = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("1"))
                    barrMap[i][j] = true;
            }
        }

        nIsland = 0;
        // 우선, 섬들을 탐색해보자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (barrMap[i][j] && !barrVisit[i][j]) {
                    nIsland++;
                    // 섬이 하나 있다.
                    // 이 섬의 시작 땅을 추가해주고 탐색하여
                    narrIsland[i][j] = nIsland;
                    // 이 섬의 모든 땅 좌표를 추가해주자
                    DFS(i, j);
                }
            }
        }

        // 인접 리스트 초기화
        listIsland = new ArrayList[nIsland + 1];
        for (int i = 0; i < nIsland + 1; i++)
            listIsland[i] = new ArrayList<>();


        // 각 섬간의 최소 길이를 BFS로 찾아보자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nIslandNum = narrIsland[i][j];
                if (nIslandNum > 0) {
                    // 각 섬간의 최소 길이를 탐색해보자

                    // 가로 탐색
                    barrVisit = new boolean[N][M];
                    BFS(i, j, nIslandNum, true);
                    // 세로 탐색
                    barrVisit = new boolean[N][M];
                    BFS(i, j, nIslandNum, false);
                }
            }
        }


        bWriter.write(String.valueOf(prim()));
        bWriter.close();

    }

    // 섬들간의 최소 거리를 탐색해보자
    private static void BFS(int nRow, int nCol, int nIslandNum, boolean bVertical) {
        Queue<Point> queueBFS = new LinkedList<>();
        queueBFS.add(new Point(nRow, nCol, 0));

        while (!queueBFS.isEmpty()) {
            Point p = queueBFS.poll();

            int nNum = narrIsland[p.m_nRow][p.m_nCol];

//				continue;
            // 가로 탐색
            int nStartD = 0;
            int nEndD = 2;

            // 세로 탐색
            if(!bVertical) {
                nStartD = 2;
                nEndD =4;
            }

            for (int i = nStartD; i < nEndD; i++) {
                int nSearchRow = p.m_nRow + dr[i];
                int nSearchCol = p.m_nCol + dc[i];


                // 범위 밖이면 넘어가줘유
                if (nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= M)
                    continue;

                nNum = narrIsland[nSearchRow][nSearchCol];
                // 방문했던 곳이면 넘어가줘유
                // 이전에 이미 본 섬들은 볼 필요가 읎다

                if (barrVisit[nSearchRow][nSearchCol])
                    continue;

                barrVisit[nSearchRow][nSearchCol] = true;
                // 어떠한 섬에 도달 했을 경우 현재까지의 거리와 저장되어 있는 거리를 비교하여
                // 더 작은 거리를 넣어준다.
                // 그리고 탐색을 끝낸당
                if(nNum != 0) {

                    if(p.m_nDistance > 1) {
                        listIsland[nIslandNum].add(new Node(nNum, p.m_nDistance));
                    }
                    continue;
                }
                queueBFS.add(new Point(nSearchRow, nSearchCol, p.m_nDistance + 1));
            }
        }
    }

    // 섬들의 정보를 탐색해보자
    private static void DFS(int nRow, int nCol) {
        barrVisit[nRow][nCol] = true;

        for (int i = 0; i < dr.length; i++) {
            int nSearchRow = nRow + dr[i];
            int nSearchCol = nCol + dc[i];

            // 범위 밖이면 넘어가줘유
            if (nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= M)
                continue;

            // 섬이 아니거나 방문했던 곳이면 넘어가줘유
            if (!barrMap[nSearchRow][nSearchCol] || barrVisit[nSearchRow][nSearchCol])
                continue;

            // 이 땅 좌표를 저장해줘유
            // 다음 땅으로 넘어가유
            narrIsland[nSearchRow][nSearchCol] = nIsland;
            DFS(nSearchRow, nSearchCol);
        }
    }

    // 최소 다리 연결값을 찾자
    private static int prim() {
        narrPrim = new int[nIsland];
        barrPrim = new boolean[nIsland];
        Arrays.fill(narrPrim, Integer.MAX_VALUE);
        narrPrim[0] = 0;

        for(int i = 1; i <listIsland.length; i++) {
            if(listIsland[i].isEmpty())
                return -1;
        }

        int nResult = 0;
        for(int i = 0 ; i < nIsland; i++) {
            int nIndex = -1;
            int nMin = Integer.MAX_VALUE;

            // 탐색할 노드 번호를 정하자
            for(int j = 0; j < nIsland; j++) {
                if(nMin > narrPrim[j] && !barrPrim[j]) {
                    nMin = narrPrim[j];
                    nIndex = j;
                }
            }

            if(nIndex == -1) {
                nResult = -1;
                break;
            }

            nResult += narrPrim[nIndex];
            barrPrim[nIndex] = true;

            for(int j = 0; j < listIsland[nIndex+1].size(); j++) {
                int nNextNode = listIsland[nIndex+1].get(j).m_nEnd-1;
                int nDistance = listIsland[nIndex+1].get(j).m_nDistance;

                if(narrPrim[nNextNode] > nDistance && !barrPrim[nNextNode])
                    narrPrim[nNextNode] = nDistance;
            }
        }
        //System.out.println(Arrays.toString(narrPrim));

        if(nResult == 0)
            nResult = -1;

        return nResult;
    }
}