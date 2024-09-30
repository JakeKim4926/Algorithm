package programmers;

public class 피로도 {
    int answer;
    int[] stack;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        answer = 0;

        stack = new int[dungeons.length];
        visit = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return answer;
    }

    public void dfs(int k, int index, int[][] dungeons) {
        int count = 0;
        if(index == dungeons.length) {
            for(int idx : stack) {
                if(k < dungeons[idx][0])
                    continue;

                k -= dungeons[idx][1];
                count++;
            }

            answer = Math.max(answer, count);

            return;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                stack[index] = i;
                dfs(k, index+1, dungeons);
                visit[i] = false;
            }
        }
    }
}
