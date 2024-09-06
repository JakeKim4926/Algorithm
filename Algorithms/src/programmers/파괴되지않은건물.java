package programmers;

public class 파괴되지않은건물 {
    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;

            int m = board.length;
            int n = board[0].length;
            int[][] diff = new int[m + 1][n + 1];

            // 스킬 적용 (차분 배열을 사용)
            for (int[] s : skill) {
                int type = s[0];
                int r1 = s[1];
                int c1 = s[2];
                int r2 = s[3];
                int c2 = s[4];
                int degree = s[5];
                int value = (type == 1) ? -degree : degree;

                diff[r1][c1] += value;
                if (c2 + 1 < n) diff[r1][c2 + 1] -= value;
                if (r2 + 1 < m) diff[r2 + 1][c1] -= value;
                if (r2 + 1 < m && c2 + 1 < n) diff[r2 + 1][c2 + 1] += value;
            }

            // 누적 합 계산
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    diff[i][j] += diff[i][j - 1];
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    diff[i][j] += diff[i - 1][j];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] + diff[i][j] > 0) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }

}
