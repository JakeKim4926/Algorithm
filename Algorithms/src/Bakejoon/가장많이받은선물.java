package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장많이받은선물 {
    public static int[] narr = new int[10];
    public static boolean[] barrSearch = new boolean[10];
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int M;

    public static void NandM(int nNum) throws IOException {
        if(nNum == M) {
            for(int i = 0; i < M; i++) {
                bWriter.write(narr[i] + " ");
            }
            bWriter.write("\n");
            return;
        }

        for(int i = 1; i <= N ; i++) {
            if(!barrSearch[i]) {
                narr[nNum] = i;
                barrSearch[i] = true;
                NandM(nNum+1);
                barrSearch[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        NandM(0);

        bWriter.flush();
        bWriter.close();

    }
}