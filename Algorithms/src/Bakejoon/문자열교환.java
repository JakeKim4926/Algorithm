package Bakejoon;

import java.io.*;

public class 문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().toLowerCase();

        int countA = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                countA++;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < input.length(); i++) {
            int countB = 0;
            for(int j = i; j < i+countA; j++) {
                int right = j;
                if(right > input.length()-1)
                    right -= input.length();
                if(input.charAt(right) == 'b') {
                    countB++;
                }
            }
            min = Math.min(min, countB);
        }

        bw.write(min + "\n");
        bw.close();
    }
}
