package programmers;

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        if(answer > set.size())
            answer = set.size();

        return answer;
    }
}
