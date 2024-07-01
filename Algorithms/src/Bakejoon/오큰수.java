package Bakejoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class 오큰수 {

    static class NGE{
        int m_nNumber = 0;
        int m_nValue = 0;

        public NGE(int m_nNumber, int m_nValue) {
            this.m_nNumber = m_nNumber;
            this.m_nValue = m_nValue;
        }
    }


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bReader.readLine());
        Stack<NGE> stNGE = new Stack<>();
        int[] narrResult = new int[N];

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        for(int i = 0; i < N; i++) {
            int nNumber = Integer.parseInt(st.nextToken());
            // 스택 맨 마지막 값보다 큰값이 들어 왔다??
            // 오큰수니까 다 저장해버려
            while(!stNGE.isEmpty() && stNGE.peek().m_nValue < nNumber) {
                narrResult[stNGE.pop().m_nNumber] = nNumber;
            }

            // 인덱스와 값을 저장해
            stNGE.add(new NGE(i, nNumber));
        }

        // 오큰수가 없는 것만 남아있다아
        while(!stNGE.isEmpty()) {
            narrResult[stNGE.pop().m_nNumber] = -1;
        }

        // 출력해
        for(int i = 0; i < N; i++)
            bWriter.write(narrResult[i] + " ");

        bWriter.flush();
        bWriter.close();
    }
    
}