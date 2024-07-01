package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 최소비용구하기 {
    static class Node {
        int m_nEnd;
        int m_nDistance;

        public Node() {
            // TODO Auto-generated constructor stub
        }

        public Node(int m_nEnd, int m_nDistance) {
            super();
            this.m_nEnd = m_nEnd;
            this.m_nDistance = m_nDistance;
        }
    }
    static int N, M;
    static ArrayList<Node>[] listNodes;

    public static void main(String[] args) throws IOException {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드 입력 받고

        N = Integer.parseInt(bReader.readLine());
        M = Integer.parseInt(bReader.readLine());

        listNodes = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            listNodes[i] = new ArrayList<>();
        }

        // 인접 리스트로 시작, 끝 노드 + 가중치 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            int nStart = Integer.parseInt(st.nextToken());
            int nEnd = Integer.parseInt(st.nextToken());
            int nDistance = Integer.parseInt(st.nextToken());

            listNodes[nStart].add(new Node(nEnd, nDistance));
        }

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        int nFirst = Integer.parseInt(st.nextToken());
        int nEnd = Integer.parseInt(st.nextToken());

        bWriter.write(String.valueOf(Daijkstra(nFirst, nEnd)));
        bWriter.close();
    }

    private static int Daijkstra(int nFirst, int nEnd) {
        // TODO Auto-generated method stub
        int[] narrDaijk = new int[N + 1];
        boolean[] barrDaijk = new boolean[N + 1];

        Arrays.fill(narrDaijk, Integer.MAX_VALUE);
        narrDaijk[nFirst] = 0;

        for (int i = 1; i <= N; i++) {
            int nMin = Integer.MAX_VALUE;
            int nIndex = -1;

            for(int j = 1; j <= N; j++) {
                if(nMin > narrDaijk[j] && !barrDaijk[j]) {
                    nMin = narrDaijk[j];
                    nIndex = j;
                }
            }

            if(nIndex == -1)
                break;

            barrDaijk[nIndex] = true;

            for(int j = 0; j < listNodes[nIndex].size(); j++) {
                int nNextNode = listNodes[nIndex].get(j).m_nEnd;
                int nDistance = listNodes[nIndex].get(j).m_nDistance;

                if(!barrDaijk[nNextNode] && narrDaijk[nNextNode] > narrDaijk[nIndex] + nDistance)
                    narrDaijk[nNextNode] = narrDaijk[nIndex] + nDistance;
            }

            if(nIndex == nEnd)
                return narrDaijk[nEnd];
        }

        return -1;
    }
}