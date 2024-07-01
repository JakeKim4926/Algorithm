package Bakejoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 파이프옮기기 {

    static boolean[][] barrVisited;
    static boolean[][] barrMap;
    static int N, nCount;

    // 동, 남, 동남만 가넝
    static int dr[] = { 0, 1, 1 };
    static int dc[] = { 1, 0, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken()); // Row

        barrVisited = new boolean[N][N];
        barrMap = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    barrMap[i][j] = true;
            }
        }

        nCount = 0;
        DFS(0, 1, 0);

        bWriter.write(String.valueOf(nCount));
        bWriter.write("\n");
        bWriter.flush();

        bWriter.close();

    }

    private static void DFS(int nRow, int nCol, int nPipeNum) {

        //System.out.println("Row : " + nRow + " / Col : " + nCol);

        if (nRow == N - 1 && nCol == N - 1) {
            nCount++;
            return;
        }

        // nPipeNum => 0:가로, 1:세로, 2:대각선
        for (int i = 0; i < 3; i++) {
            int nSearchRow = nRow + dr[i];
            int nSearchCol = nCol + dc[i];

            // 파이프는 무조건 45도만 회전 가능
            // 가로일 때 세로로 못가
            if (nPipeNum == 0 && i == 1)
                continue;
            // 세로일 때? 가로 못가
            if (nPipeNum == 1 && i == 0)
                continue;

            // 방문했거나 벽이거나 범위 이상이면 넘어가유
            if (nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= N
                    || barrMap[nSearchRow][nSearchCol] || barrVisited[nSearchRow][nSearchCol])
                continue;

            // 만약 대각을 가야한다면?
            // 가로 세로 방향에 벽이 없는지 봐야 돼~
            // 방문처리는 볼 필요 읎다
            if (i == 2) {
                for (int k = 0; k < 2; k++) {
                    int nDigRow = nRow + dr[k];
                    int nDigCol = nCol + dc[k];
                    if (nDigRow < 0 || nDigCol < 0 || nDigRow >= N || nDigCol >= N
                            || barrMap[nDigRow][nDigCol]) {
                        return;
                    }
                }
            }
            barrVisited[nSearchRow][nSearchCol] = true;
            DFS(nSearchRow, nSearchCol, i);
            barrVisited[nSearchRow][nSearchCol] = false;
        }
    }

}