package Bakejoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(bReader.readLine());
        
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken()) - 45;
        
        if(minute < 0) {
            hour -= 1;
            minute += 60;            
        }
        
        if(hour < 0)
            hour = 23;
       
        String result = String.valueOf(hour) + " " +  String.valueOf(minute);
        
        bWriter.write(result);
        bWriter.close();
    }
}
