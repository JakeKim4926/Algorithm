package programmers;

public class 네트워크 {
    boolean[][] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visit = new boolean[computers.length][computers[0].length];

        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j, computers);
                    answer++;
                }
            }
        }


        return answer;
    }

    public void dfs(int from, int to, int[][] computers) {

        visit[from][to] = true;
        visit[to][from] = true;

        for(int i = 0; i < visit[to].length; i++) {
            if(!visit[to][i] && computers[to][i] == 1) {
                dfs(to, i, computers);
            }
        }

    }
}
