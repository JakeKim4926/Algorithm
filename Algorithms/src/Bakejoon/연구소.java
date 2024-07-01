package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    static class Point {
        int m_nRow;
        int m_nCol;
        public Point(int m_nRow, int m_nCol) {
            super();
            this.m_nRow = m_nRow;
            this.m_nCol = m_nCol;
        }
    }

    static int N, M, nMax;
    static int[][] narrMap, narrTemp;
    static ArrayList<Point> SafePoints, VirusPoints;

    static int[] narrWall = new int[3];
    static boolean[] barrWall;
    // 동, 서, 남, 북
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};

    static final int SAFE = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        narrMap = new int[N][M];
        narrTemp = new int[N][M];
        SafePoints = new ArrayList<>();
        VirusPoints = new ArrayList<>();

        // zero 포인트들을 저장해놓자
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for(int j = 0; j < M; j++) {
                narrMap[i][j] = Integer.parseInt(st.nextToken());
                if(narrMap[i][j] == SAFE)
                    SafePoints.add(new Point(i,j));
                else if(narrMap[i][j] == VIRUS)
                    VirusPoints.add(new Point(i, j));
            }
        }
        // 조합으로 구하자
        barrWall = new boolean[SafePoints.size()];
        // 0인 곳에 벽을 놓는 모든 경우의 수를 구하자
        GetPerm(0);

        bWriter.write(String.valueOf(nMax));
        bWriter.close();
    }
    private static void GetPerm(int nIndex) {
        // 기저 조건
        if(nIndex == 3) {
            // 벽을 세울 세칸의 포인트를 지정하였따
            // 템플릿에 복사해주자
            for(int i = 0; i < 3; i++)
                narrMap[SafePoints.get(narrWall[i]).m_nRow][SafePoints.get(narrWall[i]).m_nCol] = WALL;
            Copy();
            BFS();
            // 벽을 다시 없애주자
            for(int i = 0; i < 3; i++)
                narrMap[SafePoints.get(narrWall[i]).m_nRow][SafePoints.get(narrWall[i]).m_nCol] = SAFE;

            return;
        }

        // 재귀 조건

        for(int i = 0; i < SafePoints.size(); i++) {
            if(!barrWall[i]) {
                if(nIndex > 0 && narrWall[nIndex-1] > i) {
                    continue;
                }
                barrWall[i] = true;
                narrWall[nIndex] = i;
                GetPerm(nIndex+1);
                barrWall[i] = false;
            }
        }

    }

    // 바이러스 퍼지는 과정을 BFS로
    private static void BFS() {
        // 바이러스를 퍼트리자
        Queue<Point> queueBFS = new LinkedList<>();
        for(int i = 0; i < VirusPoints.size(); i++)
            queueBFS.add(VirusPoints.get(i));
        while(!queueBFS.isEmpty()) {
            Point pTemp = queueBFS.poll();

            for(int i = 0; i < dr.length; i++) {
                int nSearchRow = pTemp.m_nRow + dr[i];
                int nSearchCol = pTemp.m_nCol + dc[i];

                // 범위 밖은 빠이
                if(nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= M)
                    continue;
                // 벽도 아니고 이미 바이러스도 아니면 퍼트려버려
                if(narrTemp[nSearchRow][nSearchCol] == SAFE) {
                    narrTemp[nSearchRow][nSearchCol] = VIRUS;
                    queueBFS.add(new Point(nSearchRow, nSearchCol));
                }
            }
        }

        // 바이러스 확산 끝나구
        // Max 값 비교하자
        getMaxSafe();
    }

    // Map의 값이 바뀌어버리면 돌이킬 수 없으니
    // 템플릿을 하나 만들어줘서 벽을 임의로 세우고 바이러스를 퍼트려보자
    private static void Copy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                narrTemp[i][j] = narrMap[i][j];
            }
        }
    }

    // 바이러스가 전부 퍼진뒤
    // 안전한 공간을 카운트 해서 최댓값과 비교하자
    private static void getMaxSafe() {
        int nCount = 0;
        // 0인값 == 안전 공간
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(narrTemp[i][j] == SAFE)
                    nCount++;
            }
        }

        if(nMax < nCount)
            nMax = nCount;
    }

}