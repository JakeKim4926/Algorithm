package programmers;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;

        int[] first = new int[money.length];
        int[] second = new int[money.length];

        for(int i = 0; i < money.length; i++) {
            first[i] = money[i];
            second[i] = money[i];
        }

        first[1] = -1;
        second[0] = -1;
        first[2] += first[0];

        for (int i = 3; i < money.length; i++) {
            first[i] += Math.max(first[i-2], first[i-3]);
            second[i] += Math.max(second[i-2], second[i-3]);
        }

        int first_max = Math.max(first[money.length-2], first[money.length-3]);
        int second_max = Math.max(second[money.length-1], second[money.length-2]);

        answer = Math.max(first_max,second_max);

        return answer;
    }
}
