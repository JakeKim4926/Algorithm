package Bakejoon;

import java.util.Scanner;

public class 빙고 {
    public static boolean isBingo(boolean[][] barrTemp) {
        int nBingoCount = 0;
        boolean bSearch = false;

        // 가로 탐색
        for(int i = 0; i < barrTemp.length; i++) {
            bSearch = true;
            for(int j = 0; j < barrTemp[0].length ; j++) {
                if(!barrTemp[i][j]) {
                    bSearch = false;
                    break;
                }
            }
            if(bSearch)
                nBingoCount++;
        }

        // 세로 탐색
        for(int j = 0; j < barrTemp[0].length; j++) {
            bSearch = true;
            for(int i = 0; i < barrTemp.length ; i++) {
                if(!barrTemp[i][j]) {
                    bSearch = false;
                    break;
                }
            }

            if(bSearch)
                nBingoCount++;
        }
        // 북서, 남동 , 북동, 남서
        int[] dr = {-1, 1, -1,  1};
        int[] dc = {-1, 1,  1, -1};

        int nIndex= 0;
        for(int i = 0; i < 2; i++) {
            // 대각선 탐색
            int nRowPoint1 = 2;
            int nColPoint1 = 2;
            int nRowPoint2 = 2;
            int nColPoint2 = 2;

            bSearch = true;
            for(int j = 0; j < 2; j++) {
                nRowPoint1 += dr[nIndex];
                nColPoint1 += dc[nIndex];

                nRowPoint2 += dr[nIndex + 1];
                nColPoint2 += dc[nIndex + 1];

                if(!barrTemp[nRowPoint1][nColPoint1] || !barrTemp[nRowPoint2][nColPoint2]) {
                    bSearch = false;
                    break;
                }
            }
            if(bSearch)
                nBingoCount++;

            nIndex += 2;
        }

        if(nBingoCount >= 3)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arrBingo = new int[5][5];
        boolean[][] bBingos = new boolean[5][5];


        // 빙고판 데이터 삽입.
        for(int i = 0 ; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arrBingo[i][j] = sc.nextInt();
            }
        }

        // 사회자 숫자 호출
        for(int k = 1; k <= 25; k++) {
            int nBingoIndex = sc.nextInt();
            // 해당 숫자로 boolean 인덱스 찾기
            for(int i = 0 ; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(arrBingo[i][j] == nBingoIndex) {
                        bBingos[i][j] = true;
                        break;
                    }
                }
            }
            if(isBingo(bBingos)) {
                System.out.println(k);
                return;
            }

        }
    }
}
