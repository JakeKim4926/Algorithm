package Bakejoon;

import java.io.*;
import java.util.StringTokenizer;

public class 직사각형 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int nFruit = Integer.parseInt(bReader.readLine());
        int[] narrWay = new int[6];
        int[] narrLen = new int[6];

        // 입력 받구~
        for(int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            int nWay = Integer.parseInt(st.nextToken());
            int nLength = Integer.parseInt(st.nextToken());

            narrWay[i] = nWay;
            narrLen[i] = nLength;
        }
        int nHigherWidth = 0;
        int nHigherHeight = 0;

        int nWidthIndex = 0;
        int nHeightIndex = 0;

        for(int i = 0 ; i < 6; i++) {
            // 가로일 때
            if(narrWay[i] == 1 || narrWay[i] == 2) {
                if(nHigherWidth < narrLen[i]) {
                    nHigherWidth = narrLen[i];
                    nWidthIndex = i;
                }
            }
            // 세로 일 때
            if(narrWay[i] == 3 || narrWay[i] == 4) {
                if(nHigherHeight < narrLen[i]) {
                    nHigherHeight = narrLen[i];
                    nHeightIndex = i;
                }
            }
        }

        // 연속으로 붙어있지 않으면 ?
        boolean bWay = nWidthIndex < nHeightIndex;

        // 둘의 인덱스가 0과 5일 경우 방향 반대
        if(Math.abs(nWidthIndex - nHeightIndex) > 1)
            bWay = !bWay;

        if(bWay) {
            nWidthIndex-=2;
            nHeightIndex+=2;

            if(nWidthIndex < 0)
                nWidthIndex += 6;
            if(nHeightIndex >= 6)
                nHeightIndex -= 6;
        } else {
            nWidthIndex+=2;
            nHeightIndex-=2;

            if(nHeightIndex < 0)
                nHeightIndex += 6;
            if(nWidthIndex >= 6)
                nWidthIndex -= 6;
        }

        int nSmallArea = narrLen[nHeightIndex] * narrLen[nWidthIndex];

        int nFruitArea = nHigherWidth * nHigherHeight - nSmallArea;
        int nResult = nFruitArea * nFruit;

        bWriter.write(String.valueOf(nResult));
        bWriter.flush();
        bWriter.close();
    }
}