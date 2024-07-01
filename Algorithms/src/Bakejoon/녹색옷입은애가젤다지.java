package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int m_nEnd;
    int m_nBlack;

    public Node(int m_nEnd, int m_nBlack) {
        this.m_nEnd = m_nEnd;
        this.m_nBlack = m_nBlack;
    }

    @Override
    public String toString() {
        return "Node [m_nEnd=" + m_nEnd + ", m_nBlack=" + m_nBlack + "]";
    }

}

public class 녹색옷입은애가젤다지 {
    static boolean[] barrVisited;
    static List<Node>[] listWay;
    static int[] narrBlack;
    static int N, M, nBetrayer, nMax, nOneCycle;
    static int[][] narrCave;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = 1;
        int nCount = 1;
        while (N != 0) {
            N = Integer.parseInt(bReader.readLine());
            if (N == 0)
                break;
            narrCave = new int[N][N];
            barrVisited = new boolean[N * N];
            narrBlack = new int[N * N];

            listWay = new LinkedList[N*N];

            for(int i = 0; i < N*N; i++)
                listWay[i] = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bReader.readLine());
                for (int j = 0; j < N; j++)
                    narrCave[i][j] = Integer.parseInt(st.nextToken());
            }

            // 상, 하, 좌, 우 노드 관계 설정
            int nIndex = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j + 1 < N)
                        listWay[nIndex].add(new Node(nIndex + 1, narrCave[i][j + 1]));	// 동
                    if (j - 1 >= 0)
                        listWay[nIndex].add(new Node(nIndex - 1, narrCave[i][j - 1]));	// 서
                    if (i + 1 < N)
                        listWay[nIndex].add(new Node(nIndex + N, narrCave[i + 1][j]));	// 남
                    if (i - 1 >= 0)
                        listWay[nIndex].add(new Node(nIndex - N, narrCave[i - 1][j]));	// 북

                    nIndex++;
                }
            }

            daijkstra(0);
            bWriter.write("Problem " + nCount + ": " + narrBlack[N*N-1] + "\n");
            nCount++;
            bWriter.flush();
        }

        bWriter.close();
    }

    public static void daijkstra(int nStart) {
        Arrays.fill(narrBlack, Integer.MAX_VALUE);
        narrBlack[0] = narrCave[0][0];

        for(int i =0; i < N*N; i++) {
            int nMin = Integer.MAX_VALUE;
            int nIndex = -1;

            // 최소 가중치를 갖는 노드 찾구
            for(int j = 0; j < N*N; j++) {
                if(!barrVisited[j] && nMin >= narrBlack[j]) {
                    nMin = narrBlack[j];
                    nIndex = j;
                }
            }

            if(nIndex == -1)
                break;

            barrVisited[nIndex] = true;
            for(int j = 0; j < listWay[nIndex].size(); j++) {
                Node curr = listWay[nIndex].get(j);

                if(barrVisited[curr.m_nEnd])
                    continue;

                if(narrBlack[curr.m_nEnd] > narrBlack[nIndex] + curr.m_nBlack) {
                    narrBlack[curr.m_nEnd] = narrBlack[nIndex] + curr.m_nBlack;
                }
            }
        }

    }
}