package Bakejoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {
    static class Distance {
        int row;
        int col;
        int distance;
        public Distance(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] result = new int[n][m];
        int startRow = 0;
        int startCol = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        Queue<Distance> bfs = new LinkedList<>();
        bfs.add(new Distance(startRow, startCol, 0));

        while(!bfs.isEmpty()) {
            Distance d = bfs.poll();

            if(result[d.row][d.col] > 0)
                continue;

            result[d.row][d.col] = d.distance;
            for(int i = 0; i < dr.length; i++) {
                int row = d.row + dr[i];
                int col = d.col + dc[i];

                if(row < 0 || row >= n || col < 0 || col >= m)
                    continue;

                if(map[row][col] != 1 || result[row][col] > 0)
                    continue;

                bfs.add(new Distance(row, col, d.distance + 1));
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && result[i][j] == 0)
                    result[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }
}
