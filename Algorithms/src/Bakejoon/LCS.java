package Bakejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String strFirstWord = bf.readLine();
        String strSecondWord = bf.readLine();

        int[][] arrTemp = new int[strSecondWord.length()][strFirstWord.length()];
        int nMax = 0;

        int nSearchi = 0;
        int nSearchj = 0;

        for(int i = 0; i < strSecondWord.length(); i++) {
            for(int j = 0; j < strFirstWord.length(); j++) {
                nSearchi = i-1;
                nSearchj = j-1;

                // LCS-알고리즘 왼쪽과 위의 인덱스를 비교
                if(strFirstWord.charAt(j) != strSecondWord.charAt(i)) {
                    // (i-1, j) 좌표와 비교
                    if(nSearchi >= 0)
                        arrTemp[i][j] = arrTemp[nSearchi][j] > arrTemp[i][j] ? arrTemp[nSearchi][j] : arrTemp[i][j];
                    // (i, j-1) 좌표와 비교
                    if(nSearchj >= 0)
                        arrTemp[i][j] = arrTemp[i][j] > arrTemp[i][nSearchj] ? arrTemp[i][j] : arrTemp[i][nSearchj];
                } else if(strFirstWord.charAt(j) == strSecondWord.charAt(i)) {
                    // (i-1),(j-1) 데이터 갖고와서 +1
                    if(nSearchi >= 0 && nSearchj >= 0) {
                        arrTemp[i][j] = arrTemp[nSearchi][nSearchj] + 1;
                    } else
                        arrTemp[i][j]++;
                }

                if(nMax < arrTemp[i][j])
                    nMax = arrTemp[i][j];
            }
        }
        System.out.println(nMax);
    }
}
