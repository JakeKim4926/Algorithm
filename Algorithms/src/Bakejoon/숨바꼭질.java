package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int X;
    int nCount;

    public Point(int x, int nCount) {
        super();
        X = x;
        this.nCount = nCount;
    }

}

public class 숨바꼭질 {
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] barrVisited;
    static int nSecond = 0;
    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken()); // Subin
        K = Integer.parseInt(st.nextToken()); // Sunbin's Sister

        barrVisited = new boolean[200001];

        // 탐색합시당
        BFS();

        bWriter.write(String.valueOf(nSecond));

        bWriter.flush();
        bWriter.close();
    }

    public static void BFS() throws IOException {

        // subin can move -1 or +1 or *2
        Queue<Point> queueBfs = new LinkedList<>();
        queueBfs.add(new Point(N, 0));

        int[] narrNextPoints = new int[3];
        // BFS 돌려보자~
        while (!queueBfs.isEmpty()) {
            Point nXPoint = queueBfs.poll();

            // 종료 조건
            if (nXPoint.X == K) {
                nSecond = nXPoint.nCount;
                return;
            }

            narrNextPoints[0] = nXPoint.X - 1; // X-1
            narrNextPoints[1] = nXPoint.X + 1; // X+1
            narrNextPoints[2] = nXPoint.X * 2; // X*2

            for (int i = 0; i < narrNextPoints.length; i++) {
                if (narrNextPoints[i] <= 200000 && narrNextPoints[i] >= 0 && !barrVisited[narrNextPoints[i]] ) {
                    barrVisited[narrNextPoints[i]] = true;
                    queueBfs.add(new Point(narrNextPoints[i], nXPoint.nCount + 1));
                }
            }
        }
    }
}
출처: https://heih.tistory.com/101 [Hope Everyone Is Happy:티스토리]