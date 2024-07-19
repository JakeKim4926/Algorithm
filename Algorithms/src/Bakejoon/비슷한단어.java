package Bakejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 비슷한단어 {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int nWords = Integer.parseInt(bf.readLine());

        String strFirstWord = bf.readLine();

        int nSimilarCount = 0;
        for(int i = 0 ; i < nWords-1; i++) {
            String strWord = bf.readLine();
            int[] narrASCII = new int[26];

            // A=65~ Z=90까지
            for(int j = 0; j < strFirstWord.length(); j++) {
                narrASCII[(int)strFirstWord.charAt(j) - 65]++;
            }
            // 기준 문자열 길이 보다 2개이상 크거나 작으면 리턴.
            if(strWord.length() < strFirstWord.length()-1 || strWord.length() > strFirstWord.length()+1)
                continue;

            // 1. 같은 단어 있을 경우 카운트
            int nMatchCount = 0;
            // 몇 개인지 카운트
            for(int j = 0; j < strWord.length(); j++) {
                if(narrASCII[(int)strWord.charAt(j) - 65] > 0) {
                    nMatchCount++;
                    narrASCII[(int)strWord.charAt(j) - 65]--;
                }
            }

            // 단어가 같을 경우, 기본단어가 클 경우, 입력된 단어가 클 경우
            if(strWord.length() == strFirstWord.length()
                    && (nMatchCount == strFirstWord.length()-1 || nMatchCount == strFirstWord.length())) {
                nSimilarCount++;
            } else if(strWord.length() < strFirstWord.length()
                    && nMatchCount == strWord.length()) {
                nSimilarCount++;
            } else if(strWord.length() > strFirstWord.length()
                    && nMatchCount == strFirstWord.length()){
                nSimilarCount++;
            }

        }

        System.out.println(nSimilarCount);
    }
}
