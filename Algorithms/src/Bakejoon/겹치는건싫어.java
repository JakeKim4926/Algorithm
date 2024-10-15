package Bakejoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int max = 0;
        int num = 0;
        for(int i = 0; i < N; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < N; j++) {
                if(map.getOrDefault(arr[j], 0) >= K) {
                    int length = j - i;
                    max = Math.max(max, length);
                    num = arr[j];
                    break;
                }
                if(j == N-1) {
                    int length = N - i;
                    max = Math.max(max, length);
                    bw.write(String.valueOf(max));
                    bw.close();
                    return;
                }
                map.put(arr[j], map.getOrDefault(arr[j],0) + 1);
            }
            for(int j = i; j < N; j++) {
                if(arr[j] == num) {
                    i = j;
                    break;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
    }
}
