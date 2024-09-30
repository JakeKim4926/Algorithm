package programmers;

import java.util.ArrayList;

public class 전력망을둘로나누기 {
    ArrayList<Integer>[] tree;
    boolean[][] visit;
    int count;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        tree = new ArrayList[n+ 1];
        for(int i = 0; i < n+1; i++)
            tree[i] = new ArrayList<>();

        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            tree[from].add(to);
            tree[to].add(from);
        }

        for(int i = 0; i < wires.length; i++) {
            visit = new boolean[n+1][n+1];
            int from = wires[i][0];
            int to = wires[i][1];

            visit[from][to] = true;
            visit[to][from] = true;

            count = 1;
            for(int j = 0; j < tree[to].size(); j++)
                dfs(to, tree[to].get(j));

            int other = n - count;
            int diff = Math.abs(other-count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public void dfs(int from, int to) {
        if(visit[from][to] || visit[to][from])
            return;

        visit[from][to] = true;
        visit[to][from] = true;

        count++;
        for(int i = 0; i < tree[to].size();i++)
            dfs(to, tree[to].get(i));

        return;
    }

}
