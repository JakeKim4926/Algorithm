package programmers;

import java.util.*;
public class 경주로건설 {
    class Road {
        int row;
        int col;
        int cost;
        int direction;

        public Road() {}

        public Road(int row, int col, int cost, int direction) {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.direction = direction;
        }
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int[][] dp = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }

        boolean[][][] visit = new boolean[board.length][board[0].length][4];

        Queue<Road> bfs = new LinkedList<>();

        int dr[] = {0, 0, 1, -1};
        int dc[] = {1,-1, 0, 0};

        bfs.add(new Road(0,0,0,-1));

        while(!bfs.isEmpty()) {
            Road temp = bfs.poll();

            if(temp.row == board.length - 1 && temp.col == board[0].length - 1) {
                answer = Math.min(answer, dp[temp.row][temp.col]);
                continue;
            }

            for(int i = 0; i < dr.length; i++) {
                int searchRow = temp.row + dr[i];
                int searchCol = temp.col + dc[i];

                if(searchRow < 0 || searchCol < 0
                        || searchRow >= board.length || searchCol >= board[0].length)
                    continue;

                if(board[searchRow][searchCol] == 1)
                    continue;

                int cost = 100;

                if(((temp.direction == 0 || temp.direction == 1) && (i == 2 || i == 3))
                        || (temp.direction == 2 || temp.direction == 3) && (i == 0 || i == 1))
                    cost += 500;

                if(!visit[searchRow][searchCol][i]) {
                    visit[searchRow][searchCol][i] = true;

                    bfs.add(new Road(searchRow, searchCol, temp.cost + cost, i));
                }

                if(dp[searchRow][searchCol] >= temp.cost + cost) {
                    dp[searchRow][searchCol] = temp.cost + cost;
                    bfs.add(new Road(searchRow, searchCol, temp.cost + cost, i));
                }

            }
        }


        return answer;
    }
}
