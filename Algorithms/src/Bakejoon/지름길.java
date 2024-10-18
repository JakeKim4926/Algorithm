package Bakejoon;

import java.io.*;
import java.util.StringTokenizer;

public class 지름길 {
    static class Shortcut {
        int start;
        int end;
        int distance;
        public Shortcut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Shortcut[] cuts = new Shortcut[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            cuts[i] = new Shortcut(start, end, distance);
        }

        int[] dp = new int[D+1];

        for(int i = 0; i < dp.length; i++)
            dp[i] = i;

        for(int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
            for(int j = 0; j < N; j++) {
                if(i == cuts[j].end) {
                    if(cuts[j].start + cuts[j].distance > D)
                        continue;

                    dp[i] = Math.min(dp[i], dp[cuts[j].start] + cuts[j].distance);
                }
            }
        }

        bw.write(String.valueOf(dp[D]));
        bw.close();
    }
}
