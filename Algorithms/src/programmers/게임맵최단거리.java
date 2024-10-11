package programmers;

import java.util.*;

public class 게임맵최단거리 {
    class Person {
        int row;
        int col;
        int steps;

        Person(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visit = new boolean[maps.length][maps[0].length];

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        Queue<Person> bfs = new LinkedList<>();
        bfs.add(new Person(0,0,1));

        while(!bfs.isEmpty()) {
            Person p = bfs.poll();

            if(p.row == maps.length - 1 && p.col == maps[0].length - 1) {
                return p.steps;
            }

            if(visit[p.row][p.col])
                continue;

            visit[p.row][p.col] = true;

            for(int i = 0; i < dr.length; i++) {
                int row = p.row + dr[i];
                int col = p.col + dc[i];

                if(row < 0 || col < 0 || row > maps.length - 1 || col > maps[0].length - 1)
                    continue;

                if(maps[row][col] == 0)
                    continue;

                bfs.add(new Person(row,col,p.steps+1));
            }
        }


        return -1;
    }
}
