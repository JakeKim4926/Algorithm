package programmers;

import java.util.*;

public class 가장먼노드 {
    class Node {
        int next;
        int level;

        Node(int next, int level) {
            this.next = next;
            this.level = level;
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;

        ArrayList<Integer>[] listNodes = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++)
            listNodes[i] = new ArrayList<>();

        for(int i = 0; i < edge.length; i++) {
            listNodes[edge[i][0]].add(edge[i][1]);
            listNodes[edge[i][1]].add(edge[i][0]);
        }

        Queue<Node> bfs = new LinkedList<>();

        boolean[] visit = new boolean[n+1];

        bfs.add(new Node(1, 0));

        while(!bfs.isEmpty()) {
            Node temp = bfs.poll();

            if(visit[temp.next])
                continue;

            if(max < temp.level) {
                max = temp.level;
                answer = 1;
            } else if(max == temp.level) {
                answer++;
            }

            visit[temp.next] = true;

            for(int i = 0; i < listNodes[temp.next].size(); i++) {
                int next = listNodes[temp.next].get(i);
                if(visit[next])
                    continue;

                bfs.add(new Node(next, temp.level+1));
            }

        }


        return answer;
    }
}
