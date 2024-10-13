package programmers;

import java.util.*;

public class 아이템줍기 {
    class Person {
        int row;
        int col;
        int distance;
        int lastDirection;
        Person(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] visit = new boolean[110][110];
        int[][] map = new int[110][110];

        for(int i = 0; i < rectangle.length; i++) {
            int leftCol = rectangle[i][0];
            int leftRow = rectangle[i][1];
            int rightCol = rectangle[i][2];
            int rightRow = rectangle[i][3];

            for(int r = leftRow * 2; r <= rightRow * 2; r++) {
                for(int c = leftCol * 2; c <= rightCol * 2; c++) {
                    if(map[r][c] == 1)
                        continue;

                    map[r][c] = 1;

                    if(r == leftRow * 2 || r == rightRow * 2
                            || c == leftCol * 2|| c == rightCol * 2)
                        map[r][c] = 2;
                }
            }
        }

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};


        Queue<Person> bfs = new LinkedList<>();
        bfs.add(new Person(characterY * 2, characterX * 2, 0));

        while(!bfs.isEmpty()) {
            Person p = bfs.poll();

            if(p.row == itemY * 2 && p.col == itemX * 2) {
                return p.distance / 2;
            }

            if(visit[p.row][p.col])
                continue;

            visit[p.row][p.col] = true;
            for(int i = 0; i < 4; i++) {
                int row = p.row + dr[i];
                int col = p.col + dc[i];

                if(visit[row][col] || map[row][col] != 2)
                    continue;

                bfs.add(new Person(row, col, p.distance+1));

            }
        }

        return answer;
    }
}
