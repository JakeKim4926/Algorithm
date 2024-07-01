package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class 탑 {

    static class Tower {
        int m_nHeight = 0;
        int m_nNumber = 0;

        public Tower() {}

        public Tower(int m_nHeight, int m_nNumber) {
            this.m_nHeight = m_nHeight;
            this.m_nNumber = m_nNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
//        System.setIn(new FileInputStream(Main.class.getResource("input.txt").getPath()));

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bReader.readLine());

        StringTokenizer st = new StringTokenizer(bReader.readLine());


        Stack<Tower> stTowers = new Stack<>();
        // 어차피 처음엔 쌓인다.
        stTowers.push(new Tower(Integer.parseInt(st.nextToken()), 1));
        bWriter.write("0 ");

        for (int i = 1; i < N; i++) {
            int nTower = Integer.parseInt(st.nextToken());
            // 스택 맨 윗부분의 수보다 크거나 비어있으면
            while(!stTowers.isEmpty() && stTowers.peek().m_nHeight < nTower) {
                stTowers.pop();
            }

            // 비어있다는건? 현재 타워 높이가 가장 높다는 것
            if(stTowers.isEmpty()) {
                bWriter.write("0 ");
            } else {
                // 안비어있다는건 ?
                // 현재 타워보다 높은게 있다는 거
                bWriter.write(stTowers.peek().m_nNumber + " ");
            }
            stTowers.push(new Tower(nTower, i+1));
        }


        bWriter.flush();
        bWriter.close();
    }
}