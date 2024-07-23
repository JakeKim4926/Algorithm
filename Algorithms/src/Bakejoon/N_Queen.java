package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class N_Queen {
    static BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int nQueenCount = 0;
    static int[] columnsBoard = new int[15];

    public static void NQueen(int nRow) throws IOException {
        if (nRow == N) {
            nQueenCount++;
            return;
        }

        for (int nCol = 0; nCol < N; nCol++) {
            // Use the array as a columnBoard
            columnsBoard[nRow] = nCol;

            boolean bCheck = true;
            // Check if the next queen are in diagonal
            // if it's in diagonal it'll have same subs with each cols and rows
            for (int j = 0; j < nRow; j++) {
                if (columnsBoard[nRow] == columnsBoard[j]
                        || nRow - j == Math.abs(columnsBoard[nRow] - columnsBoard[j])) {
                    bCheck = false;
                    break;
                }
            }

            if(bCheck)
                NQueen(nRow+1);

        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken());

        NQueen(0);

        bWriter.write(nQueenCount + "\n");
        bWriter.flush();
        bWriter.close();

    }
}
