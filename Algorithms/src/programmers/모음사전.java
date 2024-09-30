package programmers;

public class 모음사전 {
    int[] stack;
    int answer;
    public int solution(String word) {
        answer = 0;
        stack = new int[5];

        char[] words = {'A', 'E', 'I', 'O', 'U'};

        dfs(0, words, word);

        return answer;
    }

    public boolean dfs(int index, char[] words, String word) {
        if(index >= 5)
            return false;

        for(int i = 0; i < 5; i++) {
            answer++;
            stack[index] = i;

            if(index == word.length()-1) {
                boolean find = true;
                for(int j = 0; j < word.length(); j++) {
                    if(words[stack[j]] != word.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if(find)
                    return true;
            }

            boolean result = dfs(index+1, words, word);
            if(result)
                return true;
        }

        return false;
    }
}
