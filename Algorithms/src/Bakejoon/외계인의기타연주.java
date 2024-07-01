package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 외계인의기타연주 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stPrats = new Stack[7];

        for(int i = 0; i < 7; i++) {
            stPrats[i] = new Stack<Integer>();
        }

        int nPratCount = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());

            int nLine = Integer.parseInt(st.nextToken());
            int nPrat = Integer.parseInt(st.nextToken());

            // 새로운 프랫이 더 높을 때 까지 지워버려
            while(!stPrats[nLine].empty() && nPrat < stPrats[nLine].peek()) {
                nPratCount++;
                stPrats[nLine].pop();
            }

            // 프랫이 같으면 걍 계속 누르고 있으면 돼
            // 아닐경우엔 스택에 넣어주고 새로 프랫 눌러
            if(stPrats[nLine].empty() || nPrat != stPrats[nLine].peek()) {
                stPrats[nLine].push(nPrat);
                nPratCount++;
            }

        }

        bWriter.write(String.valueOf(nPratCount));
        bWriter.flush();
        bWriter.close();
    }
}