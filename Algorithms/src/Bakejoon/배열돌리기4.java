package Bakejoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 배열돌리기4 {

    static int N, M, K, nMin;
    static int[][] narrData;
    static int[][] narrRotate;

    static int[][] narrCal;

    static int[] narrNums;
    static ArrayList<int[]> listOrders;

    static boolean[] barrNums;

    // 동, 서, 남, 북
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static boolean[][] barrVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bReader.readLine());

        N = Integer.parseInt(st.nextToken()); // Row
        M = Integer.parseInt(st.nextToken()); // Col
        K = Integer.parseInt(st.nextToken()); // Cal

        narrData = new int[N][M];
        narrRotate = new int[N][M];

        narrCal = new int[K][3];

        narrNums = new int[K];
        barrNums = new boolean[K];
        listOrders = new ArrayList<>();

        // 배열 입력 받자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < M; j++) {
                narrData[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 입력 받자
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bReader.readLine());
            for (int j = 0; j < 3; j++) {
                narrCal[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nMin = Integer.MAX_VALUE;

        // 배열 연산의 순서 경우의 수를 전부 탐색하기 위해
        // 연산 가능한 순서를 전부 갖고오자아
        GetOrders(0);

        // 가능한 경우를 전부 테스트하여 최소값을 뽑아내자
        for (int i = 0; i < listOrders.size(); i++) {
            // 원본 배열로 다시 돌려줍시다
            for (int j = 0; j < N; j++) {
                for (int a = 0; a < M; a++) {
                    narrRotate[j][a] = narrData[j][a];
                }
            }

            for (int j = 0; j < K; j++) {
                // 순서는 가능한 모든 경우의 수로 탐색
                int S = narrCal[listOrders.get(i)[j]][2];
                int nRow = narrCal[listOrders.get(i)[j]][0] - 1;
                int nCol = narrCal[listOrders.get(i)[j]][1] - 1;

                int nStartRow = nRow - S;
                int nStartCol = nCol - S;
                int nEndRow = nRow + S;
                int nEndCol = nCol + S;
                //System.out.println(j);

                RotateArray(nStartRow, nStartCol, nEndRow, nEndCol);
            }

            // 연산을 다 진행한 후에 최소값을 비교합니다 ^^
            for (int a = 0; a < N; a++) {
                int nSum = 0;
                for (int j = 0; j < M; j++) {
                    nSum += narrRotate[a][j];
                }
                if (nMin > nSum)
                    nMin = nSum;
            }
        }

        bWriter.write(String.valueOf(nMin));
        bWriter.close();

    }

    // 가능한 모든 경우의 수를 찾자
    private static void GetOrders(int nIndex) {
        // 기저 조건
        // K만큼 수를 저장했따
        if (nIndex == K) {
            int[] narrTemp = new int[K];

            // 늘 그랬듯 깊은 복사로 진행합니다아
            for (int i = 0; i < K; i++)
                narrTemp[i] = narrNums[i];
            listOrders.add(narrTemp);
        }

        // 재귀 조건
        // 0~K-1까지 값을 순서대로 저장
        for (int i = 0; i < K; i++) {
            if (!barrNums[i]) {
                barrNums[i] = true;
                narrNums[nIndex] = i;
                GetOrders(nIndex + 1);
                barrNums[i] = false;
            }
        }

    }

    // 배열을 회전시키자
    private static void RotateArray(int nStartRow, int nStartCol, int nEndRow, int nEndCol) {
        // TODO Auto-generated method stub
        int nLength = nEndCol - nStartCol;

        int nSearchRow = nStartRow;
        int nSearchCol = nStartCol;

        // 2차원 배열 깊은 복사
        int[][] narrCopy = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                narrCopy[i][j] = narrRotate[i][j];
        }

        // 회전 시켜버리자
        int nIndex = 0;
        while (nLength >= 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < nLength; j++) {
                    // 회전 값 넣어주고
                    narrCopy[nSearchRow + dr[nIndex]][nSearchCol + dc[nIndex]] = narrRotate[nSearchRow][nSearchCol];
                    // System.out.println(nSearchRow + " / before");

                    nSearchRow += dr[nIndex];
                    nSearchCol += dc[nIndex];
                }
                nIndex++;
                if (nIndex >= 4)
                    nIndex = 0;
            }
            nLength -= 2;
            nSearchRow += 1;
            nSearchCol += 1;
        }

        // 2차원 배열 깊은 복사
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++)
                narrRotate[i][j] = narrCopy[i][j];
        }

    }

}