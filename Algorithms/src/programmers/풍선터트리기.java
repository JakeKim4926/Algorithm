package programmers;

public class 풍선터트리기 {

    public int solution(int[] a) {
        if (a.length == 1)
            return 1;

        int leftMin = a[0];
        int[] rightMin = new int[a.length];
        rightMin[a.length - 1] = a[a.length - 1];

        for (int i = a.length - 2; i > 0; i--)
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);

        int answer = 2;
        for (int i = 1; i < a.length - 1; i++) {
            if (!(leftMin < a[i] && rightMin[i] < a[i]))
                answer++;

            leftMin = Math.min(leftMin, a[i]);
        }

        return answer;
    }
}
