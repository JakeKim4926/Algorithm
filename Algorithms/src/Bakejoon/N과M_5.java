package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {

    static boolean[] barrVisited;
    static int[] narrNums;
    static int[] narrStack;
    static int N, M;
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        // N과 M 입력 받고
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        narrNums = new int[N]; // 입력받은 수 들의 배열
        narrStack = new int[M]; // 시스템 스택 배열
        barrVisited = new boolean[N];
        // 무슨다리만들기야 이거나 풀ㄷ어

        // 수 입력 받고 정렬해
        st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < N; i++) {
            narrNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(narrNums);

        NandM(0);

        bWriter.close();
    }

    private static void NandM(int nIndex) throws IOException {
        // 기저 조건
        // M-1번 만큼 재귀 스택이 쌓였을 때
        // 저장된 것들 출력하자
        if (nIndex == M) {
            for (int i = 0; i < M; i++)
                bWriter.write(narrStack[i] + " ");
            bWriter.write("\n");
            bWriter.flush();
            return;
        }

        // arrNums에 저장되어 있는 수들을 시스템 스택 배열에 쌓자
        // arrNums의 인덱스는 중복 가넝
        for (int i = 0; i < N; i++) {
            if (!barrVisited[i]) {
                barrVisited[i] = true;
                narrStack[nIndex] = narrNums[i];
                NandM(nIndex + 1);
                barrVisited[i] = false;
            }
        }

    }

}