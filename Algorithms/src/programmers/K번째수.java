package programmers;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int size = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[size];

            int index = 0;
            for(int j = commands[i][0]-1; j < commands[i][1]; j++)
                temp[index++] = array[j];

            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }

        return answer;
    }
}
