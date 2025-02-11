package Bakejoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = new String[5];
        int max = 0;
        for(int i = 0; i < 5; i++) {
            words[i] = bReader.readLine();
            max = Math.max(max, words[i].length());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < 5; j++) {
                int length = words[j].length();
                if(i >= length)
                    continue;
                sb.append(words[j].charAt(i));
            }
        }

        bWriter.write(sb.toString());
        bWriter.flush();
        bWriter.close();
    }
}