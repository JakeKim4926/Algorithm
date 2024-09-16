package programmers;

public class 자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;

        // 확장된 자물쇠 배열을 만듦 (기존 자물쇠보다 2배 이상 확장된 크기로 만듦)
        int[][] expandedLock = new int[N + M * 2][N + M * 2];

        // 확장된 자물쇠의 중앙에 기존 자물쇠를 삽입
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                expandedLock[i + M][j + M] = lock[i][j];
            }
        }

        // 열쇠를 4번 회전하며 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateToRight(key); // 열쇠 회전
            // 확장된 자물쇠에 열쇠를 맞춰봄 (확장된 자물쇠 위에서 이동하며 확인)
            for (int i = 0; i <= expandedLock.length - M; i++) {
                for (int j = 0; j <= expandedLock[0].length - M; j++) {
                    if (isMatch(key, expandedLock, i, j, N)) {
                        return true; // 맞으면 true 반환
                    }
                }
            }
        }

        return false;
    }

    // 열쇠를 시계 방향으로 90도 회전시키는 함수
    public int[][] rotateToRight(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    // 열쇠와 자물쇠가 맞는지 확인하는 함수
    public boolean isMatch(int[][] key, int[][] expandedLock, int x, int y, int lockSize) {
        int M = key.length;

        // 열쇠를 자물쇠에 맞춰봄
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                expandedLock[x + i][y + j] += key[i][j];
            }
        }

        // 자물쇠의 중앙 부분이 모두 1이어야 함
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (expandedLock[i + M][j + M] != 1) {
                    // 열쇠를 적용했던 부분 원상복구
                    for (int a = 0; a < M; a++) {
                        for (int b = 0; b < M; b++) {
                            expandedLock[x + a][y + b] -= key[a][b];
                        }
                    }
                    return false; // 맞지 않으면 false
                }
            }
        }

        // 열쇠를 적용했던 부분 원상복구
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                expandedLock[x + i][y + j] -= key[i][j];
            }
        }

        return true; // 자물쇠가 맞으면 true 반환
    }
}
