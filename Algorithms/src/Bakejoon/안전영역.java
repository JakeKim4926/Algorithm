package Bakejoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 안전영역 {
    static class Point {
        int row;
        int col;

        public Point() {
        }

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] area = new int[N][N];
        int rainMax = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                rainMax = Math.max(rainMax, area[i][j]);
            }
        }

        int result = 0;
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1,0,0};
        for(int k = 1; k <= rainMax; k++) {
            int count = 0;
            boolean[][] visit = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(area[i][j] < k || visit[i][j])
                        continue;
                    count++;
                    Queue<Point> bfs = new LinkedList<>();
                    bfs.add(new Point(i, j));

                    while (!bfs.isEmpty()) {
                        Point temp = bfs.poll();
                        if(visit[temp.row][temp.col])
                            continue;

                        visit[temp.row][temp.col] = true;
                        for(int l =0 ; l < dr.length; l++) {
                            int searchRow = temp.row + dr[l];
                            int searchCol = temp.col + dc[l];

                            if(searchRow < 0 || searchCol < 0 ||
                                    searchRow >= N || searchCol >= N)
                                continue;

                            if(visit[searchRow][searchCol]
                                    || area[searchRow][searchCol] < k)
                                continue;

                            bfs.add(new Point(searchRow, searchCol));
                        }
                    }
                }
            }

            result = Math.max(result, count);
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}
