package programmers;

public class 올바른괄호의갯수 {

    int N,answer;
    public int solution(int n) {
        answer = 0;
        N = n*2;

        dfs(0, 0);

        return answer;
    }

    public void dfs(int level, int open) {
        if(level == N) {
            if(open == 0)
                answer++;

            return;
        }

        if(open < 0)
            return;

        dfs(level+1, open+1);
        dfs(level+1, open-1);
    }
}
