package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 아카라카 {
    public static boolean Palindrome(String strTemp) {

        // 재귀의 끝
        if (strTemp.length() == 1)
            return true;
        if (strTemp.length() <= 0)
            return false;

        int nLeftPoint = 0;
        int nRightPoint = 0;
        if (strTemp.length() % 2 == 0) {
            // ex) ABBA
            nLeftPoint = (strTemp.length() / 2) - 1;
            nRightPoint = (strTemp.length() / 2);
        } else if (strTemp.length() % 2 == 1) {
            // ex) ABCBA
            nLeftPoint = (strTemp.length() / 2) - 1;
            nRightPoint = (strTemp.length() / 2) + 1;
        }

        // 회문 탐색
        while (nLeftPoint >= 0 && nRightPoint < strTemp.length()) {
            if (strTemp.charAt(nLeftPoint) != strTemp.charAt(nRightPoint)) {
                return false;
            }
            nLeftPoint--;
            nRightPoint++;
        }

        return Palindrome(strTemp.substring(0, (strTemp.length() / 2)));
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String strAkaraka = bReader.readLine();

        if(Palindrome(strAkaraka))
            bWriter.write("AKARAKA");
        else
            bWriter.write("IPSELENTI");

        bWriter.flush();
        bWriter.close();

    }
}
