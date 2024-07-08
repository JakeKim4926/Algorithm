package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class 민준이와마산그리고건우 {
    static class Node{
        int m_nNext;
        int m_nDistance;

        public Node(int m_nNext, int m_nDistance) {
            super();
            this.m_nNext = m_nNext;
            this.m_nDistance = m_nDistance;
        }
    }
    static int V,E,P;
    static ArrayList<Node>[] listNode;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        listNode = new ArrayList[V+1];
        for(int i = 0 ; i < V+1; i++) {
            listNode[i] = new ArrayList<>();
        }

        // 인접 리스트에 저장
        for(int i = 0 ; i < E; i++) {
            st = new StringTokenizer(bReader.readLine());
            int nStart = Integer.parseInt(st.nextToken());
            int nNext = Integer.parseInt(st.nextToken());
            int nWeight = Integer.parseInt(st.nextToken());
            listNode[nStart].add(new Node(nNext, nWeight));
            listNode[nNext].add(new Node(nStart, nWeight));
        }

        // 다잌잌
        int nMinjoon = dijkstra(1, V);
        int nGunwoo = dijkstra(1,P) + dijkstra(P,V);

        String strResult = "SAVE HIM";
        if(nMinjoon != nGunwoo)
            strResult = "GOOD BYE";

        bWriter.write(strResult);
        bWriter.close();
    }

    private static int dijkstra(int nStart, int nEnd) {
        int[] narrDaijk = new int[V+1];
        boolean[] barrDaijk = new boolean[V+1];
        for(int i = 0; i <= V; i++)
            narrDaijk[i] = Integer.MAX_VALUE;

        narrDaijk[nStart] = 0;

        for(int i = 1; i <= V; i++) {
            int nIndex = -1;
            int nMin = Integer.MAX_VALUE;

            for(int j = 1; j <= V; j++) {
                if(!barrDaijk[j] && nMin > narrDaijk[j]) {
                    nMin = narrDaijk[j];
                    nIndex = j;
                }
            }

            barrDaijk[nIndex] = true;

            if(barrDaijk[nEnd])
                return narrDaijk[nEnd];

            if(nIndex == -1)
                break;

            for(int j = 0; j < listNode[nIndex].size(); j++) {
                Node node = listNode[nIndex].get(j);
                if(barrDaijk[node.m_nNext])
                    continue;

                if(narrDaijk[node.m_nNext] > narrDaijk[nIndex] + node.m_nDistance)
                    narrDaijk[node.m_nNext] = narrDaijk[nIndex] + node.m_nDistance;
            }
        }

        return 0;
    }


}