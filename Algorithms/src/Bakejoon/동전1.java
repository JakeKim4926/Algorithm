package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 동전1 {

    public static void main(String[] args) throws IOException {

        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] narrDP = new int[K + 1];
        int[] narrCoin = new int[N];

        for (int i = 0; i < N; i++) {
            narrCoin[i] = Integer.parseInt(bReader.readLine());
        }
        // 0일 경우 0개의 동전을 뽑는 경우의 수 1
        narrDP[0] = 1;
        int nMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = narrCoin[i]; j <= K; j++) {
                narrDP[j] += narrDP[j - narrCoin[i]];
            }
        }

        bWriter.write(String.valueOf(narrDP[K]));

        bWriter.close();

    }
}