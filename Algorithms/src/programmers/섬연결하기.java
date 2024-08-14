package programmers;

import java.util.*;

public class 섬연결하기 {
    // 크루스칼
    int[] parent;
    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (int[] c1, int[] c2)  -> c1[2]-c2[2]);

        parent = new int[n];

        for(int i =0; i < n; i++)
            parent[i] = i;

        int total = 0;
        for(int i =0 ; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int distance = costs[i][2];

            int from = findParent(start);
            int to = findParent(end);

            if(from == to)
                continue;

            total += distance;
            parent[to] = from;
        }

        return total;
    }

    private int findParent(int node) {
        if(parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
    }
}
