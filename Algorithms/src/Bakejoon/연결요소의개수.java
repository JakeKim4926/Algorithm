package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] barrVisited;
    static ArrayList<Integer>[] arrList;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        barrVisited = new boolean[N + 1];
        arrList = new ArrayList[N + 1]; // 인접 리스트

        for (int i = 1; i <= N; i++)
            arrList[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bReader.readLine());
            int nParent = Integer.parseInt(st.nextToken());
            int nChild = Integer.parseInt(st.nextToken());

            // 양방향 연결
            arrList[nParent].add(nChild);
            arrList[nChild].add(nParent);
        }

        int nCount = 0;

        // 연결되있는 갯수 만큼 DFS 탐색을 하게 된다.
        // DFS의 탐색 횟수 == 연결 요소의 개수
        for (int i = 1; i <= N; i++) {
            if (!barrVisited[i]) {
                nCount++;
                DFS(i);
            }
        }

        bWriter.write(String.valueOf(nCount));
        bWriter.flush();
        bWriter.close();
    }
    public static void DFS(int nNode) throws IOException {

        if (barrVisited[nNode]) {
            return;
        }

        // 인접리스트에 해당하는 곳을 방문안했으면 탐색하자
        barrVisited[nNode] = true;
        for (int i = 0; i < arrList[nNode].size(); i++) {
            if (!barrVisited[arrList[nNode].get(i)]) {
                DFS(arrList[nNode].get(i));
            }
        }
    }
}