package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 톱니바퀴 {
    static boolean[][] barrGear = new boolean[4][8]; // 톱니바퀴 4개, 각각 8개 값

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 톱니바퀴 상태 입력 받고
        for (int i = 0; i < 4; i++) {
            String strLine = bReader.readLine();
            for (int j = 0; j < 8; j++) {
                if (strLine.charAt(j) == '1')
                    barrGear[i][j] = true;
            }
        }

        // 톱니바퀴 돌리자
        int K = Integer.parseInt(bReader.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            int nNum = Integer.parseInt(st.nextToken()) - 1; // 내껀 인덱스가 0부터 시작
            int nWay = Integer.parseInt(st.nextToken()); // 으데로 돌았니

            // 돌려볼까유~
            RotateGear(nNum, nWay);
        }

        int nScore = 0;
        for(int i = 0 ; i < 4; i++) {
            if(barrGear[i][0])
                nScore += Math.pow(2, i);
        }

        bWriter.write(String.valueOf(nScore));
        bWriter.close();
    }

    // 돌려볼까유우~
    private static void RotateGear(int nNum, int nWay) {
        if (nNum == 0) {
            // 1번을 돌렸다
            // 다음 방향으로 ?
            if (barrGear[0][2] != barrGear[1][6]) {
                if (barrGear[1][2] != barrGear[2][6]) {
                    if (barrGear[2][2] != barrGear[3][6])
                        moveGear(3, -nWay); // 톱니바퀴 4
                    moveGear(2, nWay); // 톱니바퀴3
                }
                moveGear(1, -nWay); // 톱니바퀴2
            }
            moveGear(0, nWay); // 톱니바퀴1
        }
        if (nNum == 1) {
            // 2번을 돌렸다
            // 다음 방향으로 ?
            if (barrGear[0][2] != barrGear[1][6]) {
                moveGear(0, -nWay); // 톱니바퀴1
            }
            if (barrGear[1][2] != barrGear[2][6]) {
                if (barrGear[2][2] != barrGear[3][6])
                    moveGear(3, nWay); // 톱니바퀴 4
                moveGear(2, -nWay); // 톱니바퀴3
            }
            moveGear(1, nWay); // 톱니바퀴 2
        }
        if (nNum == 2) {
            // 3번을 돌렸다
            // 다음 방향으로 ?
            if (barrGear[1][2] != barrGear[2][6]) {
                if (barrGear[0][2] != barrGear[1][6])
                    moveGear(0, nWay); // 톱니바퀴 1

                moveGear(1, -nWay); // 톱니바퀴 2
            }
            if (barrGear[2][2] != barrGear[3][6]) {
                moveGear(3, -nWay); // 톱니바퀴4
            }
            moveGear(2, nWay); // 톱니바퀴 3
        }
        if (nNum == 3) {
            // 4번을 돌렸다
            // 다음 방향으로 ?
            if (barrGear[2][2] != barrGear[3][6]) {
                if (barrGear[1][2] != barrGear[2][6]) {
                    if (barrGear[0][2] != barrGear[1][6])
                        moveGear(0, -nWay); // 톱니바퀴 1
                    moveGear(1, nWay); // 톱니바퀴2
                }
                moveGear(2, -nWay); // 톱니바퀴3
            }
            moveGear(3, nWay); // 톱니바퀴4
        }
    }

    // 톱니바퀴의 넘버와 방향을 받아서 움직이자
    private static void moveGear(int nNum, int nWay) {
        // 시계 방향
        if (nWay == 1) {
            boolean bTemp = barrGear[nNum][7]; // 톱니바퀴의 첫번째값을 저장해놓자
            for (int i = 6; i >= 0; i--)
                barrGear[nNum][i + 1] = barrGear[nNum][i];
            barrGear[nNum][0] = bTemp;

        } else { // 반시계 방향
            boolean bTemp = barrGear[nNum][0]; // 톱니바퀴의 마지막값을 저장해놓자
            for (int i = 0; i < 7; i++)
                barrGear[nNum][i] = barrGear[nNum][i + 1];
            barrGear[nNum][7] = bTemp;
        }

    }

}