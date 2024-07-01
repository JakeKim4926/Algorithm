package Bakejoon;

import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

class Snake {
    int m_nRow;
    int m_nCol;
    public Snake() {
        // TODO Auto-generated constructor stub
    }

    public Snake(int m_nRow, int m_nCol) {
        super();
        this.m_nRow = m_nRow;
        this.m_nCol = m_nCol;
    }
}

class SnakeInform {
    int m_nTime;
    char m_chDirection;

    public SnakeInform() {
        // TODO Auto-generated constructor stub
    }

    public SnakeInform(int m_nTime, char m_chDirection) {
        super();
        this.m_nTime = m_nTime;
        this.m_chDirection = m_chDirection;
    }
}


public class 뱀 {

    static int N, K, L, nDirection;
    static int[][] narrMap;

    final static int APPLE = 2;

    // 동,남,서,북
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {

        // TODO Auto-generated method stub
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bReader.readLine());
        narrMap = new int[N][N];

        K = Integer.parseInt(bReader.readLine());

        // 사과 위치 입력 받구
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());
            int nAppleRow = Integer.parseInt(st.nextToken())-1;
            int nAppleCol = Integer.parseInt(st.nextToken())-1;

            narrMap[nAppleRow][nAppleCol] = APPLE;
        }


        L = Integer.parseInt(bReader.readLine());
        SnakeInform[] info = new SnakeInform[L];
        // 뱀의 움직임에 대한 정보 입력 받자
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(bReader.readLine());

            int nTime = Integer.parseInt(st.nextToken());
            char chDirection = st.nextToken().charAt(0);

            info[i] = new SnakeInform(nTime, chDirection);
        }

        // 뱀과 시간의 초기 상태 설정
        Snake snake = new Snake();
        int nTime = 0;
        int nTimeIndex = 0;
        int nDirection = 0;

        // 뱀의 몸 상태 나타내는 boolean!
        boolean[][] barrSnake = new boolean[N][N];
        barrSnake[0][0] = true;

        Deque<Snake> queueSnake = new LinkedList<>();
        queueSnake.add(snake);

        // 벽에 부딪히거나 자신의 몸과 부딪히면 끝이 나
        while(!queueSnake.isEmpty()) {
            Snake snakeTemp = queueSnake.getFirst();

            // 뱀이 n초뒤에 방향 d를 바꾼다아
            if(nTimeIndex < L
                    && nTime == info[nTimeIndex].m_nTime) {
                // 동 남 서 북 으로 델타 방향 설정하여 90도 관계 성립!
                if(info[nTimeIndex].m_chDirection == 'L')
                    nDirection--;
                if(info[nTimeIndex].m_chDirection == 'D')
                    nDirection++;

                // 동 남 서 북 델타 사이즈에 맞추어 변경
                if(nDirection > 3)
                    nDirection = 0;
                if(nDirection < 0 )
                    nDirection = 3;

                nTimeIndex++;
            }

            nTime++;

            int nSearchRow = snakeTemp.m_nRow + dr[nDirection];
            int nSearchCol = snakeTemp.m_nCol + dc[nDirection];

            // 벽이나 지 몸에 충돌하였다아
            if( nSearchRow < 0 || nSearchCol < 0 || nSearchRow >= N || nSearchCol >= N ||
                    barrSnake[nSearchRow][nSearchCol])
                break;
            else {
                barrSnake[nSearchRow][nSearchCol]= true;

                queueSnake.addFirst(new Snake(nSearchRow, nSearchCol));
                // 사과가 있을 때는 제거 안한다.
                // 없을 때는 꼬리 제거
                if(narrMap[snakeTemp.m_nRow][snakeTemp.m_nCol] != APPLE) {
                    Snake tail = queueSnake.pollLast();
                    // 뱀의 몸이 더이상 아닌 배열 공간은 false로!
                    barrSnake[tail.m_nRow][tail.m_nCol] = false;
                } else
                    narrMap[snakeTemp.m_nRow][snakeTemp.m_nCol] = 0;
            }

            //nTime++;
        }

        bWriter.write(String.valueOf(nTime));
        bWriter.close();
    }
}