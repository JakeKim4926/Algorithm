package Bakejoon;

import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 회사문화1 {
    static int[] narrCompliments;
    static ArrayList<Integer>[] arrList;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrList = new ArrayList[N+1];
        narrCompliments = new int[N + 1];

        // 인접리스트 초기화
        for(int i = 0; i <= N; i++) {
            arrList[i] = new ArrayList<>();
        }


        // 직속 상사 입력 받아주고
        st = new StringTokenizer(bReader.readLine());
        for (int i = 1; i <= N; i++) {
            int nSenior = Integer.parseInt(st.nextToken());
            // DFS 관계 저장 ( 인접리스트 )
            if (nSenior != -1) {
                arrList[nSenior].add(i);
            }
        }

        // 칭찬 받은 직원 부터 DFS 탐색 진행 후 해당 칭찬 수 미리 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bReader.readLine());
            int nPerson = Integer.parseInt(st.nextToken());
            int nCompliment = Integer.parseInt(st.nextToken());

            // 미리 더해놓자.
            narrCompliments[nPerson] += nCompliment;
        }

        DFS(1);

        for (int i = 1; i <= N; i++)
            bWriter.write(narrCompliments[i] + " ");

        bWriter.flush();
        bWriter.close();
    }

    public static void DFS(int nIndex) {
        // 기저 조건
        for(int i = 0; i < arrList[nIndex].size(); i++) {
            int nChild = arrList[nIndex].get(i);
            // 누적합 고고하자
            narrCompliments[nChild] += narrCompliments[nIndex];
            // 다음 자식 노드 고고
            DFS(nChild);
        }
    }
}