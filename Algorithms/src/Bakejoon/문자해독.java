package Bakejoon;
import java.io.*;
import java.util.*;


public class 문자해독 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] paintCount = new int[200];
        String paint = br.readLine();
        String ancient = br.readLine();

        int answer = 0;

        for(int i = 0; i < paint.length(); i++)
            paintCount[paint.charAt(i)]++;

        int[] temp = new int[200];
        int start = 0;
        int end = 0;
        for(int i = 0; i < ancient.length(); i++) {
            if(paintCount[ancient.charAt(i)] == 0) {
                start = i+1;
                end = i+1;
                temp = new int[200];
                continue;
            }

            if(end - start + 1 < W) {
                temp[ancient.charAt(i)]++;
            } else {
                boolean find = true;
                temp[ancient.charAt(i)]++;
                for(int j = start; j <= end; j++) {
                    if(temp[ancient.charAt(j)] != paintCount[ancient.charAt(j)]) {
                        find = false;
                        break;
                    }
                }
                if(find)
                    answer++;

                temp[ancient.charAt(start)]--;
                start++;
            }

            end++;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
