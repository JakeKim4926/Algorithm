package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이붙이기 {

    static int nMin, nTemp;
    static boolean[][] barrMap, barrCheck;
    static int[] narrPaper;
    final static int SIZE = 10;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        barrMap = new boolean[SIZE][SIZE];
        barrCheck = new boolean[SIZE][SIZE];
        narrPaper = new int[5];

        nMin = Integer.MAX_VALUE;

        // 색종이 입력 받자
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < SIZE; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    barrMap[i][j] = true;
            }
        }
        // 가장 큰 사이즈인 5부터 검사를 시작
        // 하지만 5가 들어가있어서 더 많을 수도 있으니
        // 다른 경우도 검사해보자
        Arrays.fill(narrPaper, 5);

        Paper(0, 0, 0);

        if (nMin == Integer.MAX_VALUE)
            nMin = -1;

        bWriter.write(String.valueOf(nMin));
        bWriter.close();

    }

    private static void Paper(int nRow, int nCol, int nCount) {
        // 색종이가
        int nSearchRow = -1;
        int nSearchCol = -1;
        for (int i = nRow; i < SIZE; i++) {
            for (int j = nCol; j < SIZE; j++) {

                if (barrMap[i][j] && !barrCheck[i][j]) {
                    nSearchRow = i;
                    nSearchCol = j;
                    break;
                }
            }
            if (nSearchRow != -1)
                break;
        }

        if (nSearchRow == -1) {
            if (nMin > nCount && IsDone())
                nMin = nCount;
            return;
        }
        if (nCount > nMin)
            return;

        for (int k = 5; k > 0; k--) {
            if (!barrCheck[nSearchRow][nSearchCol] && narrPaper[k - 1] > 0) {
                // 사각형인 것을 확인했다믄
                if (RectMasking(nSearchRow, nSearchCol, k)) {
                    narrPaper[k - 1]--;

                    Paper(nSearchRow, 0, nCount + 1);

                    narrPaper[k - 1]++;
                    Checking(nSearchRow, nSearchCol, k, false);
                }
            }
        }

        // 색종이가 다 붙여졌다??

    }

    // 사각형 검사
    private static boolean RectMasking(int nRow, int nCol, int nSize) {
        for (int i = nRow; i < nRow + nSize; i++) {
            for (int j = nCol; j < nCol + nSize; j++) {
                // 사각형이 될 수 없다
                // 범위 밖, 1이 없다, 이미 체크 했다
                if (i < 0 || j < 0 || i >= SIZE || j >= SIZE || !barrMap[i][j] || barrCheck[i][j])
                    return false;
            }
        }
        Checking(nRow, nCol, nSize, true);
        // System.out.println(nRow + " " + nCol + " " + nSize);
        // 여기 왔다는건 사각형이라는 뜻이다.
        return true;
    }

    private static void Checking(int nRow, int nCol, int nSize, boolean bSwitch) {
        for (int i = nRow; i < nRow + nSize; i++) {
            for (int j = nCol; j < nCol + nSize; j++) {
                barrCheck[i][j] = bSwitch;
            }
        }
    }

    // 모든 1이 (색종이가) 체크가 되었나???
    private static boolean IsDone() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (barrMap[i][j] != barrCheck[i][j]) {
                    System.out.println("ROW : " + i + " / COL : " + j);
                    return false;
                }
            }
        }
        return true;
    }
}