package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class 치킨배달 {

    static class Point {
        int m_nRow;
        int m_nCol;

        public Point(int m_nRow, int m_nCol) {
            super();
            this.m_nRow = m_nRow;
            this.m_nCol = m_nCol;
        }
    }
    static int N, M, nMin;
    static int[][] narrMap;
    static boolean[] barrChick;
    static int[] narrChick;

    static ArrayList<Point> pHouse = new ArrayList<>();
    static ArrayList<Point> pChicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        narrMap = new int[N][N];
        nMin = Integer.MAX_VALUE;

        // 치킨집과 그냥 집의 위치들을 저장해놓자.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < N; j++) {
                int nTemp = Integer.parseInt(st.nextToken());
                if (nTemp == 1)
                    pHouse.add(new Point(i, j));
                else if (nTemp == 2)
                    pChicken.add(new Point(i, j));
            }
        }

        barrChick = new boolean[pChicken.size()];
        narrChick = new int[pChicken.size()];

        perm(0);

        bWriter.write(String.valueOf(nMin));
        bWriter.close();
    }

    public static void perm(int nIndex) {
        // 기저 조건
        // 최대 치킨집 갯수
        if(nIndex == M) {

            // 집 크기만큼 초기화 해주고
            int[] narrHouse = new int[pHouse.size()];
            Arrays.fill(narrHouse, Integer.MAX_VALUE);

            // 각 거리별 최소값을 비교하자
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < pHouse.size(); j++) {
                    int nDistance = getDistance(pChicken.get(narrChick[i]), pHouse.get(j));
                    if(narrHouse[j] > nDistance)
                        narrHouse[j] = nDistance;
                }
            }

            // 치킨집을 M개 고른 가정에서의 치킨거리의 합
            int nSum = 0;
            for(int i = 0; i < narrHouse.length; i++)
                nSum += narrHouse[i];

            // 최소값을 비교하여 리턴해야한다.
            if(nMin > nSum)
                nMin = nSum;

            return;
        }

        for(int i = 0; i < pChicken.size(); i++) {
            // 0, 1, 2, 했으면
            // 1, 0, 2 할 필요 없음~
            if(nIndex > 0 && narrChick[nIndex-1] > i)
                continue;

            if(!barrChick[i]) {
                barrChick[i] = true;
                narrChick[nIndex] = i;
                perm(nIndex+1);
                barrChick[i] = false;
            }
        }
    }

    // 치킨집 거리 리턴 받자
    public static int getDistance(Point p1, Point p2) {
        return (Math.abs(p1.m_nRow-p2.m_nRow) + Math.abs(p1.m_nCol-p2.m_nCol));
    }
}