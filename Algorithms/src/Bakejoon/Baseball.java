package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baseball {

    static int N, nMax, nHitter;
    static int[] narrTemp;
    static boolean[] barrNumVisit;
    static boolean[] barrBase;
    static ArrayList<int[]> arrHitterList;
    static int[][] narrInning;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bReader.readLine());

        narrInning = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < 9; j++) {
                narrInning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        narrTemp = new int[9];
        barrNumVisit = new boolean[9];
        barrBase = new boolean[3];
        arrHitterList = new ArrayList<>();

        SetHitter(0);
        nMax = 0;

        for(int i = 0; i < arrHitterList.size(); i++) {
            // 타자 배치 경우의수
            // 게임 셋
            int nScore = 0;
            nHitter = 0;

            for(int j = 0; j < N; j++) {
                int nOutCount = 0;
                // 각 이닝 별 가능한 타자들의 안타
                // 베이스 초기화
                barrBase = new boolean[3];
                while(nOutCount < 3){
                    int nHit = narrInning[j][arrHitterList.get(i)[nHitter]];
                    // 아웃 됬으면 ?
                    if(nHit == 0)
                        nOutCount++;
                    else {
                        // 노아웃 안타~홈런까지! 인생 역전!
                        nScore += Hit(nHit);
                    }
                    nHitter++;
                    // 0~8까지 인덱스 값만 존재 (1~9번 타자)
                    if(nHitter > 8)
                        nHitter = 0;
                }
            }

            if(nMax < nScore)
                nMax = nScore;
        }

        bWriter.write(String.valueOf(nMax));
        bWriter.close();

    }

    private static void SetHitter(int nIndex) {
        // 기저 조건
        // Index 0~8번까지 모든 타자 번호가 배치가 완료 되었다안
        if (nIndex == 9) {
            // 깊은 복사 하지 않으면 배열의 메모리가 공유됩니다.
            int[] narrBuffer = new int[9];

            for (int i = 0; i < 9; i++)
                narrBuffer[i] = narrTemp[i];

            arrHitterList.add(narrBuffer);
            return;
        }

        // 4번타자는 무조건 1번 선수이다. 인덱스로는 0
        if (nIndex == 3) {
            narrTemp[nIndex] = 0;
            SetHitter(nIndex + 1);
        }

        // 재귀 조건
        for (int i = 1; i < 9; i++) {
            if (!barrNumVisit[i]) {
                barrNumVisit[i] = true;
                narrTemp[nIndex] = i;
                SetHitter(nIndex + 1);
                barrNumVisit[i] = false;
            }
        }
    }


    private static int Hit(int nNum) {
        int nScore = 0;
        // 홈런쳤다.
        if (nNum == 4) {
            nScore++;
            for (int i = 0; i < 3; i++) {
                if (barrBase[i]) {
                    nScore++;
                    barrBase[i] = false;
                }
            }
        }
        // 안타 쳤다
        if (nNum == 1) {
            if (barrBase[2]) {
                nScore++;
                barrBase[2] = false;
            }

            for(int i = 1; i >=0 ;i--) {
                if(barrBase[i]) {
                    barrBase[i+1] = true;
                    barrBase[i] = false;
                }
            }

            barrBase[0] = true;
        }
        // 2루타 쳤다
        if (nNum == 2) {
            for (int i = 1; i < 3; i++) {
                if (barrBase[i]) {
                    barrBase[i] = false;
                    nScore++;
                }
            }
            if (barrBase[0]) {
                barrBase[2] = true;
                barrBase[0] = false;
            }
            barrBase[1] = true;
        }
        // 3루타 쳤다.
        if (nNum == 3) {
            for (int i = 0; i < 3; i++) {
                if (barrBase[i]) {
                    barrBase[i] = false;
                    nScore++;
                }
            }
            barrBase[2] = true;
        }

        return nScore;
    }

}