package programmers;

import java.util.HashSet;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();

        char rule = words[0].charAt(0);
        for(int i = 0 ; i < words.length; i++) {
            if(set.contains(words[i]) || (rule != words[i].charAt(0))) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else
                set.add(words[i]);
            rule = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}
