package programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int rect = brown + yellow;

        for(int col = 3; col < rect; col++) {
            int row = rect / col;

            if(row > col)
                continue;

            int hypoYellow = (row-2)*(col-2);
            if(hypoYellow == yellow) {
                answer[0] = col;
                answer[1] = row;
            }

        }

        return answer;
    }
}
