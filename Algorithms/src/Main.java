import Test.Sorting;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int next;
    int distance;

    Node(int next, int distance) {
        this.next = next;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] nodes = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++)
            nodes[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, distance));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = daijkstra(start, end, nodes);

        bw.write(String.valueOf(result));
        bw.close();
    }

    public static int daijkstra(int start, int end, ArrayList<Node>[] nodes) {
        int[] arrDaijk = new int[nodes.length];
        Arrays.fill(arrDaijk, Integer.MAX_VALUE);

        arrDaijk[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

//            if(node.next == end)
//                return arrDaijk[node.next];

            if(node.distance > arrDaijk[node.next])
                continue;

            for(int i = 0; i < nodes[node.next].size(); i++) {
                int next = nodes[node.next].get(i).next;
                int distance = nodes[node.next].get(i).distance;

                if(arrDaijk[next] > arrDaijk[node.next] + distance) {
                    arrDaijk[next] = arrDaijk[node.next] + distance;
                    pq.add(new Node(next, distance));
                }

            }

        }


        return arrDaijk[end];
    }
}