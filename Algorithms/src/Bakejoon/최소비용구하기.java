package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

//class Node implements Comparable<Node> {
//    int next;
//    int distance;
//
//    Node(int next, int distance) {
//        this.next = next;
//        this.distance = distance;
//    }
//
//    @Override
//    public int compareTo(Node o) {
//        return this.distance - o.distance;
//    }
//
//}
//
//public class 최소비용구하기 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//
//        ArrayList<Node>[] nodes = new ArrayList[N+1];
//        for(int i = 0; i < N+1; i++)
//            nodes[i] = new ArrayList<>();
//
//        for(int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int distance = Integer.parseInt(st.nextToken());
//
//            nodes[from].add(new Node(to, distance));
//        }
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int start = Integer.parseInt(st.nextToken());
//        int end = Integer.parseInt(st.nextToken());
//
//        int result = daijkstra(start, end, nodes);
//
//        bw.write(String.valueOf(result));
//        bw.close();
//    }
//
//    public static int daijkstra(int start, int end, ArrayList<Node>[] nodes) {
//        int[] arrDaijk = new int[nodes.length];
//        Arrays.fill(arrDaijk, Integer.MAX_VALUE);
//
//        arrDaijk[start] = 0;
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        pq.add(new Node(start,0));
//
//        while(!pq.isEmpty()) {
//            Node node = pq.poll();
//
////            if(node.next == end)
////                return arrDaijk[node.next];
//
//            if(node.distance > arrDaijk[node.next])
//                continue;
//
//            for(int i = 0; i < nodes[node.next].size(); i++) {
//                int next = nodes[node.next].get(i).next;
//                int distance = nodes[node.next].get(i).distance;
//
//                if(arrDaijk[next] > arrDaijk[node.next] + distance) {
//                    arrDaijk[next] = arrDaijk[node.next] + distance;
//                    pq.add(new Node(next, distance));
//                }
//
//            }
//
//        }
//
//
//        return arrDaijk[end];
//    }
//}

//
//public class 최소비용구하기 {
//    static class Node {
//        int m_nEnd;
//        int m_nDistance;
//
//        public Node() {
//            // TODO Auto-generated constructor stub
//        }
//
//        public Node(int m_nEnd, int m_nDistance) {
//            super();
//            this.m_nEnd = m_nEnd;
//            this.m_nDistance = m_nDistance;
//        }
//    }
//    static int N, M;
//    static ArrayList<Node>[] listNodes;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        // 노드 입력 받고
//
//        N = Integer.parseInt(bReader.readLine());
//        M = Integer.parseInt(bReader.readLine());
//
//        listNodes = new ArrayList[N + 1];
//        for (int i = 0; i < N + 1; i++) {
//            listNodes[i] = new ArrayList<>();
//        }
//
//        // 인접 리스트로 시작, 끝 노드 + 가중치 저장
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(bReader.readLine());
//            int nStart = Integer.parseInt(st.nextToken());
//            int nEnd = Integer.parseInt(st.nextToken());
//            int nDistance = Integer.parseInt(st.nextToken());
//
//            listNodes[nStart].add(new Node(nEnd, nDistance));
//        }
//
//        StringTokenizer st = new StringTokenizer(bReader.readLine());
//        int nFirst = Integer.parseInt(st.nextToken());
//        int nEnd = Integer.parseInt(st.nextToken());
//
//        bWriter.write(String.valueOf(Daijkstra(nFirst, nEnd)));
//        bWriter.close();
//    }
//
//    private static int Daijkstra(int nFirst, int nEnd) {
//        // TODO Auto-generated method stub
//        int[] narrDaijk = new int[N + 1];
//        boolean[] barrDaijk = new boolean[N + 1];
//
//        Arrays.fill(narrDaijk, Integer.MAX_VALUE);
//        narrDaijk[nFirst] = 0;
//
//        for (int i = 1; i <= N; i++) {
//            int nMin = Integer.MAX_VALUE;
//            int nIndex = -1;
//
//            for(int j = 1; j <= N; j++) {
//                if(nMin > narrDaijk[j] && !barrDaijk[j]) {
//                    nMin = narrDaijk[j];
//                    nIndex = j;
//                }
//            }
//
//            if(nIndex == -1)
//                break;
//
//            barrDaijk[nIndex] = true;
//
//            for(int j = 0; j < listNodes[nIndex].size(); j++) {
//                int nNextNode = listNodes[nIndex].get(j).m_nEnd;
//                int nDistance = listNodes[nIndex].get(j).m_nDistance;
//
//                if(!barrDaijk[nNextNode] && narrDaijk[nNextNode] > narrDaijk[nIndex] + nDistance)
//                    narrDaijk[nNextNode] = narrDaijk[nIndex] + nDistance;
//            }
//
//            if(nIndex == nEnd)
//                return narrDaijk[nEnd];
//        }
//
//        return -1;
//    }
//}