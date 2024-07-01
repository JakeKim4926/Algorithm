package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int nRow;
    int nCol;

    public Point(int nRow, int nCol) {
        this.nRow = nRow;
        this.nCol = nCol;
    }
}

public class 토마토 {
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] barrVisited;
    static int[][] narrTomatos;
    static int nDay = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {

        // 대박 대박 대박
//        System.setIn(new FileInputStream(Main.class.getResource("input.txt").getPath()));

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        M = Integer.parseInt(st.nextToken()); // cols
        N = Integer.parseInt(st.nextToken()); // rows

        barrVisited = new boolean[N][M];
        narrTomatos = new int[N][M];

        ArrayList<Point> listPoint = new ArrayList<>();
        // 토마토 상태 입력받구
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                narrTomatos[i][j] = Integer.parseInt(st.nextToken());

                // 토마토가 자라나는 시작점 추가
                if (narrTomatos[i][j] == 1)
                    listPoint.add(new Point(i, j));
                else if (narrTomatos[i][j] == -1)
                    barrVisited[i][j] = true; // 방문할 필요가 없다아
            }
        }

        // 탐색합시당
        BFS(listPoint);

        // 어딘가 탐색 안된 곳이 있다 ? == 토마토가 안익은데가 있다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!barrVisited[i][j]) {
                    nDay = -1;
                    break;
                }
            }
            if(nDay==-1)
                break;
        }

        bWriter.write(String.valueOf(nDay));

        bWriter.flush();
        bWriter.close();
    }

    public static void BFS(ArrayList<Point> listPoint) throws IOException {

        Queue<Point>[] queueBfs = new LinkedList[listPoint.size()];
        // 시작 점이 여러 개일 수도 있으니,
        // 큐 배열로 선언해놓자.
        for (int i = 0; i < listPoint.size(); i++) {
            queueBfs[i] = new LinkedList<>();
            queueBfs[i].add(listPoint.get(i));
        }

        // 동 서 남 북 델타 돌리자
        int dr[] = { 0, 0, 1, -1 };
        int dc[] = { 1, -1, 0, 0 };

        // 하루에 하나씩이니까 탐색 후 다음 노드 대체 저장소를 하나 만들어주자
        Queue<Point> qNextNodes = new LinkedList<>();

        boolean bAllEmpty = false;
        // BFS 돌려볼까유~
        while (!bAllEmpty) {
            boolean bIsEmpty = true;
            for (int i = 0; i < listPoint.size(); i++) {
                // 토마토가 자라난다..

                while (!queueBfs[i].isEmpty()) {
                    Point p = queueBfs[i].poll();
                    // 상하좌우 탐색 후 0이면 1로 바꿔주고
                    // queue탐색 고고합시다
                    if (!barrVisited[p.nRow][p.nCol]) {

                        barrVisited[p.nRow][p.nCol] = true;
                        for (int k = 0; k < dr.length; k++) {
                            int nSearchRow = p.nRow + dr[k];
                            int nSearchCol = p.nCol + dc[k];

                            // 토마토 익는다.
                            if (nSearchRow >= 0 && nSearchCol >= 0 && nSearchRow < N && nSearchCol < M
                                    && narrTomatos[nSearchRow][nSearchCol] == 0 && !barrVisited[nSearchRow][nSearchCol]) {
                                qNextNodes.add(new Point(nSearchRow, nSearchCol));
                                narrTomatos[nSearchRow][nSearchCol] = 1;
                            }
                        }
                    }
                }

                // 탐색 끝났다아
                if(bIsEmpty && !qNextNodes.isEmpty())
                    bIsEmpty = false;

                while (!qNextNodes.isEmpty()) {
                    queueBfs[i].add(qNextNodes.poll());
                }

            }
            bAllEmpty = bIsEmpty;
            //System.out.println(Arrays.deepToString(barrVisited));
            // 다 탐색했다
            if(bAllEmpty)
                break;

            // 하루가 지났따
            nDay++;
        }

    }
}