package Bakejoon;

import java.io.*;

public class 하노이탑이동순서 {
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int nMove = 0;

    public static void Hanoi(int nSize, int nFrom, int nTo, int nEnd) throws IOException {
        // 이동 보여주기
        if(nSize == 1) {
            nMove++;
            bWriter.write(nFrom + " " + nEnd + "\n");
            return;
        }

        // 제일 큰 숫자가 스타트 위치에 하나가 남을 때 까지 무브
        Hanoi(nSize-1, nFrom, nEnd, nTo);

        // 제일 큰 숫자를 From->End로 이동
        Hanoi(1, nFrom, nTo, nEnd);

        // 제일 큰 숫자를 제외한 나머지 탑들을 end위치로 이동
        Hanoi(nSize-1, nTo, nFrom, nEnd);
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        int nHanoiSize = Integer.parseInt(bReader.readLine());

        // 최소 이동 개수 : 2^n -1
        int nMovebyFormula = (int)Math.pow(2, nHanoiSize) - 1;
        bWriter.write(nMovebyFormula + "\n");
        Hanoi(nHanoiSize, 1, 2, 3);
        //bWriter.write("내가 한 거 : " + nMove + "\n");

        bWriter.flush();
        bWriter.close();

    }

}
