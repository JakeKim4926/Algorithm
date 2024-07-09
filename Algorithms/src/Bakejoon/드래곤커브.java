package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤커브 {

    static int N, X, Y, D, G;
    static boolean[][] barrMap;
    static ArrayList<Integer> listCurve;
    // 동, 북, 서, 남 == 0,1,2,3
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 대박 대박 대박
//        System.setIn(new FileInputStream(드래곤커브.class.getResource("input.txt").getPath()));

        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 커브 횟수 받구
        N = Integer.parseInt(bReader.readLine());
        barrMap = new boolean[101][101];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            listCurve = new ArrayList<>();
            // 0 세대는 미리 추가
            listCurve.add(D);

            dragonCurve();
        }

        int nResult = getRect();

        bWriter.write(String.valueOf(nResult));
        bWriter.close();
    }

    private static int getRect() {

        int nRectCount = 0;
        // 1x1 정사각형 일 때마다 카운트
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(barrMap[i][j] && barrMap[i][j+1]
                        && barrMap[i+1][j] && barrMap[i+1][j+1])
                    nRectCount++;
            }
        }

        return nRectCount;
    }

    private static void dragonCurve() {
        // 세대 별로 규칙 적용
        // 세대가 지날 수록 LIFO 구조 +1을 쌓는다.
        while(G > 0) {
            int nSize = listCurve.size();
            for(int i = nSize-1; i >=0 ; i--) {
                // 반시계 방향 90도면 방향 +1과 동일
                int nDirection = listCurve.get(i) + 1;
                if(nDirection > 3)
                    nDirection -= 4;

                listCurve.add(nDirection);

            }
            G--;
        }

        MarkCurve();
    }

    // 토대로 표시해준 방향을 커브가 지나간 곳을 true 표시해주자
    private static void MarkCurve() {
        int nRow = Y;
        int nCol = X;
        barrMap[nRow][nCol] = true;
        for(int i = 0; i < listCurve.size(); i++) {
            // 커브가 지나간 점들을 다 true 표시해주공
            nRow += dr[listCurve.get(i)];
            nCol += dc[listCurve.get(i)];

            if(!barrMap[nRow][nCol])
                barrMap[nRow][nCol] = true;
        }
    }


}