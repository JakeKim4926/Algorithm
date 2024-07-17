package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 갯수만큼 값을 입력받자
        int N = Integer.parseInt(bReader.readLine());
        int[] narrSolution = new int[N];
        StringTokenizer st = new StringTokenizer(bReader.readLine());
        for(int i = 0 ; i < N; i++) {
            narrSolution[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 함 해주고
        Arrays.sort(narrSolution);

        int nMin = Integer.MAX_VALUE;
        int nSum = 0;
        int nLeft = 0;
        int nRight = N-1;
        // 결과 값을 저장하자
        int nAcid = 0;
        int nAlkalic = 0;
        while(nLeft < nRight ) {
            // 두개의 합을 더한 값과 최소값을 비교하여
            // 최소값일 경우, 두 값을 저장한다.
            nSum = narrSolution[nLeft] + narrSolution[nRight];
            if(nMin > Math.abs(nSum)) {
                nMin = Math.abs(nSum);
                nAcid = narrSolution[nLeft];
                nAlkalic = narrSolution[nRight];
            }

            if(nSum == 0)
                break;

            // 오른쪽이랑 왼쪽으로 옮겼을 때 중
            // 최소값인 곳으로 옮겨주자
            if(Math.abs(narrSolution[nLeft+1] + narrSolution[nRight]) > Math.abs(narrSolution[nLeft] + narrSolution[nRight-1]))
                nRight--;
            else
                nLeft++;
        }

        bWriter.write(nAcid + " " + nAlkalic);
        bWriter.close();
    }

}