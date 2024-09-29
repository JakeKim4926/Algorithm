package programmers;

import java.util.HashSet;

public class 소수찾기 {
    int[] stack;
    boolean[] visit;
    int answer;
    HashSet<Integer> set;
    public int solution(String numbers) {
        answer = 0;
        set = new HashSet<>();

        int[] nums = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) {
            char ch = numbers.charAt(i);
            nums[i] = ch - '0';
        }

        for(int i = 0; i < numbers.length(); i++) {
            stack = new int[i+1];
            visit = new boolean[numbers.length()];
            dfs(0, nums);
        }

        return answer;
    }

    public void dfs(int index, int[] nums) {
        if(index == stack.length) {
            int num = 0;
            for(int i = 0 ; i < stack.length; i++)
                num = 10*num + stack[i];

            if(set.contains(num))
                return;

            set.add(num);
            if(isPrime(num))
                answer++;

            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                stack[index] = nums[i];
                dfs(index+1, nums);
                visit[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if(num <= 1)
            return false;

        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(num % i == 0)
                count++;

            if(count > 2)
                return false;
        }

        return true;
    }
}
