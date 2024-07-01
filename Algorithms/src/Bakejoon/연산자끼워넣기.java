package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

    static int N, nMax, nMin, nCalculate;
    static int[] narr;
    static int[] ncalArr;
    static int[] narrSearch;
    static boolean[] barrVisit;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bReader.readLine());

        narr = new int[N];
        barrVisit = new boolean[N - 1];
        ncalArr = new int[N - 1];
        narrSearch = new int[N - 1];

        // 수열 입력 받구
        StringTokenizer st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < N; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        // 각각의 연산자 갯수 입력 받자
        // + - * /
        // 1,2,3,4 로 연산자를 넘버링
        int nCalIndex = 0;

        st = new StringTokenizer(bReader.readLine());
        for (int i = 1; i <= 4; i++) {
            int nCal = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nCal; j++) {
                ncalArr[nCalIndex++] = i;
            }
        }

        nMax = Integer.MIN_VALUE;
        nMin = Integer.MAX_VALUE;
        Operator(0);

        bWriter.write(nMax + "\n" + nMin);
        bWriter.close();

    }

    private static void Operator(int nIndex) {
        // TODO Auto-generated method stub
        // 기저 조건
        // 연산 끝났따
        // 연산자는 N-1개 만큼 사용 가능
        if (nIndex == N - 1) {

            // 최초 계산 해주고
            int nCal = narr[0];
            // 지금까지 모여온 연산을 바탕으로 계산 고고
            for(int i = 0; i < N-1; i++) {
                nCal = getCal(nCal, narr[i+1], narrSearch[i]);
            }

            if (nMax < nCal)
                nMax = nCal;

            if (nMin > nCal)
                nMin = nCal;

            return;
        }

        // 재귀 조건
        // 연산자의 횟수가 중요하다
        for (int i = 0; i < N - 1; i++) {
            if (!barrVisit[i]) {
                narrSearch[nIndex] = ncalArr[i];
                barrVisit[i] = true;
                Operator(nIndex+1);
                barrVisit[i] = false;
            }
        }
    }

    private static int getCal(int nFstNum, int nSecNum, int nCalNum) {
        if(nCalNum == 1) // +
            return nFstNum+nSecNum;
        if(nCalNum == 2) // -
            return nFstNum-nSecNum;
        if(nCalNum == 3) // *
            return nFstNum*nSecNum;
        if(nCalNum == 4) {
            // 나누기
            // 분모가 음수일 때
            if(nSecNum == 0)
                return 0;
            if(nFstNum < 0 && nSecNum >= 0) {
                int nResult = (nFstNum * -1) / nSecNum;
                return nResult * -1;
            }

            return nFstNum / nSecNum;
        }

        return 0;
    }

}