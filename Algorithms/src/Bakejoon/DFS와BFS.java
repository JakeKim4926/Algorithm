package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] barrVisited = new boolean[1001];
    static int[][] narrTree = new int[1001][1001];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int nNodeNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bReader.readLine());
            int nParent = Integer.parseInt(st.nextToken());
            int nChild = Integer.parseInt(st.nextToken());

            narrTree[nParent][nChild] = nChild;
            narrTree[nChild][nParent] = nParent;
        }

        DFS(nNodeNum);
        barrVisited = new boolean[1001];
        bWriter.write("\n");
        BFS(nNodeNum);

        bWriter.flush();
        bWriter.close();
    }

    public static void DFS(int nNode) throws IOException {

        if (nNode == 0 || nNode > N || barrVisited[nNode])
            return;

        barrVisited[nNode] = true;
        bWriter.write(nNode + " ");
        // VLR 선위 순회
        for (int j = 1; j <= N; j++) {
            if (!barrVisited[narrTree[nNode][j]]) {
                DFS(narrTree[nNode][j]);
            }
        }
    }

    public static void BFS(int nNode) throws IOException {
        Queue<Integer> queueBfs = new LinkedList<>();
        queueBfs.add(nNode);

        while (!queueBfs.isEmpty()) {
            int nParent = queueBfs.poll();
            if (!barrVisited[nParent]) {
                bWriter.write(nParent + " ");
                barrVisited[nParent] = true;
                for (int j = 1; j <= N; j++) {
                    if (narrTree[nParent][j] > 0 && !barrVisited[j]) {
                        queueBfs.add(j);
                    }
                }
            }
        }
    }
}