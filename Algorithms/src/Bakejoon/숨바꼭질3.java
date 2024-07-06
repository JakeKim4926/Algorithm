package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 숨바꼭질3 {
    static class Point {
        int m_nNum;
        int m_nCount;

        public Point(int m_nNum, int m_nCount) {
            super();
            this.m_nNum = m_nNum;
            this.m_nCount = m_nCount;
        }
    }
    static int N, K, nMax;
    static boolean[] barrVisit;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N > K)
            nMax = N;
        else
            nMax = K;

        barrVisit = new boolean[(nMax+1) * 2];
        int nResult = BFS();

        bWriter.write(String.valueOf(nResult));
        bWriter.close();
    }

    private static int BFS() {
        // TODO Auto-generated method stub
        Queue<Point> qBFS = new LinkedList<>();
        qBFS.add(new Point(N, 0));
        barrVisit[N] = true;

        while(!qBFS.isEmpty()) {
            Point p = qBFS.poll();

            int nPlus = p.m_nNum +1;
            int nMinus = p.m_nNum -1;
            int nMul = p.m_nNum * 2;

            if(p.m_nNum == K) {
                return p.m_nCount;
            }

            if(nMul < (nMax+1) * 2 && !barrVisit[nMul] ) {
                barrVisit[nMul] = true;
                qBFS.add(new Point(nMul, p.m_nCount));
            }
            if(nMinus >= 0 && !barrVisit[nMinus]) {
                barrVisit[nMinus] = true;
                qBFS.add(new Point(nMinus, p.m_nCount+1));
            }
            if(nPlus < (nMax+1) * 2 && !barrVisit[nPlus]) {
                barrVisit[nPlus] = true;
                qBFS.add(new Point(nPlus, p.m_nCount+1));
            }
        }
        return 0;
    }
}