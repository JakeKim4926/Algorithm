package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 부등호 {

    static int K;
    static boolean[] barrCheck, barrIsBigger;
    static char[] chMax, chMin;
    static int[] narrCheck;
    static long lnMin, lnMax;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(bReader.readLine());

        // 부등호를 저장하기 위한 배열
        barrIsBigger = new boolean[K];

        // 재귀를 위한 배열
        narrCheck = new int[K+1];
        barrCheck = new boolean[10];

        // 치킨집과 그냥 집의 위치들을 저장해놓자.
        StringTokenizer st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < K; i++) {
            char ch = st.nextToken().charAt(0);
            // > 면 true <면 false로 부등호 비교 방법을 저장
            if( ch == '>')
                barrIsBigger[i] = true;
        }

        // 앞에 0도 출력해야 하니 char배열로 맥스값을 만들자
        chMax = new char[K+1];
        chMin = new char[K+1];
        // 부등호와 일치하는 값들을 비교하기 위한
        // long 자료형 변수 들도 만들자
        lnMax = 0;
        lnMin = Long.MAX_VALUE;

        // 부등호 비교
        inequality(0);

        // 출력
        for(int i =0 ; i < K+1; i++)
            bWriter.write(chMax[i]);
        bWriter.write("\n");
        for(int i =0 ; i < K+1; i++)
            bWriter.write(chMin[i]);

        bWriter.close();
    }

    private static void inequality(int nIndex) {
        // 기저 조건
        // 여기에 도착했을 때
        // 부등호의 관계가 전부 일치하였다.
        if(nIndex == K+1) {
            // 여기서 수를 비교
            long lnTemp = 0;
            for(int i = 0 ; i < K+1; i++) {
                lnTemp *= 10;
                lnTemp += narrCheck[i];
            }

            // 최대값 저장
            if(lnMax < lnTemp) {
                lnMax = lnTemp;
                for(int i = 0; i < K+1;i++)
                    chMax[i] = (char)(narrCheck[i] + '0');
            }
            // 최소값 저장
            if(lnMin > lnTemp) {
                lnMin = lnTemp;
                for(int i = 0; i < K+1;i++)
                    chMin[i] = (char)(narrCheck[i] + '0');
            }
            return;
        }

        // 재귀 조건은 ?
        // 문제에서 주어진 부등호 기호에 알맞은 수가 들어갔을 때
        for(int i = 0; i <= 9; i++) {
            if(!barrCheck[i]) {
                // 부등호 관계가 성립하는지 봅시다
                if(nIndex > 0) {
                    // >인데  <다 더이상 넣어밨자 i가 계속 더 크다
                    // 그니까 리턴시키자
                    if(barrIsBigger[nIndex-1] && narrCheck[nIndex-1] < i)
                        return;
                    // <인데 >다
                    if(!barrIsBigger[nIndex-1] && narrCheck[nIndex-1] > i)
                        continue;
                }

                // 위의 조건을 피하구 내려왔다 ?
                // 부등호의 조건과 맞다 == 조합 형태로 재귀 돌리기 가능
                barrCheck[i] = true;
                narrCheck[nIndex] = i;
                inequality(nIndex+1);
                barrCheck[i] = false;
            }
        }
    }
}