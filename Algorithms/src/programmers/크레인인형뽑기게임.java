package programmers;

import java.util.*;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        boolean[][] bBoard = new boolean[board.length][board[0].length];

        Stack<Integer> pocket = new Stack<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0)
                    bBoard[i][j] = true;
            }
        }

        for(int i = 0 ; i< moves.length; i++) {
            int location = moves[i]-1;
            for(int j = 0; j < board.length; j++) {
                if(!bBoard[j][location]) {
                    if(pocket.isEmpty() || pocket.peek() != board[j][location]) {
                        pocket.push(board[j][location]);
                    }
                    else {
                        pocket.pop();
                        answer+=2;
                    }

                    bBoard[j][location] = true;
                    break;
                }
            }
        }

        return answer;
    }
}
