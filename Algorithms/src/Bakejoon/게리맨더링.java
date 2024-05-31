package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게리맨더링 {

    static int N, nMin, nPerm;
    static ArrayList<ArrayList<Integer>> listNode;

    static int[] narrPeople;
    static boolean[][] barrVisit;

    static int[] narrNums;
    static int[] narrAnothers;
    static boolean[] barrNums;
    static boolean[] barrDFS;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드 입력 받고
        N = Integer.parseInt(bReader.readLine());
        listNode = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listNode.add(new ArrayList<>());
        }

        narrPeople = new int[N];
        // 인구수 입력 받자
        StringTokenizer st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < N; i++)
            narrPeople[i] = Integer.parseInt(st.nextToken());

        // 구역 간의 관계를 (노드 관계) 입력 받자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            int nNodeCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nNodeCount; j++) {
                int nNextNode = Integer.parseInt(st.nextToken()) - 1;
                listNode.get(i).add(nNextNode);

            }
        }

        nMin = Integer.MAX_VALUE;
        // 일단 나눌 수 있는 경우의 수
        // 절반까지만 탐색하면 나머지 절반은 이미 나눠본적 있는 그룹이므로 탐색할 필요가 없다
        nPerm = 1;
        while (nPerm <= N / 2) {
            narrNums = new int[nPerm];
            barrNums = new boolean[N];
            narrAnothers = new int[N - nPerm];
            getCases(0);
            nPerm++;
        }

        if (nMin == Integer.MAX_VALUE)
            nMin = -1;

        bWriter.write(String.valueOf(nMin));
        bWriter.close();

    }

    private static void getCases(int nIndex) {

        // 기저 조건
        if (nIndex == nPerm) {
            // 두가지 케이스로 나눴을 경우
            // 각 케이스 안의 노드들 끼리 연결 되있는지 확인해보자
            // 조합에 뽑히지 않은 나머지
            int nAnotherIdx = 0;
            for (int i = 0; i < N; i++) {
                if (!barrNums[i])
                    narrAnothers[nAnotherIdx++] = i;
            }

            // 두 개로 나눈 노드의 그룹이 연결되어있다면
            // 사람 수 차이를 비교해보자
            if (IsConnected()) {
                int nSumFirst = 0;
                int nSumSecond = 0;

                for (int i = 0; i < nPerm; i++)
                    nSumFirst += narrPeople[narrNums[i]];
                for (int i = 0; i < N - nPerm; i++)
                    nSumSecond += narrPeople[narrAnothers[i]];

                int nResult = Math.abs(nSumFirst - nSumSecond);

                // 인구 차이가 최소인 것 받아놓자
                if (nMin > nResult) {
                    nMin = nResult;
                }
            }
            return;
        }

        // 재귀 조건
        // 일단 조합 뽑자
        for (int i = nIndex; i < N; i++) {
            if (!barrNums[i]) {
                barrNums[i] = true;
                narrNums[nIndex] = i;
                getCases(nIndex + 1);
                barrNums[i] = false;
            }
        }
    }

    // 두 시가지로 나눈 노드들이 연결되어 있는감
    private static boolean IsConnected() {
        boolean bResult = true;

        // 조합에서 꺼낸 경우의 수 부터
        // 연결 되어 있는지 봅시다
        barrDFS = new boolean[N];
        DFS(narrNums[0], narrNums);
        if (!bCheck(narrNums))
            return false;

        // 조합에 선택되지 않은 노드들이
        // 연결 되어 있는지 봅시다
        DFS(narrAnothers[0], narrAnothers);
        if (!bCheck(narrAnothers))
            return false;

        // 여기까지 왔으면 반으로 나눈게 연결되어 있따.
        return true;
    }

    // 조합에서 꺼낸 노드들을 탐색하자
    private static void DFS(int nNode, int[] narrTemp) {
        barrDFS[nNode] = true;

        for(int i = 0; i < narrTemp.length; i++) {
            if(listNode.get(nNode).contains(narrTemp[i]) && !barrDFS[narrTemp[i]])
                DFS(narrTemp[i], narrTemp);
        }

    }

    // 해당 배열들이 탐색이 되었는지 확인
    private static boolean bCheck(int[] narrTemp) {
        for(int i = 0; i < narrTemp.length; i++) {
            if(!barrDFS[narrTemp[i]])
                return false;
        }

        return true;
    }
}