package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 골드바흐의추측 {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        // 에라토스테네스의 체
        // 1. 2부터 N까지의 모든 자연수를 나열
        // 2. 남은 수 중에서 아직 처리하지 않은 가장 작은 수 i를 찾는다.
        // 3. 남은 수 중에서 i의 배수를 모두 제거 (i는 keep!)
        // 4. 더 이상 반복할 수 없을 때까지 2번과 3번 과정 반복

        boolean[] bIsPrime = new boolean[1000001];
        bIsPrime[1] = true;

        for(int i = 2; i <= 1000; i++) {
            if(bIsPrime[i])
                continue;

            for(int j = i*i; j <= 1000000; j+=i) {
                if(!bIsPrime[j])
                    bIsPrime[j] = true;
            }
        }

        // Goldbach 이론 증명
        while(N != 0) {

            boolean bGoldbach = false;

            int a = 3;
            int b = N - a;
            while(a <= b) {
                if(!bIsPrime[b] && !bIsPrime[a] &&
                        a+b == N) {
                    bGoldbach = true;
                    bw.write(N + " = " + a + " + " + b + "\n");
                    bw.flush();
                    break;
                }
                a+=2;
                b-=2;
            }

            if(!bGoldbach)
                System.out.println("Goldbach's conjecture is wrong.");

            N = Integer.parseInt(bf.readLine());
        }

        bw.close();
    }
}
