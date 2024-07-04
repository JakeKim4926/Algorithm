package Bakejoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {
    static ArrayList<Integer>[] network;
    static boolean[]visit;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());

        result = 0;
        network = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i = 0; i < N+1; i++)
            network[i] = new ArrayList<>();
        for(int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            network[from].add(to);
            network[to].add(from);
        }

        DFS(1);

        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void DFS(int index) {
        if(visit[index])
            return;
        visit[index] = true;
        if(index !=1)
            result++;

        for(int i = 0; i < network[index].size();i++) {
            DFS(network[index].get(i));
        }
    }
}
