package Bakejoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 주사위굴리기 {

    static int N, M, nDicePoint;
    static int[][] narrMap, narrDice;
    static int[] nDice;

    // 동, 서, 북, 남
    static int dr[] = { 0, 0, -1, 1 };
    static int dc[] = { 1, -1, 0, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int nRow = Integer.parseInt(st.nextToken());
        int nCol = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        narrMap = new int[N][M];
        narrDice = new int[4][3];

        // 맵의 좌표 값 입력받자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                narrMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bReader.readLine());
        for (int i = 0; i < K; i++) {
            int nDirect = Integer.parseInt(st.nextToken());

            // 이동 고고
            int nSearchRow = nRow + dr[nDirect - 1];
            int nSearchCol = nCol + dc[nDirect - 1];

            if (nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= M)
                continue;

            MoveDice(nDirect - 1);

            // 바닥면이 0이면 ? 맵의 값을 넣어준다.
            if (narrMap[nSearchRow][nSearchCol] == 0) {
                narrMap[nSearchRow][nSearchCol] = narrDice[3][1];
            } else {
                // 아니면 칸에 쓰여있는 수가 주사위의 바닥면으로 복사되며, 칸은 0이된다.
                narrDice[3][1] = narrMap[nSearchRow][nSearchCol];
                narrMap[nSearchRow][nSearchCol] = 0;
            }

            nRow = nSearchRow;
            nCol = nSearchCol;

            bWriter.write(narrDice[1][1] + "\n");
        }

        bWriter.close();
    }

    private static void MoveDice(int nDirect) {

        // 주사위가 동쪽으로
        if (nDirect == 0) {
            int nTemp = narrDice[1][0];
            for (int i = 0; i < 2; i++)
                narrDice[1][i] = narrDice[1][i + 1];
            narrDice[1][2] = narrDice[3][1];
            narrDice[3][1] = nTemp;
        }
        // 서
        if (nDirect == 1) {
            int nTemp = narrDice[1][2];
            for (int i = 2; i > 0; i--)
                narrDice[1][i] = narrDice[1][i - 1];
            narrDice[1][0] = narrDice[3][1];
            narrDice[3][1] = nTemp;
        }

        // 북
        if (nDirect == 2) {
            int nTemp = narrDice[3][1];
            for (int i = 3; i > 0; i--)
                narrDice[i][1] = narrDice[i - 1][1];
            narrDice[0][1] = nTemp;
        }

        // 남
        if (nDirect == 3) {
            int nTemp = narrDice[0][1];
            for (int i = 0; i < 3; i++)
                narrDice[i][1] = narrDice[i + 1][1];
            narrDice[3][1] = nTemp;
        }

    }

}